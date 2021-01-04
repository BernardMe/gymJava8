package org.third.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import static org.third.util.Constants.QINIU_JOBID_NA;
import static org.third.util.Constants.QINIU_SUGGESTION_NA;
import static org.third.util.Constants.QINIU_PERSISTENTID_NA;
import static org.third.util.Constants.TEACHER;

/**
 * <p>Title:检查七牛云上传状态工具类</p>
 * <p>Description:</p>
 * @author :  wangzhuo
 * @Description :
 * @Date:  2019-07-22 11:19
 */
@Slf4j
public class BatchStat {

    // 设置需要操作的账号的AK和SK
    private static String ACCESS_KEY = "AK";
    private static String SECRET_KEY = "SK";
    private static String BUCKET = "ijxapp";

    private static final String ENCODING = "UTF-8";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";


    private static String HOOKURL_TEACHER = null;
    private static String HOOKURL_PARENT = null;
    private static String PFOP_HOOKURL_TEACHER = null;
    private static String PFOP_HOOKURL_PARENT = null;

    /**
     * 根据视频url调用七牛云转码接口
     * //http://117.158.0.19:8515/qiniu/notify/msgPfop
     * //http://117.158.0.19:8515/qiniu/notify/materialPfop
     * @param oldUrl
     * @return
     */
    public static String videoTranscodingCallback(String oldUrl, String role) throws QiniuException {
        //hookUrl
        String hookUrl;
        if (TEACHER.equals(role)) {
            hookUrl = (null == PFOP_HOOKURL_TEACHER) ? "http://117.158.0.19:8515/qiniu/notify/msgPfop" : PFOP_HOOKURL_TEACHER;
        } else {
            hookUrl = (null == PFOP_HOOKURL_PARENT) ? "http://117.158.0.19:8515/qiniu/notify/msgPfop" : PFOP_HOOKURL_PARENT;
        }
        //基础参数
        /*String BUCKET = "java-BUCKET";          //存储空间名称
        String key = "mpeg_4_type.mp4";         //存储空间中视频的文件名称
        String newKey = "H264_type.mp4";        //转码后，另存的文件名称
        String pipeline = "admin_merge_radio";  //处理队列

        String saveAs = UrlSafeBase64.encodeToString(BUCKET + ":" + newKey);        //saveas接口 参数
        String fops = "avthumb/mp4/vcodec/libx264|saveas/" + saveAs;                //处理命令 avthumb 和 saveas 通过管道符 |  进行连接*/

        //转码后，另存的文件名称
        String newKey = String.format("MaterialVideo/pfop/%s_640x360_MP4.mp4", UUID.randomUUID().toString());

        try {
            //设置转码的队列
            String pipeline = "QYLVideo";

            //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
            String urlbase64 = UrlSafeBase64.encodeToString(String.format("%s:%s", BUCKET, newKey));
            //设置转码操作参数
            String fops = "avthumb/mp4/s/640x360/vb/1.25m".concat("|saveas/").concat(urlbase64);

            //密钥配置
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            //创建转码对象
            OperationManager operationManager = new OperationManager(auth, new Configuration(Zone.zone0()));

            //执行转码和另存 操作
            String persistentId = operationManager.pfop(BUCKET, oldUrl, fops, pipeline, hookUrl);
            if (null == persistentId) {
                persistentId = QINIU_PERSISTENTID_NA;
            }
            return persistentId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据视频url调用七牛云审核回调接口
     * //http://117.158.0.19:8515/qiniu/notify/msgAuditStatus
     * //http://117.158.0.19:8515/qiniu/notify/materialAuditStatus
     * @param imageUrl
     * @param role
     * @return
     */
    public static String newAuditJobCallback(String imageUrl, String role) throws QiniuException {
        String hookUrl;
        if (TEACHER.equals(role)) {
            hookUrl = (null == HOOKURL_TEACHER) ? "http://117.158.0.19:8515/qiniu/notify/msgAuditStatus" : HOOKURL_TEACHER;
        } else {
            hookUrl = (null == HOOKURL_PARENT) ? "http://117.158.0.19:8515/qiniu/notify/materialAuditStatus" : HOOKURL_PARENT;
        }
        //基础参数拼接
        String url = "http://ai.qiniuapi.com/v3/video/censor";
        String host = "ai.qiniuapi.com";
        String body = "{ \"data\": { \"uri\": \""+imageUrl+"\" }, \"params\": { \"scenes\": [ \"pulp\", \"terror\", \"politician\" ], \"hook_url\":  \""+hookUrl+"\" } }";
        String contentType = "application/json";
        String method = "POST";
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String qiniuToken = "Qiniu " + auth.signRequestV2(url, method, body.getBytes(), contentType);
        log.info("url={},body={},qiniuToken={}",url,body,qiniuToken);
        //头部部分
        StringMap header = new StringMap();
        header.put("Host",host);
        header.put("Authorization",qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        try {
            Response response = client.post(url, body.getBytes(), header, contentType);
            String bodyString = response.bodyString();
            log.info("response result={}", bodyString);
            JSONObject resultObj = JSON.parseObject(bodyString);
            String jobId = null;
            if (null != resultObj) {
                jobId = StringUtils.isNotEmpty(resultObj.getString("job")) ? resultObj.getString("job") : QINIU_JOBID_NA;
            } else {
                jobId = QINIU_JOBID_NA;
            }
            return jobId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据视频url获取七牛云审核jobId
     *
     * @param imageUrl
     * @return
     */
    public static String getAuditJobId(String imageUrl) throws QiniuException {
        //基础参数拼接
        String url = "http://ai.qiniuapi.com/v3/video/censor";
        String host = "ai.qiniuapi.com";
        String body = "{ \"data\": { \"uri\": \""+imageUrl+"\" }, \"params\": { \"scenes\": [ \"pulp\", \"terror\", \"politician\" ] } }";
        String contentType = "application/json";
        String method = "POST";
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String qiniuToken = "Qiniu " + auth.signRequestV2(url, method, body.getBytes(), contentType);
        log.info("url={},body={},qiniuToken={}",url,body,qiniuToken);
        //头部部分
        StringMap header = new StringMap();
        header.put("Host",host);
        header.put("Authorization",qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        try {
            Response response = client.post(url, body.getBytes(), header, contentType);
            String bodyString = response.bodyString();
            log.info("response result={}", bodyString);
            JSONObject resultObj = JSON.parseObject(bodyString);
            String jobId = null;
            if (null != resultObj) {
                jobId = StringUtils.isNotEmpty(resultObj.getString("job")) ? resultObj.getString("job") : QINIU_JOBID_NA;
            } else {
                jobId = QINIU_JOBID_NA;
            }
            return jobId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据jobId查询七牛云视频审核结果
     *
     * @param jobId
     * @return
     */
    public static String checkJob(String jobId) throws QiniuException {
        //基础参数拼接
        String url = String.format("http://ai.qiniuapi.com/v3/jobs/video/%s", jobId);
        String host = "ai.qiniuapi.com";
        String method = "GET";
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        StringMap map = auth.authorizationV2(url);
        String qiniuToken = String.valueOf(map.get("Authorization"));
        log.info("url={},,qiniuToken={}", url, qiniuToken);
        //头部部分
        StringMap header = new StringMap();
        header.put("Host",host);
        header.put("Authorization",qiniuToken);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        try {
            Response response = client.get(url, header);
            String bodyString = response.bodyString();
            log.info("response result={}", bodyString);
            JSONObject checkResult = JSONObject.parseObject(bodyString);
            JSONObject resultObj = checkResult.getJSONObject("result");
            String suggestion = null;
            if (null != resultObj) {
                suggestion = resultObj.getJSONObject("result").getString("suggestion");
            } else {
                suggestion = QINIU_SUGGESTION_NA;
            }
            return suggestion;
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据key检查七牛云上传状态
     * 注意:单次批量请求的文件数量不得超过1000
     * @param keyList
     * @return
     */
    public static BatchStatus[] checkStat(String[] keyList) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        /* 七牛上传不能自动获取区域，只能手动设置 */
        Zone z = Zone.zone0();
        //构造一个带指定Zone对象的配置类
        Configuration c = new Configuration(z);
        BucketManager bucketManager = new BucketManager(auth,c);

        BucketManager.BatchOperations batchOperations = new BucketManager.BatchOperations();
        batchOperations.addStatOps(BUCKET, keyList);
        Response response = bucketManager.batch(batchOperations);
        BatchStatus[] batchStatusList = response.jsonToObject(BatchStatus[].class);

        return batchStatusList;
    }

    /**
     * 根据key删除七牛云文件
     * 注意:单次批量请求的文件数量不得超过1000
     * @param keyList
     * @return
     */
    public static BatchStatus[] deleteQiNiuFile(String[] keyList) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        /* 七牛上传不能自动获取区域，只能手动设置 */
        Zone z = Zone.zone0();
        //构造一个带指定Zone对象的配置类
        Configuration c = new Configuration(z);
        BucketManager bucketManager = new BucketManager(auth,c);

        BucketManager.BatchOperations batchOperations = new BucketManager.BatchOperations();
        batchOperations.addDeleteOp(BUCKET, keyList);
        Response response = bucketManager.batch(batchOperations);
        BatchStatus[] batchStatusList = response.jsonToObject(BatchStatus[].class);

        return batchStatusList;
    }

    /**
     * 根据文件检查Etag哈希算法value值
     * 注意:
     * @param filePath
     */
    public static String checkHashValue(String filePath) throws QiniuException {

        if (StringUtils.isNotBlank(filePath)) {
            log.debug("Usage: qetag <filename>");
        } else {
            QETag etag = new QETag();
            try {
                log.debug("hash_value: {}", etag.calcETag(filePath));
            } catch (NoSuchAlgorithmException ex) {
                log.error("Unsupported algorithm: {}", ex.getMessage());
            } catch (IOException ex) {
                log.error("IO Error: {}", ex.getMessage());
            }
        }
        return null;
    }
}
package org.third.util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import lombok.extern.slf4j.Slf4j;

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
    private static String ACCESS_KEY = "UEAq301iSGQxYFtbTH0WaVm2zGKCqxg80Qy88hTs";
    private static String SECRET_KEY = "GPC8DZuXOi7Y2fOPJr5blm5L1vQwychRXQvU1dr2";
    private static String bucket = "ijxapp";

    private static final String ENCODING = "UTF-8";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    /**
     * 根据视频url获取七牛云审核jobId
     *
     * @param imageUrl
     * @return
     */
    public static JSONObject checkImage(String imageUrl) {
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
            log.info("response result={}",response.bodyString());
            JSONObject checkResult = JSON.parseObject(response.bodyString());
            return checkResult;
        } catch (QiniuException e) {
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
    public static JSONObject checkJob(String jobId) {
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
            log.info("response result={}",response.bodyString());
            JSONObject checkResult = JSON.parseObject(response.bodyString());
            return checkResult;
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
        batchOperations.addStatOps(bucket, keyList);
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
        batchOperations.addDeleteOp(bucket, keyList);
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
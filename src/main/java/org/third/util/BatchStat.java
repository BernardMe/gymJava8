package org.third.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.sun.crypto.provider.HmacMD5;
import okhttp3.Headers;
import org.apache.commons.lang3.StringUtils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static javax.xml.crypto.dsig.DigestMethod.SHA1;

/**
 * <p>Title:检查七牛云上传状态工具类</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 郑州家音顺达通讯有限公司 2019</p>
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
     * 根据key检查七牛云审核状态
     * 注意:单次请求
     * @param url
     * @return
     */
    public static String getAuditStatus(String url, String token) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        /* 七牛上传不能自动获取区域，只能手动设置 */
        Zone z = Zone.zone0();
        //构造一个带指定Zone对象的配置类
        Configuration c = new Configuration(z);

        OkHttpUtils httpUtils = OkHttpUtils.getInstance();



        HashMap map = new HashMap();
        HashMap data = new HashMap();
        data.put("uri", url);
        HashMap params = new HashMap();
        params.put("scenes", new String[]{"pulp", "terror", "politician"});
        map.put("data", data);
        map.put("params", params);

        String jsonString = JSONObject.toJSONString(map);


        String resultStr = httpUtils.doPostWithHeadersJson("http://ai.qiniuapi.com/v3/video/censor", "Authorization", token, jsonString);

        log.info(resultStr);


        return resultStr;
    }

   /**
     * 根据key检查七牛云审核状态
     * 注意:单次请求
     * @param
     * @return
     */
    public static String buildAuthString(String method, String path, String host) throws QiniuException, NoSuchAlgorithmException,
            InvalidKeyException, UnsupportedEncodingException {
        String data = String.format("data = %s %s?<RawQuery>\nHost: %s\n\n", method, path, host);
        /* 七牛上传不能自动获取区域，只能手动设置 */

        SecretKeySpec signingKey = new SecretKeySpec(SECRET_KEY.getBytes(ENCODING), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        byte[] signData = mac.doFinal(data.getBytes(ENCODING));
        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        String signature = urlEncoder.encodeToString(signData);


        log.info(signature);

        String qiniuToken = String.format("Qiniu %s:%s", ACCESS_KEY, signature);
        return qiniuToken;
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
package org.third.util;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.learnit.support.MyException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

@Slf4j
public class OkHttpUtils {

    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    private static final byte[] LOCKER = new byte[0];
    private static OkHttpUtils instance;
    private OkHttpClient okHttpClient;

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//10秒连接超时
                .writeTimeout(10, TimeUnit.SECONDS)//10m秒写入超时
                .readTimeout(20, TimeUnit.SECONDS)//10秒读取超时
                .build();
    }

    public static OkHttpUtils getInstance() {
        if (instance == null) {
            synchronized (LOCKER) {
                if (instance == null) {
                    instance = new OkHttpUtils();
                }
            }
        }
        return instance;
    }

    public String doGet(String url){
        if (isBlankUrl(url)){
            return null;
        }
        Request request = getRequestForGet(url);
        return commonRequest(request);
    }

    public String doGet(String url, HashMap<String, String> params){
        if (isBlankUrl(url)){
            return null;
        }
        Request request = getRequestForGet(url, params);
        return commonRequest(request);
    }

    public String doPostJson(String url, String json){
        if (isBlankUrl(url)){
            return null;
        }
        Request request = getRequestForPostJson(url, json);
        return commonRequest(request);
    }

    public String doPostWithHeadersJson(String url, String key, String value, String json){
        if (isBlankUrl(url)){
            return null;
        }
        Request request = getRequestHeadersForPostJson(url, key, value, json);
        return commonRequest(request);
    }

    public String doPostForm(String url, Map<String, String> params){
        if (isBlankUrl(url)) {
            return null;
        }
        Request request = getRequestForPostForm(url, params);
        return commonRequest(request);
    }

    private Boolean isBlankUrl(String url){
        if (StringUtils.isBlank(url)){
            log.info("url is not blank");
            return true;
        }else{
            return false;
        }
    }

    private String commonRequest(Request request){
        String re = "";
        try {
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()){
                re = response.body().string();
                log.info("request url:{}", request.url().toString());
            }else {
                log.info("request failure url:{};message:{}", request.url().toString(), response.message());
            }
        }catch (ConnectException e){
            log.error("第三方服务连接超时", e);
            throw new MyException("第三方服务连接超时");
        }
        catch (SocketTimeoutException e){
            log.error("第三方服务响应超时", e);
            throw new MyException("第三方服务响应超时");
        }
        catch (Exception e){
            log.error("request execute failure", e);
        }
        return re;
    }

    private Request getRequestForPostJson(String url, String json) {
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return request;
    }

    private Request getRequestHeadersForPostJson(String url, String key, String value, String json) {
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader(key, value)
                .post(body)
                .build();
        return request;
    }


    private Request getRequestForPostForm(String url, Map<String, String> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.addEncoded(entry.getKey(), entry.getValue());
            }
        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return request;
    }

    private Request getRequestForGet(String url, HashMap<String, String> params) {
        Request request = new Request.Builder()
                .url(getUrlStringForGet(url, params))
                .build();
        return request;
    }

    private Request getRequestForGet(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return request;
    }

    private String getUrlStringForGet(String url, HashMap<String, String> params) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(url);
        urlBuilder.append("?");
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                try {
                    urlBuilder.append("&").append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (Exception e) {
                    urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
        }
        return urlBuilder.toString();
    }

    public static void main(String[] args) {
        //String url = "http://172.18.9.166:8080/user/login.kq";
        //String url = "http://172.18.9.166:8899/demo/postByMap?loginName=admin&loginPassword=Hans1107laser";
        String url = "http://101.133.147.220:8079/ocrGatewayAction_ocr";
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("vendor","learnIt");
        map1.put("vendorKey","rejF40924sUs311TJbLoN");
        map1.put("url","https://img.967111.com/import-article-taro/pigai/2020/02/14/22/25/28sXJU0vIM4.jpg");
        String result = OkHttpUtils.getInstance().doPostForm(url, map1);
        System.out.println("result = " + result);

    }
}
package org.third;

import com.qiniu.common.QiniuException;
import org.third.util.BatchStat;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestQiniuCensor {



    public static void main(String[] args) {
        String url = "http://img.967111.com/1606108459312MaterialVideoBeauty_1920x1080_30fps_420_8bit_AVC_MP4.mp4";
        String token = null;
        String s = null;
        try {
            token = BatchStat.buildAuthString("POST", "/v3/video/censor", "ai.qiniuapi.com");
            s = BatchStat.getAuditStatus(url, token);
        } catch (QiniuException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        System.out.println("s >>>" + s);

    }
}

package org.third;

import com.qiniu.common.QiniuException;
import org.third.util.BatchStat;


public class TestQiniuCensor {



    public static void main(String[] args) {
//        String url = "http://img.967111.com/1606108459312MaterialVideoBeauty_1920x1080_30fps_420_8bit_AVC_MP4.mp4";
//        String token = null;
//        String s = null;
//        try {
//            token = BatchStat.buildAuthString("POST", "/v3/video/censor", "ai.qiniuapi.com");
//            s = BatchStat.getAuditStatus(url, token);
//        } catch (QiniuException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("s >>>" + s);

        String url = "http://img.967111.com/Ft6rg8JIgMM27XWgREeD2rrnl7rK";
        BatchStat.checkImage(url);
    }
}

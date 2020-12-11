package org.third;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.qiniu.common.QiniuException;
import org.third.util.BatchStat;

public class TestQiniuCensor {



//    public static void main(String[] args) {
//        String url = "http://img.967111.com/1606108459312MaterialVideoBeauty_1920x1080_30fps_420_8bit_AVC_MP4.mp4";
//        String token = null;
//        String s = null;
//        try {
//            s = BatchStat.getAuditStatus();
//        } catch (QiniuException e) {
//            e.printStackTrace();
//        }
//
//
//
//    }

    public static void main(String[] args) throws QiniuException {

        String url = "http://img.967111.com/1606108459312MaterialVideoBeauty_1920x1080_30fps_420_8bit_AVC_MP4.mp4";
        String jobId = BatchStat.getAuditJobId(url);
        System.out.println(String.format("\n\n\n>>>\njobId=%s", jobId));

//        String jobId = "5fcf5c7780df3d0008271269";
//        String suggestion = BatchStat.checkJob(jobId);
//
//        System.out.println(String.format("\n\n\n>>>\nsuggestion=%s", suggestion));

//        System.out.println(String.format("\n\n\n>>>\nTimestamp=%s", LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
    }
}

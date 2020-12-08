package org.third;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import org.third.util.BatchStat;


public class TestQiniuCensor {



    public static void main(String[] args) {
        //根据视频url获取七牛云审核jobId
        String url = "http://img.967111.com/Ft6rg8JIgMM27XWgREeD2rrnl7rK";
        BatchStat.checkImage(url);

        //根据jobId查询七牛云视频审核结果
        String jobId = "5fcdf7dbe74cf10008e23317";
        JSONObject jsonObject = BatchStat.checkJob(jobId);
        JSONObject resultObj = jsonObject.getJSONObject("result").getJSONObject("result");
        String suggestion = resultObj.getString("suggestion");
        System.out.println(String.format("\n\n\n>>>\nsuggestion=%s", suggestion));
    }
}

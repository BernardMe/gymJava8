package org.third.service;

import org.learnit.support.MyException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import static org.third.util.Constants.*;

@Slf4j
public class QiniuCallbackNotifyService {


    public void dealMsgAuditStatusNotify(JSONObject param) throws MyException {
        String persisitentId = null;
        try {
            log.info("七牛回调response param={}", param);
            //获取审核项
            JSONObject resultObj = (JSONObject) param.getJSONObject("result");
            String jobId =  param.getString("id");
            // 获取审核状态
            String suggestion = null;
            if (null != resultObj) {
                suggestion = resultObj.getJSONObject("result").getString("suggestion");
            } else {
                suggestion = QINIU_SUGGESTION_NA;
            }
            Integer auditStatus = null;
            if (!QINIU_SUGGESTION_NA.equals(suggestion)) {
                auditStatus = QINIU_SUGGESTION_PASS.equals(suggestion) ? 1 : 2;
            } else {
                auditStatus = 0;
            }
            if (null != jobId) {
//                //MessageContent mc = messageContentService.selectByJobId(jobId);
//                if (null !=  mc) {
//                    mc.setAuditStatus(auditStatus);
//                    //触发转码
//                    persisitentId = BatchStat.videoTranscodingCallback(mc.getImageUrls().substring(PREFIX_EASY_URL.length()), TEACHER);
//                    mc.setPersistentId(persisitentId);
//                    //保存
//                    messageContentService.update(mc);
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("处理视频审核结果回调失败");
        }
    }


    public void dealMsgPfopNotify(JSONObject param) throws MyException {
        try {
            log.info("七牛Pfop回调response param={}", param);
            //获取转码项
            String persistentId =  param.getString("id");
            JSONArray items = (JSONArray) param.getJSONArray("items");
            // 获取转码状态
            Integer code = null;
            if (null != items && items.size() > 0) {
                code = ((JSONObject) items.get(0)).getInteger("code");
            } else {
                code = QINIU_PFOP_CODE_NA;
            }
            String easyUrl = null;
            if (null != items && items.size() > 0 && QINIU_PFOP_CODE_SUCCESS.equals(code)) {
                easyUrl = PREFIX_EASY_URL.concat(((JSONObject) items.get(0)).getString("key"));
            } else {
                easyUrl = null;
            }
            if (null != persistentId) {
//                MessageContent mc = messageContentService.selectByPersistentId(persistentId);
//                if (null !=  mc) {
//                    mc.setEasyUrl(easyUrl);
//                    messageContentService.update(mc);
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("处理七牛Pfop回调失败");
        }
    }

}
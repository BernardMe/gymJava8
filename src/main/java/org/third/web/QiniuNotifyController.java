package org.third.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.third.service.QiniuCallbackNotifyService;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description 七牛视频审核结果回调
 * @Author wangzhuo
 * @Date 20201225
 **/
@RestController
@RequestMapping("/qiniu/notify")
public class QiniuNotifyController extends UrlFilenameViewController {

    @Autowired
    private QiniuCallbackNotifyService qiniuCallbackNotifyService;

    /**
     * @description 处理视频审核结果回调方法
     * @param param
     * @return Object
     * @author wangzhuo
     * @date 20201225
     */
    @ResponseBody
    @RequestMapping("msgAuditStatus")
    public Object dealMsgAuditStatusNotify(@RequestBody JSONObject param) {
        JSONObject params = param;
        qiniuCallbackNotifyService.dealMsgAuditStatusNotify(params);
        return new ModelAndView();
    }


    /**
     * @description 处理视频转码结果回调方法
     * @param param
     * @return Object
     * @author wangzhuo
     * @date 20201225
     */
    @ResponseBody
    @RequestMapping("msgPfop")
    public Object dealMsgPfopNotify(@RequestBody JSONObject param) {
        JSONObject params = param;
        qiniuCallbackNotifyService.dealMsgPfopNotify(params);
        return new ModelAndView();
    }


}

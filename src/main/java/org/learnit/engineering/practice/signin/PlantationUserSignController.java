package org.learnit.engineering.practice.signin;


import org.learnit.engineering.practice.web.common.EntityResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 种植园签到接口Controller
 * @Author wangzhuo
 * @Date 20240716
 */
@RestController
@RequestMapping("/sign/wb")
public class PlantationUserSignController {

    @Resource
    private PlantationUserSignService signService;

//    @ApiOperation("种植园用户签到，不可以补签")
//    @PostMapping("/sign")
//    public EntityResult<PlantationUserSignPO> doSign(@UserEnvironmentParam UserEnvironmentInfo envir
//            , @UserBuyContextParam UserBuyContext context
//            , @UserBaseParam UserBaseInfo userInfo, String dateStr) {
//        return signService.doSign(envir, context, userInfo, dateStr);
//    }
//
//    @ApiOperation("种植园获取用户当天签到情况")
//    @GetMapping("/today")
//    public EntityResult<PlantationUserSignPO> getSignByDate(@UserEnvironmentParam UserEnvironmentInfo envir
//            , @UserBuyContextParam UserBuyContext context
//            , @UserBaseParam UserBaseInfo userInfo, String dateStr) {
//        return signService.getSignByDate(envir, context, userInfo, dateStr);
//    }

}

package org.learnit.engineering.practice.signin;


import com.common.sdk.api.web.http.common.EntityResult;
import com.zzjdyf.pt.entity.po.user.plantation.PlantationUserSignPO;
import com.zzjdyf.pt.service.user.entity.UserBaseInfo;
import com.zzjdyf.pt.service.user.entity.UserBuyContext;
import com.zzjdyf.pt.service.user.entity.UserEnvironmentInfo;

/**
 * 种植园用户签到Service
 * @author wangzhuo
 * @date 20240716
 */
public interface PlantationUserSignService {

    /**
     * 2.1用户签到（不可以补签）
     *
     * @param envir  环境信息
     * @param context 上下文信息
     * @param userInfo  用户信息
     * @param dateStr 查询的日期，默认当天 yyyy-MM-dd
     * @return 连续签到次数和总签到次数
     */
    EntityResult<PlantationUserSignPO> doSign(UserEnvironmentInfo envir, UserBuyContext context, UserBaseInfo userInfo, String dateStr);

    /**
     * 2.2 获取用户当天签到情况
     *
     * @param envir
     * @param context
     * @param userInfo
     * @param dateStr 查询的日期，默认当天 yyyy-MM-dd
     * @return 当天签到情况，连续签到次数和总签到次数
     */
    EntityResult<PlantationUserSignPO> getSignByDate(UserEnvironmentInfo envir, UserBuyContext context, UserBaseInfo userInfo, String dateStr);
}

package org.learnit.engineering.practice.signin;

import org.learnit.engineering.practice.user.entity.UserBaseInfo;
import org.learnit.engineering.practice.user.entity.UserEnvironmentInfo;
import org.learnit.engineering.practice.web.common.EntityResult;

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
     * @param userInfo  用户信息
     * @param dateStr 查询的日期，默认当天 yyyy-MM-dd
     * @return 连续签到次数和总签到次数
     */
    EntityResult<PlantationUserSignPO> doSign(UserEnvironmentInfo envir, UserBaseInfo userInfo, String dateStr);

    /**
     * 2.2 获取用户当天签到情况
     *
     * @param envir
     * @param userInfo
     * @param dateStr 查询的日期，默认当天 yyyy-MM-dd
     * @return 当天签到情况，连续签到次数和总签到次数
     */
    EntityResult<PlantationUserSignPO> getSignByDate(UserEnvironmentInfo envir, UserBaseInfo userInfo, String dateStr);
}

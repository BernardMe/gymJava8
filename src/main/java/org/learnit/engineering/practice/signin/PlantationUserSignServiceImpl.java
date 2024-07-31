package org.learnit.engineering.practice.signin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.learnit.engineering.practice.tools.util.ResultUtil;
import org.learnit.engineering.practice.user.entity.UserBaseInfo;
import org.learnit.engineering.practice.user.entity.UserEnvironmentInfo;
import org.learnit.engineering.practice.web.common.EntityResult;
import org.learnit.engineering.practice.web.common.OptResult;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 种植园用户签到Service实现类
 * @author wangzhuo
 * @date 20240716
 */
@Service
public class PlantationUserSignServiceImpl implements PlantationUserSignService {

    @Resource(name = "stringRedis")
    private RedisTemplate redis;

    public EntityResult<PlantationUserSignPO> doSign(UserEnvironmentInfo envir, UserBaseInfo userInfo, String dateStr) {
        PlantationUserSignPO result = new PlantationUserSignPO();
        OptResult opt = new OptResult();
        // 获取日期
        Date date = getDate(dateStr);
        // 获取日期对应的天数，多少号
        int day = DateUtil.dayOfMonth(date) - 1; // 从 0 开始
        // 构建 Redis Key
        String signKey = buildSignKey(userInfo.getUserId(), date);
        // 查看指定日期是否已签到
        boolean isSigned = redis.opsForValue().getBit(signKey, day);
        if (isSigned) {
            opt.setMessage("当前日期已完成签到，无需再签");
            opt.setOptCode(300);
            opt.setSuccess(false);
            return ResultUtil.entResult(opt, result);
        }
        // 签到
        redis.opsForValue().setBit(signKey, day, true);
        // 根据当前日期统计签到次数
        Date today = new Date();
        // 统计连续签到次数
        int continuous = getContinuousSignCount(userInfo.getUserId(), today);
        // 统计总签到次数
        long count = getSumSignCount(userInfo.getUserId(), today);
        opt.setMessage("签到成功");
        opt.setOptCode(200);
        opt.setSuccess(true);
        result.setContinuous(continuous);
        result.setCount(new Long(count).intValue());
        return ResultUtil.entResult(opt, result);
    }

    public EntityResult<PlantationUserSignPO> getSignByDate(UserEnvironmentInfo envir, UserBaseInfo userInfo, String dateStr) {
        PlantationUserSignPO result = new PlantationUserSignPO();
        OptResult opt = new OptResult();
        // 获取日期
        Date date = getDate(dateStr);
        // 获取日期对应的天数，多少号
        int day = DateUtil.dayOfMonth(date) - 1; // 从 0 开始
        // 构建 Redis Key
        String signKey = buildSignKey(userInfo.getUserId(), date);
        // 查看是否已签到
        boolean isSigned = redis.opsForValue().getBit(signKey, day);
        // 根据当前日期统计签到次数
        Date today = new Date();
        // 统计连续签到次数
        int continuous = getContinuousSignCount(userInfo.getUserId(), today);
        // 统计总签到次数
        long count = getSumSignCount(userInfo.getUserId(), today);
        opt.setOptCode(200);
        opt.setSuccess(true);
        result.setToday(isSigned);
        result.setContinuous(continuous);
        result.setCount(new Long(count).intValue());
        return ResultUtil.entResult(opt, result);
    }

    /**
     * 统计连续签到次数
     *
     * @param userId 用户ID
     * @param date   查询的日期
     * @return
     */
    private int getContinuousSignCount(String userId, Date date) {
        // 获取日期对应的天数，多少号，假设是 31
        int dayOfMonth = DateUtil.dayOfMonth(date);
        // 构建 Redis Key
        String signKey = buildSignKey(userId, date);
        // e.g. bitfield user:sign:5:202103 u31 0
        BitFieldSubCommands bitFieldSubCommands = BitFieldSubCommands.create()
                .get(BitFieldSubCommands.BitFieldType.unsigned(dayOfMonth))
                .valueAt(0);
        // 获取用户从当前日期开始到 1 号的所有签到状态
        List<Long> list = redis.opsForValue().bitField(signKey, bitFieldSubCommands);
        if (list == null || list.isEmpty()) {
            return 0;
        }
        // 连续签到计数器
        int signCount = 0;
        long v = list.get(0) == null ? 0 : list.get(0);
        // 位移计算连续签到次数
        for (int i = dayOfMonth; i > 0; i--) {// i 表示位移操作次数
            // 右移再左移，如果等于自己说明最低位是 0，表示未签到
            if (v >> 1 << 1 == v) {
                // 用户可能当前还未签到，所以要排除是否是当天的可能性
                // 低位 0 且非当天说明连续签到中断了
                if (i != dayOfMonth) break;
            } else {
                // 右移再左移，如果不等于自己说明最低位是 1，表示签到
                signCount++;
            }
            // 右移一位并重新赋值，相当于把最低位丢弃一位然后重新计算
            v >>= 1;
        }
        return signCount;
    }

    /**
     * 统计总签到次数
     *
     * @param userId 用户ID
     * @param date   查询的日期
     * @return
     */
    private Long getSumSignCount(String userId, Date date) {
        // 构建 Redis Key
        String signKey = buildSignKey(userId, date);
        // e.g. BITCOUNT user:sign:5:202103
        return (Long) redis.execute(
                (RedisCallback<Long>) con -> con.bitCount(signKey.getBytes())
        );
    }

    /**
     * 获取日期
     *
     * @param dateStr yyyy-MM-dd
     * @return
     */
    private Date getDate(String dateStr) {
        return StrUtil.isBlank(dateStr) ?
                new Date() : DateUtil.parseDate(dateStr);
    }

    /**
     * 构建 Redis Key - user:sign:userId:yyyyMM
     *
     * @param userId 用户ID(32位字符串)
     * @param date   日期
     * @return
     */
    private String buildSignKey(String userId, Date date) {
        return String.format("user:sign:%s:%s", userId,
                DateUtil.format(date, "yyyyMM"));
    }

}


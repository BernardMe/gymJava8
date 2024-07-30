package org.learnit.engineering.practice.signin;

/**
 * 签到接口返回PO
 * @author wangzhuo
 * @date 20240716
 */
public class PlantationUserSignPO {
    /**
     * 今日是否签到
     */
    private Boolean today;
    /**
     * 统计连续签到次数
     */
    private Integer continuous;
    /**
     * 统计总签到次数
     */
    private Integer count;

    public Boolean getToday() {
        return today;
    }

    public void setToday(Boolean today) {
        this.today = today;
    }

    public Integer getContinuous() {
        return continuous;
    }

    public void setContinuous(Integer continuous) {
        this.continuous = continuous;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}


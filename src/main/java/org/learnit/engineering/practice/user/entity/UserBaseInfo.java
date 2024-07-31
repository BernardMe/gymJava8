package org.learnit.engineering.practice.user.entity;

/**
 * 当当前版本是ADMIN时表示是运营端临时生成使用。
 * @author Administrator
 *
 */
public class UserBaseInfo {
	private String userId;
	private String userToken;
	private String nickName;
	private String versionCode;
	private String headImg;
	private String phoneNumber;
	//是否会员
	private Boolean isVip;
	//会员卡号
	private String vipCardNo;
	//是否测试员
	private Boolean isTestUser;
	//是否分销员，空表示false。
	//修改Getter。
	private Boolean isDistributor;
	//分销员主键
	private Integer distributorId;
	//上级分销员主键，本身是分销员的话，无上级分销员，自身就是自身的分销员，且不可被覆盖。
	//修改Getter。
	private Integer superDistributorId;
	public UserBaseInfo() {
		isTestUser = false;
	}
	public Boolean getIsTestUser() {
		return isTestUser;
	}
	public void setIsTestUser(Boolean isTestUser) {
		this.isTestUser = isTestUser;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVipCardNo() {
		return vipCardNo;
	}
	public void setVipCardNo(String vipCardNo) {
		this.vipCardNo = vipCardNo;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public Boolean getIsVip() {
		return isVip;
	}
	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean getIsDistributor() {
		if(isDistributor == null) {
			return false;
		}
		return isDistributor;
	}
	public void setIsDistributor(Boolean isDistributor) {
		this.isDistributor = isDistributor;
	}
	public Integer getSuperDistributorId() {
		if(isDistributor != null && isDistributor) {
			return distributorId;
		}
		return superDistributorId;
	}
	public void setSuperDistributorId(Integer superDistributorId) {
		this.superDistributorId = superDistributorId;
	}
	public Integer getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Integer distributorId) {
		this.distributorId = distributorId;
	}
}

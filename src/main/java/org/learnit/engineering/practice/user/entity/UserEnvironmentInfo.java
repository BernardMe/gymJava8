package org.learnit.engineering.practice.user.entity;

/**
 * 用户当前的环境信息
 * <br>V2版本：
 * <br>新增宏观渠道字段。
 * @author Administrator
 *
 */
public class UserEnvironmentInfo implements Cloneable {
	//渠道编号
	private String channelCode;
	//渠道名称
	private String channelName;
	//渠道类型编号
	private String channelTypeCode;
	//渠道类型名称
	private String channelTypeName;
	//环境编号
	private String envirCode;
	//环境名称
	private String envirName;
	//项目编号
	private String projectCode;
	//项目名称
	private String projectName;
	//全渠道编号
	private String fullChannelCode;
	//初始化全渠道信息
	public void initFullChannelCode() {
		fullChannelCode = projectCode + ":" + channelCode + ":" + envirCode;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelTypeCode() {
		return channelTypeCode;
	}
	public void setChannelTypeCode(String channelTypeCode) {
		this.channelTypeCode = channelTypeCode;
	}
	public String getChannelTypeName() {
		return channelTypeName;
	}
	public void setChannelTypeName(String channelTypeName) {
		this.channelTypeName = channelTypeName;
	}
	public String getEnvirCode() {
		return envirCode;
	}
	public void setEnvirCode(String envirCode) {
		this.envirCode = envirCode;
	}
	public String getEnvirName() {
		return envirName;
	}
	public void setEnvirName(String envirName) {
		this.envirName = envirName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getFullChannelCode() {
		return fullChannelCode;
	}
	public UserEnvironmentInfo cloneEnvirInfo() {
		try {
			return (UserEnvironmentInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
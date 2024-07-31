package org.learnit.engineering.practice.web.common;

/**
 * 视图实体--controller层返回结果. <br>
 * 除消息外一旦确定不允许修改. <br>
 * 错误编号共由两部分构成--modelCode(模块编号)、optCode(业务编号)
 *
 * @author Administrator
 */
public class OptResult implements Cloneable {
	/**
	 * 模块编号
	 */
	private String modelCode;
	/**
	 * 结果编号
	 */
	private Integer optCode;
	/**
	 * 唯一编号:模块编号--状态编号
	 */
	private String uniqueCode;
	/**
	 * 操作结果
	 */
	private Boolean success;
	/**
	 * 结果信息
	 */
	private String message;

	public OptResult() {
	}

	public OptResult(OptResult opt) {
		if (opt == null) {
			opt = UsualResult.SUCCESS;
		}
		this.modelCode = opt.getModelCode();
		this.optCode = opt.getOptCode();
		this.success = opt.getSuccess();
		this.message = opt.getMessage();
	}

	public OptResult(String modelCode, Integer optCode, Boolean success, String message) {
		this.modelCode = modelCode;
		this.optCode = optCode;
		this.success = success;
		this.message = message;
	}

	public OptResult(Integer optCode, Boolean success, String message) {
		this(null, optCode, success, message);
	}

	public String getModelCode() {
		return modelCode;
	}

	public Integer getOptCode() {
		return optCode;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public Boolean getSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OptResult [modelCode=" + modelCode + ", optCode=" + optCode + ", uniqueCode=" + uniqueCode
				+ ", success=" + success + ", message=" + message + "]";
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public void setOptCode(Integer optCode) {
		this.optCode = optCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
}

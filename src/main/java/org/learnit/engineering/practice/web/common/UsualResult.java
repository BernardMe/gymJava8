package org.learnit.engineering.practice.web.common;

/**
 * 仅成功和失败.
 *
 * @author Administrator
 */
public interface UsualResult {
	OptResult SUCCESS = new OptResult(200, true, "操作成功!");
	OptResult FAILURE = new OptResult(300, false, "操作失败!");
	OptResult NOT_EXIST = new OptResult(420, false, "数据不存在!");
	OptResult TO_MANY = new OptResult(421, false, "数据多于一条!");
	OptResult HAS_EXIST = new OptResult(422, false, "数据已存在!");
	OptResult SIGN_ERROR = new OptResult(511, false, "签名异常！");
	OptResult NONE_ACCESS = new OptResult(512, false, "无访问权限！");
	OptResult EXCEPTION = new OptResult(513, false, "操作异常！");
}

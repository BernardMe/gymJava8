package org.third.util;

import lombok.Data;

import java.io.Serializable;

/**
 * <p> Title: QiniuAuditJobMqInfo </p>
 * <p> Description:七牛审核job发送MQ参数类 </p>
 * <p> Copyright: Copyright (c) 郑州家音顺达通讯有限公司 2018 </p>
 * @author wangzhuo
 * @version
 * @date 创建日期：20201207
 */
@Data
public class QiniuAuditJobMqInfo implements Serializable {

	private String url;

	private String auditJobId;

	private Long materialId;

	private Long messageId;

	public QiniuAuditJobMqInfo(String url, String jobId, Long materialId, Long messageId) {
		this.url = url;
		this.auditJobId = jobId;
		this.materialId = materialId;
		this.messageId = messageId;
	}
}

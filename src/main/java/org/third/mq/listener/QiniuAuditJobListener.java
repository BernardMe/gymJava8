package org.third.mq.listener;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.third.util.BatchStat;
import org.third.util.QiniuAuditJobMqInfo;


import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import static org.third.util.Constants.QINIU_JOBID_NA;
import static org.third.util.Constants.QINIU_SUGGESTION_NA;
import static org.third.util.Constants.QINIU_SUGGESTION_PASS;


/**
 * @ClassName: QiniuAuditJobListener
 * @Description: 七牛审核job消息监听
 * @author wangzhuo
 * @date 20201207
 */
@Slf4j
public class QiniuAuditJobListener implements MessageListener {



	@Override
	public void onMessage(Message message) {
		try {
			String jobId = null;
			QiniuAuditJobMqInfo jobMqInfo = (QiniuAuditJobMqInfo) ((ObjectMessage) message).getObject();
			String jsonString = JSON.toJSONString(jobMqInfo);
			log.info("QiniuAuditJobListener成功获取了一条JMS消息: {}", jsonString);
			Long msgId = jobMqInfo.getMessageId();
			Long materialId = jobMqInfo.getMaterialId();
			String url = jobMqInfo.getUrl();
			if (StringUtils.isNotEmpty(url)) {
				jobId = BatchStat.getAuditJobId(url);
				log.info("jobId>>>" + jobId);
				if (!QINIU_JOBID_NA.equals(jobId)) {
					Thread.currentThread().sleep(1200);
					String suggestion = null;
					//由于延时尝试3次获取视频的审核结果管控建议
					for (int i= 0; i < 3; i++) {
						suggestion = BatchStat.checkJob(jobId);
						if (!QINIU_SUGGESTION_NA.equals(suggestion)) {break;}
						Thread.currentThread().sleep(760);
					}
					Integer auditStatus = null;
					if (!QINIU_SUGGESTION_NA.equals(suggestion)) {
						auditStatus = QINIU_SUGGESTION_PASS.equals(suggestion) ? 1 : 2;
					} else {
						auditStatus = 0;
					}
					if (null == materialId && null != msgId) {

					} else if (null == msgId && null != materialId){

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("QiniuAuditJobListener处理MQ消息失败", e);
		}
	}
}

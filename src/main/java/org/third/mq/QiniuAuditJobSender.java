package org.third.mq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

import org.third.util.QiniuAuditJobMqInfo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> Title: QiniuAuditJobSender </p>
 * <p> Description: 七牛审核job消息发送类</p>
 * <p> Copyright: Copyright (c) 郑州家音顺达通讯有限公司 2019 </p>
 * @author wangzhuo
 * @version
 * @date 创建日期：20201207
 */
@Slf4j
public class QiniuAuditJobSender {

	private static ExecutorService executorService = new ThreadPoolExecutor(2, 200, 5, TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(200), new DiscardOldestPolicy()); // 线程池

	/**
	 * @description 发送七牛审核job消息
	 * @author wangzhuo
	 * @date 20201207
	 * @param jobInfo job消息
	 */
	public void sendQiniuAuditJob(final QiniuAuditJobMqInfo jobInfo) {
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				//queueSender.send("joinus.qiniuAuditJobSender", jobInfo);
				log.info("QiniuAuditJobSender成功发送了一条JMS消息: {}", JSON.toJSONString(jobInfo));
			}
		});
	}
}

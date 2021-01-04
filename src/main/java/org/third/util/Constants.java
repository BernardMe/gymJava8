package org.third.util;

/**
 * 常量表
 */
public interface Constants {

	public static final String TEACHER = "1";//老师
	public static final String PARENT = "2";//家长

	/**
	 * 七牛视频的审核
	 */
	public static final String PREFIX_MATERIALVIDEO = "http://img.967111.com/MaterialVideo/";
	public static final String QINIU_JOBID_NA = "N/A";
	public static final String QINIU_SUGGESTION_PASS = "pass";
	public static final String QINIU_SUGGESTION_BLOCK = "block";
	public static final String QINIU_SUGGESTION_REVIEW = "review";
	public static final String QINIU_SUGGESTION_NA = "N/A";

	/**
	 * 七牛视频的转码
	 */
	public static final String PREFIX_EASY_URL = "http://img.967111.com/";
	public static final String QINIU_PERSISTENTID_NA = "N/A";
	public static final Integer QINIU_PFOP_CODE_SUCCESS = 0;
	public static final Integer QINIU_PFOP_CODE_WAITING = 1;
	public static final Integer QINIU_PFOP_CODE_DOING = 2;
	public static final Integer QINIU_PFOP_CODE_FAILED = 3;
	public static final Integer QINIU_PFOP_CODE_NA = -1;
}

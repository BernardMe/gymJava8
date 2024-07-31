package org.learnit.engineering.practice.tools.util;

import org.learnit.engineering.practice.web.common.EntityResult;
import org.learnit.engineering.practice.web.common.OptResult;
import org.learnit.engineering.practice.web.common.UsualResult;

public class CommonResultUtil {


	/**
	 * 复制操作结果
	 * @param fr
	 * @param to
	 */
	public static void copyOptResult(OptResult fr, OptResult to) {
		to.setMessage(fr.getMessage());
		to.setModelCode(fr.getModelCode());
		to.setSuccess(fr.getSuccess());
		to.setOptCode(fr.getOptCode());
		to.setUniqueCode(fr.getUniqueCode());
	}

	
	public static <T> EntityResult<T> entResult(OptResult opt, T entity){
		if(opt == null) {
			opt = UsualResult.SUCCESS;
		}
		return new EntityResult<T>(opt, entity);
	}
	
	public static <T> EntityResult<T> entResult(T entity){
		return entResult(null, entity);
	}
	
	public static <T> EntityResult<T> entResult(OptResult opt){
		return entResult(opt, null);
	}

}

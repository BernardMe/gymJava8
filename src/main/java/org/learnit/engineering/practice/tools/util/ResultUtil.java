package org.learnit.engineering.practice.tools.util;

import com.alibaba.fastjson.JSONObject;
import org.learnit.engineering.practice.web.common.EntityResult;


public class ResultUtil extends CommonResultUtil {

	/**
	 * 将JSON字符串解析为EntityResult对象
	 * @param jsStr
	 * @return
	 */
	public static <T> EntityResult<T> parseEntityResult(String jsStr, Class<T> cls){
		//当泛型是字符串的时候返回JSON泛型序列化方式
		return convertEntityResult(JSONObject.parseObject(jsStr), cls);
	}

	/**
	 * 将JSON对象转换成EntityResult对象
	 * @param js
	 * @return
	 */
	public static <T> EntityResult<T> convertEntityResult(JSONObject js, Class<T> cls){
		EntityResult<T> result = new EntityResult<T>();
		result.setOptCode(js.getInteger("optCode"));
		result.setModelCode(js.getString("modelCode"));
		result.setMessage(js.getString("message"));
		result.setSuccess(js.getBoolean("success"));
		if(js.containsKey("data")) {
			T data = JSONObject.parseObject(js.getString("data"), cls);
			result.setData(data);
		}
		return result;
	}
	
	/**
	 * 老版方法名称
	 * @param <T>
	 * @param js
	 * @param temp
	 * @return
	 */
	@Deprecated
	public static <T> EntityResult<T> converterEntityResult(JSONObject js, Class<T> temp){
		return convertEntityResult(js, temp);
	}
	
}

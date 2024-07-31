package org.learnit.engineering.practice.web.common;

/**
 * 视图实体--controller层返回结果
 * @author Administrator
 *
 * @param <T>
 */
public class EntityResult<T> extends OptResult {

	public EntityResult() {
		super(null);
	}

	public EntityResult(OptResult opt){
		this(opt,null);
	}

	public EntityResult(OptResult opt, T data){
		super(opt);
		this.data = data;
	}

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

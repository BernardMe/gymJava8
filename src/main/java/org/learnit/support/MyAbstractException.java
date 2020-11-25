package org.learnit.support;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;

/**
 * @Title Name :
 * @Description :
 * @Creation 20201125
 * @author :  wangzhuo
 */
public abstract class MyAbstractException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MyAbstractException() {
    }

    public MyAbstractException(Throwable ex) {
        super(ex);
    }

    public MyAbstractException(String message) {
        super(message);
    }

    public MyAbstractException(String message, Throwable ex) {
        super(message, ex);
    }

    public void handler(LinkedHashMap modelMap) {
        modelMap.put("code", this.getCode().value());
        if (StringUtils.isNotBlank(this.getMessage())) {
            modelMap.put("msg", this.getMessage());
        } else {
            modelMap.put("msg", this.getCode().msg());
        }
    }

    protected abstract HttpCode getCode();
}

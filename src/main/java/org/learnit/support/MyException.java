package org.learnit.support;

/**
 * @Title Name :
 * @Description :
 * @Creation 20201125
 * @author :  wangzhuo
 */
public class MyException extends MyAbstractException {

    private static final long serialVersionUID = 1L;

    public MyException() {
    }

    public MyException(Throwable ex) {
        super(ex);
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable ex) {
        super(message, ex);
    }



    @Override
    protected HttpCode getCode() {
        return HttpCode.ERROR;
    }
}

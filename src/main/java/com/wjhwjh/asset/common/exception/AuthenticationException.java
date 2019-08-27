package com.wjhwjh.asset.common.exception;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
public class AuthenticationException extends RuntimeException {

    private String message;

    public AuthenticationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

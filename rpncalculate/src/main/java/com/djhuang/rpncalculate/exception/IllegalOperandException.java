package com.djhuang.rpncalculate.exception;

/**
 * @Author: djhuang
 * @Description: 除数为0的异常
 * @Date: 2019/6/10 22:31
 * @Version: 1.0
 */
public class IllegalOperandException extends RuntimeException {
    public IllegalOperandException() {
    }

    public IllegalOperandException(String message) {
        super(message);
    }
}

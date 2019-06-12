package com.djhuang.rpncalculate.exception;

/**
 * @Author: djhuang
 * @Description: ${description}
 * @Date: 2019/6/11 11:01
 * @Version: 1.0
 */
public class NoEnoughOperandException extends RuntimeException {
    public NoEnoughOperandException() {
    }

    public NoEnoughOperandException(String message) {
        super(message);
    }
}

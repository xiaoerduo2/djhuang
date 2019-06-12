package com.djhuang.rpncalculate.calculateimpl;

import com.djhuang.rpncalculate.calculate.BinaryCalculate;
import com.djhuang.rpncalculate.constants.Constant;
import com.djhuang.rpncalculate.exception.IllegalOperandException;

/**
 * @Author: djhuang
 * @Description: 二元操作枚举类，包括加减乘除，每个实例匿名实现了BinaryCalculate接口的calculate方法
 * @Date: 2019/6/10 21:19
 * @Version: 1.0
 */
public enum BinaryCalculateImpl implements BinaryCalculate {
    ADD(Constant.ADD) {
        @Override
        public double calculate(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBTRACT(Constant.SUBTRACT) {
        @Override
        public double calculate(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY(Constant.MULTIPLY) {
        @Override
        public double calculate(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE(Constant.DIVIDE) {
        @Override
        public double calculate(double num1, double num2) {
            if (num2 == 0) {
                throw new IllegalOperandException("除数不能为0");
            } else {
                return num1 / num2;
            }
        }
    };
    /**
     * 操作名
     */
    private String name;

    BinaryCalculateImpl(String name) {
        this.name = name;
    }
}

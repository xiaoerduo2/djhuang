package com.djhuang.rpncalculate.calculateimpl;

import com.djhuang.rpncalculate.calculate.UnaryCalculate;
import com.djhuang.rpncalculate.constants.Constant;
import com.djhuang.rpncalculate.exception.IllegalOperandException;

/**
 * @Author: djhuang
 * @Description: 单目运算枚举类，包括sqrt
 * @Date: 2019/6/10 21:19
 * @Version: 1.0
 */
public enum UnaryCalculateImpl implements UnaryCalculate {
    SQRT(Constant.SQRT) {
        @Override
        public double calculate(double num) {
            if (num < 0) {
                throw new IllegalOperandException("不能对负数开平方");
            }
            return Math.sqrt(num);
        }
    };

    /**
     * 运算名
     */
    private String name;

    private UnaryCalculateImpl(String name) {
        this.name = name;
    }


}

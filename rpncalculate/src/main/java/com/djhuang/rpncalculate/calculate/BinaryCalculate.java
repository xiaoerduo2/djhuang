package com.djhuang.rpncalculate.calculate;

/**
 * @Author: djhuang
 * @Description: ${description}
 * @Date: 2019/6/10 22:08
 * @Version: 1.0
 */
public interface BinaryCalculate {

    /**
     * 根据传入的操作数进行相应的运算
     *
     * @param num1 操作数1
     * @param num2 操作数2
     * @return 返回运算结果
     */
    double calculate(double num1, double num2);
}

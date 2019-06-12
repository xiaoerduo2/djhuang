package com.djhuang.rpncalculate.calculate;

/**
 * @Author: djhuang
 * @Description: 运算接口
 * @Date: 2019/6/10 21:26
 * @Version: 1.0
 */
public interface UnaryCalculate {
    /**
     * 根据传入的操作数进行相应的运算
     *
     * @param num 操作数
     * @return 返回运算结果
     */
    double calculate(double num);
}

package com.djhuang.rpncalculate.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: djhuang
 * @Description: ${description}
 * @Date: 2019/6/10 22:47
 * @Version: 1.0
 */
public class Constant {
    /**
     * 数字0
     */
    public static final int ZERO = 0;
    /**
     * 数字1
     */
    public static final int ONE = 1;
    /**
     * 数字2
     */
    public static final int TWO = 2;
    /**
     * 操作数标志
     */
    public static final int INPUT_OPERAND = 1;
    /**
     * 二元操作符标志(加减乘除)
     */
    public static final int INPUT_BINARY_OPERATOR = 2;
    /**
     * 单目操作标志
     */
    public static final int INPUT_UNARY_OPERATOR = 3;
    /**
     * 非法输入标志
     */
    public static final int INPUT_ILLEGAL = -1;
    /**
     * 匹配数字的正则
     */
    public static final String PATTERN_OPERAND = "(\\-|\\+)?\\d+(\\.\\d+)?";
    /**
     * 匹配加减乘除的正则
     */
    public static final String PATTERN_BINARY_OPERATOR = "[\\+\\-\\*\\/]";

    /**
     * 操作符字符串
     */
    public static final String SQRT = "sqrt";
    public static final String UNDO = "undo";
    public static final String CLEAR = "clear";
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    /**
     * 操作符对应的枚举名
     */
    public static final Map<String, String> OPERATOR_MAP = new HashMap() {{
        put("+", "ADD");
        put("-", "SUBTRACT");
        put("*", "MULTIPLY");
        put("/", "DIVIDE");
        put("sqrt", "SQRT");
    }};

    /**
     * 栈的最大容量
     */
    public static final int STACK_MAX_SIZE = 100000;
    /**
     * stack的负载因子
     */
    public static final double STACK_LOAD_FACTOR = 0.25;
}

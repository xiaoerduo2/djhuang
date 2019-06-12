package com.djhuang.rpncalculate.util;

import com.djhuang.rpncalculate.constants.Constant;
import com.djhuang.rpncalculate.exception.NoEnoughOperandException;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: djhuang
 * @Description: ${description}
 * @Date: 2019/6/10 23:12
 * @Version: 1.0
 */
public class IndexUtil {


    /**
     * 检查输入的字符串属于什么类型，操作数/单目操作符/二元操作符
     * @param str
     * @return
     */
    public static int inputCheck(String str){
        if(!StringUtils.isEmpty(str) && str.matches(Constant.PATTERN_OPERAND)){
            //如果是操作数，返回操作数标志
            return Constant.INPUT_OPERAND;
        }else if(!StringUtils.isEmpty(str) && str.matches(Constant.PATTERN_BINARY_OPERATOR)){
            //如果是加减乘除操作符，返回二元操作符标志
            return Constant.INPUT_BINARY_OPERATOR;
        }else if(Constant.SQRT.equals(str) || Constant.UNDO.equals(str)
                || Constant.CLEAR.equals(str)){
            //如果是sqrt/clear/undo操作，返回单目操作符标志
            return Constant.INPUT_UNARY_OPERATOR;
        }else{
            //以上都不是，则为非法输入
            return Constant.INPUT_ILLEGAL;
        }
    }

    /**
     * 返回一个与当前操作栈状态相同的新栈
     *
     * @return
     */
    public static Stack<Double> getNewStack(Stack<Double> srcStack) {
        Stack<Double> tmp = new Stack<>();
        if (null != srcStack && srcStack.size() > 0) {
            for (double d : srcStack) {
                tmp.push(d);
            }
        }
        return tmp;
    }
    /**
     * 打印操作栈内容
     */
    public static void printStack(Stack<Double> stack) {
        StringBuilder sb = new StringBuilder("stack:");
        //打印出来的数据，保留十位小数
        DecimalFormat format = new DecimalFormat("#.##########");
        if (null != stack && stack.size() > 0) {
            for (double d : stack) {
                sb.append(" " + format.format(d));
            }
        }
        System.out.println(sb.toString());
    }



    /**
     * 获取用户输入的字符串，按空格拆分成字符串数组
     *
     * @return 用户输入的字符串数组
     */
    public static String[] getInputStrs() {
        //获取用户输入
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        //将这个字符串转换成操作数（符）数组
        String[] strs = next.trim().split("\\s+");
        return strs;
    }

    /**
     * 参数不够时打印异常信息
     * @param str 操作符
     * @param e 异常信息
     */
    public static void printNoEnoughOperandMsg(String str, NoEnoughOperandException e){
        StringBuilder sb = new StringBuilder();
        sb.append("operator<" + str + ">")
                .append(" position:<" + e.getStackTrace()[0].getClassName() + e.getStackTrace()[0].getMethodName() +
                        e.getStackTrace()[0].getLineNumber() + ">:")
                .append(" insufficient parameters ");
        System.out.println(sb.toString());
    }

    /**
     * 打印错误信息
     * @param i
     */
    public static void printErrorMsg(int i,String [] strs){
        StringBuilder sb2 = new StringBuilder();
        for (int j = i + 1; j < strs.length; j++) {
            sb2.append(strs[j]+" ");
        }
        if (!sb2.toString().isEmpty()) {
            System.out.println("(the '" + sb2.toString() + "' were not pushed on to the stack due to the previous error) ");
        }
    }
}

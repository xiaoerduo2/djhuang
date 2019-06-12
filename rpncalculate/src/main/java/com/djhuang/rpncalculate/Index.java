package com.djhuang.rpncalculate;

import com.djhuang.rpncalculate.calculate.BinaryCalculate;
import com.djhuang.rpncalculate.calculate.UnaryCalculate;
import com.djhuang.rpncalculate.calculateimpl.BinaryCalculateImpl;
import com.djhuang.rpncalculate.calculateimpl.UnaryCalculateImpl;
import com.djhuang.rpncalculate.constants.Constant;
import com.djhuang.rpncalculate.exception.IllegalOperandException;
import com.djhuang.rpncalculate.exception.NoEnoughOperandException;
import com.djhuang.rpncalculate.util.IndexUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class Index {

    /**
     * 操作数栈
     */
    private Stack<Double> stack = new Stack<>();
    /**
     * 记录操作数栈变化的日志栈
     */
    private Stack<Stack<Double>> logStack = new Stack<>();

    /**
     * rpn计算
    */
    public void rpnCalculate() {
        //获取用户输入
        String[] strs = IndexUtil.getInputStrs();
        //遍历一次输入中的每一项，操作数存入操作栈，遇操作符，则将运算结果存入栈中，
        // 并将相应操作数从栈中取出
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            //flag标志运算是否成功
            boolean flag = false;
            int inputCheck = IndexUtil.inputCheck(str);
            if (Constant.INPUT_OPERAND == inputCheck) {
                //操作数
                flag = pushOperand(Double.valueOf(str));
            } else if (Constant.INPUT_BINARY_OPERATOR == inputCheck) {
                //二元运算
                flag = binaryCal(str);
            } else if (Constant.INPUT_UNARY_OPERATOR == inputCheck) {
                //单目运算
                flag = unaryCal(str);
            } else {
                //非法输入
                System.out.println("'" + str + "' is an illegal input ");
            }
            if (!flag) {
                //操作没成功，后面的操作被终止
                IndexUtil.printErrorMsg(i, strs);
                break;
            }
        }
        IndexUtil.printStack(stack);
    }


    /**
     * 单目运算
     *
     * @param
     */
    private boolean unaryCal(String str) {
        if (Constant.CLEAR.equals(str)) {
            //清空运算
            stack.clear();
            logStack.push(null);
        } else if (Constant.UNDO.equals(str)) {
            //回退运算
            //如果日志栈中有数据，则他的第二个数据是操作栈要回退到的状态
            stack.clear();
            if (logStack.size() >= Constant.TWO) {
                logStack.pop();
                stack = IndexUtil.getNewStack(logStack.peek());
            }
        } else {
            //其它单目运算
            //检查操作数是否至少有一个
            boolean flag = operandCheck(Constant.ONE, str);
            if (!flag) {
                return false;
            }
            double top1 = stack.pop();
            UnaryCalculate unaryCalculate = UnaryCalculateImpl.valueOf(Constant.OPERATOR_MAP.get(str));
            try {
                //对栈中第一位数据运算，操作完成将结果放入操作栈
                double result = unaryCalculate.calculate(top1);
                pushOperand(result);
            } catch (IllegalOperandException e) {
                //操作异常，将操作栈回退，并打印异常信息
                stack.push(top1);
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 二元运算
     *
     * @param
     * @return
     * @throws NoEnoughOperandException
     */
    private boolean binaryCal(String str) throws NoEnoughOperandException {
        //检查操作数个数是否足够
        boolean flag = operandCheck(Constant.TWO, str);
        if (!flag) {
            return false;
        }
        double top1 = stack.pop();
        double top2 = stack.pop();
        BinaryCalculate binaryCalculate = BinaryCalculateImpl.valueOf(Constant.OPERATOR_MAP.get(str));
        try {
            //对栈中前两位数据进行运算，并返回结果到栈中保存
            Double result = binaryCalculate.calculate(top2, top1);
            pushOperand(result);
        } catch (IllegalOperandException e) {
            //运算时出现异常，将操作栈回退,打印异常信息
            stack.push(top2);
            stack.push(top1);
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 将操作数放入操作栈，并在操作日志栈中加记录
     *
     * @param d 操作数
     * @return
     */
    private boolean pushOperand(double d) {
        stack.push(d);
        logStack.push(IndexUtil.getNewStack(stack));
        //当日志栈的容量达到最大时，将前面的1/4清除，保障stack不会过大
        if(logStack.size()>=Constant.STACK_MAX_SIZE){
            for(int i = 0;i< Constant.STACK_MAX_SIZE* Constant.STACK_LOAD_FACTOR;i++){
                logStack.remove(Constant.ZERO);
            }
        }
        return true;
    }

    /**
     * 检查操作数个数是否足够
     *
     * @param len
     */
    private boolean operandCheck(int len, String str) {
        if (null == stack || stack.size() < len) {
            try {
                throw new NoEnoughOperandException();
            } catch (NoEnoughOperandException e) {
                //在控制台打印警告信息
                IndexUtil.printNoEnoughOperandMsg(str, e);
                return false;
            }
        }
        return true;
    }


    /**
     * 入口
     * @param args
     */
    public static void main(String[] args) {
        Index index = new Index();
        while (true) {
            index.rpnCalculate();
        }
    }
}

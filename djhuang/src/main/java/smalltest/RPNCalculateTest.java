package smalltest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class RPNCalculateTest {
    //操作数标志
    private static final int INPUT_NUMBER = 1;
    //加减乘除二元操作符标志
    private static final int INPUT_BINARY_OPERATOR = 2;
    //单目操作标志
    private static final int INPUT_SINGLE_OPERATOR = 3;
    //非法输入标志
    private static final int INPUT_ILLEGAL = -1;
    //匹配数字
    private static final Pattern NUM_PATTERN = Pattern.compile("(\\-|\\+)?\\d+(\\.\\d+)?");
    //匹配加减乘除
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[\\+\\-\\*\\/]");
    private static final String SQRT = "sqrt";
    private static final String UNDO = "undo";
    private static final String CLEAR = "clear";
    private Stack<List<BigDecimal>> logStack = new Stack<>();
    private Stack<BigDecimal> stack = new Stack<>();

    public static void main(String args[]) throws Exception {
        RPNCalculateTest test = new RPNCalculateTest();
        while (true) {
            test.rpnCalculate();
        }
    }

    /**
     * rpn计算
     */
    private void rpnCalculate() throws Exception {
        //获取用户输入，将这个字符串转换成操作数（符）数组
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        String[] strs = next.split(" ");
        //遍历操作数（符）数组
        for (String string : strs) {
            int check = check(string);
            //如果是数字，放入stack中
            if (INPUT_NUMBER == check) {
                BigDecimal num = new BigDecimal(string);
                stack.push(num);
                logStack.push(convertToList());
                //如果是二元操作符，进行相应操作
            } else if (INPUT_BINARY_OPERATOR == check) {
                BigDecimal result = binaryCalculate(string);
                stack.push(result);
                logStack.push(convertToList());
                //如果是单目操作符，进行相应操作
            } else if (INPUT_SINGLE_OPERATOR == check) {
                singleCalculate(string);
            }
        }
        System.out.println(stack.toString());
    }

    /**
     * 单目操作
     *
     * @param operate
     */
    private void singleCalculate(String operate) {
        //开方操作
        if (SQRT.equals(operate)) {
            BigDecimal top1 = stack.pop();
            BigDecimal sqrt = sqrt(top1, 15);
            stack.push(sqrt);
            logStack.push(convertToList());
            //撤销操作
        } else if (UNDO.equals(operate)) {
            //清空操作栈
            stack.clear();
            //如果日志栈中的数据没有两个，说明此操作前栈是空的，那么清空当前操作栈即可
            if (logStack.size() < 2) {
                return;
            }
            //去除上次操作的记录
            logStack.pop();
            //获取上次操作前的栈状态，并遍历后倒序塞进stack
            List<BigDecimal> list = logStack.peek();
            for (int i = 0; i < list.size(); i++) {
                stack.push(list.get(i));
            }
            //否则clear
        } else if (CLEAR.equals(operate)) {
            //栈数据清空，并在栈日志中记录null
            stack.clear();
            logStack.push(null);
        } else {
            //抛异常
        }
    }

    /**
     * 计算
     */
    private BigDecimal binaryCalculate(String operate) throws Exception {
        if (stack.size() < 2) {
            //抛异常
            throw new Exception("操作数不够");
        }
        BigDecimal top1 = stack.pop();
        BigDecimal top2 = stack.pop();
        if ("+".equals(operate)) {
            return top1.add(top2);
        } else if ("-".equals(operate)) {
            return top1.subtract(top2);
        } else if ("*".equals(operate)) {
            return top1.multiply(top2);
        } else {
            return top1.divide(top2);
        }
    }

    /**
     * sqrt方法
     *
     * @param value
     * @param scale
     * @return
     */
    public static BigDecimal sqrt(BigDecimal value, int scale) {
        BigDecimal num2 = BigDecimal.valueOf(2);
        int precision = 100;
        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal deviation = value;
        int cnt = 0;
        while (cnt < precision) {
            deviation = (deviation.add(value.divide(deviation, mc))).divide(num2, mc);
            cnt++;
        }
        deviation = deviation.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return deviation;

    }

    /**
     * 检查字符串是否数字、二元操作符、单目操作符
     *
     * @param str
     * @return
     */
    private static int check(String str) {
        //如果是操作数则返回操作数标志
        if (NUM_PATTERN.matcher(str).matches()) {
            return INPUT_NUMBER;
            //是加减乘除操作符则返回二元操作符标志
        } else if (OPERATOR_PATTERN.matcher(str).matches()) {
            return INPUT_BINARY_OPERATOR;
            //是单目操作返单目操作符标志
        } else if (SQRT.equals(str) || UNDO.equals(str) || CLEAR.equals(str)) {
            return INPUT_SINGLE_OPERATOR;
            //否则返回非法输入标志
        } else {
            return INPUT_ILLEGAL;
        }
    }

    /**
     * 将stack转换成list
     *
     * @return
     */
    private List<BigDecimal> convertToList() {
//        List<BigDecimal> list = new ArrayList<>();
//        for (BigDecimal num : stack){
//            list.add(num);
//        }
        return new ArrayList<>(stack);
//        return list;
    }
}


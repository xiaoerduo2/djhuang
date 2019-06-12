package com.djhuang.rpncalculate;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Stack;


public class RpnCalculateTests {
    Index index = new Index();

    /**
     * 测试二目运算
     *
     * @throws Exception
     */
    @Test
    public void binaryCalTest() throws Exception {
        Class clazz = Index.class;
        Field stack = clazz.getDeclaredField("stack");
        Method binaryCal = clazz.getDeclaredMethod("binaryCal", String.class);
        binaryCal.setAccessible(true);
        stack.setAccessible(true);
        //除数为0
        stack.set(index, new Stack<Double>() {{
            push(1.0);
            push(0.0);
        }});
//        操作数不够
//        stack.set(index, new Stack<Double>(){{push(1.0);}});
        //boolean flag =(boolean) binaryCal.invoke(index, "+");
        //boolean flag =(boolean) binaryCal.invoke(index, "-");
        //boolean flag =(boolean) binaryCal.invoke(index, "*");
        boolean flag = (boolean) binaryCal.invoke(index, "/");
        System.out.println(stack.get(index));
    }

    /**
     * 测试单目运算
     *
     * @throws Exception
     */
    @Test
    public void unaryCalTest() throws Exception {
        Class clazz = Index.class;
        Field stack = clazz.getDeclaredField("stack");
        Field logStack = clazz.getDeclaredField("logStack");
        Method unaryCal = clazz.getDeclaredMethod("unaryCal", String.class);
        unaryCal.setAccessible(true);
        stack.setAccessible(true);
        logStack.setAccessible(true);
//        正常
//        stack.set(index, new Stack<Double>(){{push(1.0);push(3.0);}});
//        操作数不够
//        stack.set(index, new Stack<Double>(){{push(1.0);}});
//        负数开方
        stack.set(index, new Stack<Double>() {{
            push(1.0);
            push(-3.0);
        }});
        boolean flag = (boolean) unaryCal.invoke(index, "sqrt");
        System.out.println(stack.get(index));
        boolean flag3 = (boolean) unaryCal.invoke(index, "sqrt");
        System.out.println(stack.get(index));
        //       boolean flag =(boolean) unaryCal.invoke(index, "undo");
        boolean flag2 = (boolean) unaryCal.invoke(index, "undo");
        System.out.println(stack.get(index));
        boolean flag1 = (boolean) unaryCal.invoke(index, "clear");
        System.out.println(stack.get(index));

    }
}

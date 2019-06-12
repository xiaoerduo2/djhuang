package com.djhuang.rpncalculate;

import com.djhuang.rpncalculate.constants.Constant;
import com.djhuang.rpncalculate.util.IndexUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: djhuang
 * @Description: 工具类测试
 * @Date: 2019/6/12 0:23
 * @Version: 1.0
 */
public class UtilTest {
    /**
     * 测试输入是否能正确转化成字符串数组
     *
     * @throws Exception
     */
    @Test
    public void getInputStrsTest() throws Exception {
        while (true) {
            String[] strs = IndexUtil.getInputStrs();
            System.out.println(Arrays.toString(strs));
        }
    }

    /**
     * 测试对输入的字符串类型判断是否正确
     */
    @Test
    public void inputCheckTest() {
        String[] strs = {"1", "-1", "1.11", "+", "-", "*", "/", "2+", "cc", "-0", "--1", "+2"};
        for (String str : strs) {
            int i = IndexUtil.inputCheck(str);
            if (i == Constant.INPUT_BINARY_OPERATOR) {
                System.out.println(str + ":二元操作符");
            } else if (i == Constant.INPUT_ILLEGAL) {
                System.out.println(str + ":非法输入");
            } else if (i == Constant.INPUT_OPERAND) {
                System.out.println(str + ":操作数");
            } else if (i == Constant.INPUT_UNARY_OPERATOR) {
                System.out.println(str + ":单目操作符");
            } else {
                System.out.println("..");
            }
        }
    }

}

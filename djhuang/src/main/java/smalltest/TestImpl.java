package smalltest;

import java.util.Arrays;

public abstract class TestImpl implements Test{
    @Override
    public void test() {


    }

    public static void main(String []args){
        String s="人abc";
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
    }
}

import javafx.beans.binding.StringBinding;
import smalltest.Singleton;

import java.math.BigDecimal;
import java.util.*;

public class Index {

    static int b = 9;
    public  static String[] DECIMAL_RMB = {"角","分"};
    public  static String[] INTEGER_RMB = {"千","百","十"};
    public  static String[] UNIT_RMB = {"元","万","亿"};

    static{
        b = 7;
    }


    /**
     * 生成num位的验证码，可有大小写字母0-9的数字组成
     * @param num
     * @return
     */
    public static  String checkCode(int num){
        String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        char [] charArray = codes.toCharArray();
        Random radom = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0; i<num; i++){
            stringBuilder.append(charArray[radom.nextInt(charArray.length)]);
        }
        return stringBuilder.toString();
    }


    /**
     * 九九乘法表
     */
    public  static  void  multiplyTable(){
        for(int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+(j*i)+" ");
            }
            System.out.println();
        }
    }

    /**
     * 将float型数字转化成人民币，保留到分
     * @param floatNum
     */
    public static  void floatToRMB(float floatNum){

    }


    /**
     * 将浮点型的数值小数部分与整数部分分开并包装成String数组返回，其中小数部分保留两位
     * @return
     */
    public static String[] divide(float floatNum){
        long l = (long)floatNum;
        int decimal = Math.round((floatNum - l) * 100);
        return new String[] {String.valueOf(l),String.valueOf(decimal)};
    }


    /**
     *根据传入的字符串，将前两位后面分别加角、分
     * @param decimal
     * @return
     */
    public static  String decimalRMB(String decimal){
        StringBuilder sb =new StringBuilder();
        char [] charArray;
        if(null == decimal){
            return null;
        }
        charArray = decimal.toCharArray();
        for (int i = 0;i<charArray.length;i++){
            //前两位，且不为0，则拼接
            if((i == 0 || i==1) &&charArray[i]!=48){
                sb.append(charArray[i]).append(DECIMAL_RMB[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 将整数部分转换成二维数组，每4位为一组
     * @param integer
     * @return
     */
    public static char[][] toDoubleArray(String integer){
        if(null == integer){
            return null;
        }
        char[] charArray = integer.toCharArray();
        int length = charArray.length;
        //二维数组的数组长度
        int iter = (int)Math.ceil(length/4.0);
        char [][] chars=new char[iter][];
        for (int i=0;i<iter;i++){
            //从后往前，4个一组分别赋值给chars的数组元素
            chars[i]  = Arrays.copyOfRange(charArray, length - (i + 1) * 4<0?0:length - (i + 1) * 4, length - i * 4);
        }
        return chars;
    }

    public static  String integerRmb(char[][] chars){
        StringBuilder sb = new StringBuilder();
        for (int i=chars.length-1;i>=0;i--){
            int length = chars[i].length;
            for (int j=0;j<length;j++){
                if(j == length-1){
                    sb.append(chars[i][j]+UNIT_RMB[i]);
                }else{
                    sb.append(chars[i][j]+INTEGER_RMB[4-length+j]);
                }
            }
        }
        return sb.toString();
    }

    public static  void main(String [] args){
       /* System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date.getTime());*/
        Index index1 = new Index();
        Index index2 = new Index();
        String str1 = new String("as");
        String str2 = new String("as");

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str1 == str2);
        Calendar cl = Calendar.getInstance();
        /* System.out.println(cl.get(Calendar.YEAR));
        System.out.println(cl.get(Calendar.MONTH));
        System.out.println(cl.get(Calendar.DATE));*/
        cl.set(2003, 7 , 31);
        cl.set(Calendar.MONTH,8);
        cl.set(Calendar.DATE, 5);
        System.out.println(cl.getTime());
        /*Random random = new Random();
        System.out.println(random.nextInt(100));
        System.out.println(random.nextLong());
        byte[] buffer = new byte[10];
        random.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        System.out.println(random.nextDouble());*/
       /* String string = "hello";
        System.out.println(string.substring(0));
        System.out.println(string.substring(2,3));

        System.out.println(string.toLowerCase());
        System.out.println(string.toUpperCase());

        String str=" hello java ";
        System.out.println(string.trim());
        System.out.println(str.trim());

        System.out.println(string.indexOf("lo",4));

        String ss = "java.doc";
        System.out.println(ss.lastIndexOf(".")>0?ss.substring(ss.lastIndexOf(".")):"无格式文件");

        System.out.println(ss.charAt(5));
        System.out.println(ss.length());

        String sss = "HELLO";
        System.out.println(string.equalsIgnoreCase(sss));
        System.out.println(ss.endsWith(".doc"));*/





        //生成了、6位验证码
        //checkCode(6);

        //打印99乘法表
        //multiplyTable();

        char[][] chars = toDoubleArray("12345678");
        /*for (int i=0;i<chars.length;i++){
            char[] charArray = chars[i];
            for (int j=0;j<charArray.length;j++){
                System.out.print(charArray[j]+",");
            }
            System.out.println();
        }*//*
        String[] divide = divide(1234567.89f);
        String decimalRmb = decimalRMB(divide[1]);
        String integerRmb = integerRmb(toDoubleArray(divide[0]));
        System.out.println(integerRmb+decimalRmb);*/
        /*long l = 1234L;
        int i = 1;
        System.out.println(l+i);
        System.out.println(l>i);*/
      /*  Map map =new HashMap();
        map.put("key", 1L);
        long l = (Long)map.get("key");
        System.out.println(new Integer((int)l));*/
      /*Long l = new Long(3l);
      Integer ll = new Integer(2);
      System.out.println(l+   ll);*/
    }

    private final String string;

    public Index(){
        string = "";
        System.out.println(string);
    }


}

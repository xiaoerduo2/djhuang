package genericitytest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fruit<T> {
    public <E>Fruit(E info){
        System.out.println(info.toString());
    }


    public static <E>E copy(Collection<E> dest,Collection<?extends E>src){
        E last = null;
        for (E ele:src){
            last = ele;
            dest.add(ele);
        }
        return last;
    }

    public static <E> void test(E info ){

    }
//    @SuppressWarnings(value = "unchecked")
    public static void main(String agrs[]){
//        Fruit<String> fruit = new <Integer>Fruit(11);
        /*List<Number>numbers = new ArrayList<>();
        List<Integer>integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        Number copy = copy(numbers, integ ers);
        System.out.println(numbers);*/
        /*List list = new ArrayList();
        list.add(1);
        list.add(2);
        System.out.println((String)list.get(0));*/
        /*exceptionTest();
        System.out.println("ss");*/
        List<String> list = new ArrayList();
        //list.add("2");

    }


    public static void exceptionTest(){
       throw new RuntimeException();
    }
}

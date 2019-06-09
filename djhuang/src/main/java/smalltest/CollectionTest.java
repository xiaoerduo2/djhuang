package smalltest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class CollectionTest {
    public  static  void main(String[] args) throws Exception {
        /*String ss = new String("haha");
        List list = new ArrayList();
        list.add("haha");
        list.add("hehe");
        list.add(new CollectionTest());
        System.out.println(list.contains("c"));*/


        /*Map map =new HashMap();
        map.put("1", "hhaha");
        map.put("2", "ss");
        System.out.println(map.containsValue(new CollectionTest()));*/

        /*Properties properties = new Properties();
        properties.put("username", "jiajia");
        properties.put("password", "haha");
        properties.store(new FileOutputStream("a.ini"), "comment line");

        Properties pro2 = new Properties();
        pro2.load(new FileInputStream("a.ini"));
        System.out.println(pro2);*/

       String [] strings = {"a","b","c","d","a","c","a","b"};
       Map map = new HashMap();
       for (String string:strings){
           if(null == map.get(string)){
               map.put(string, 1);
           }else {
               map.put(string, (Integer)map.get(string)+1);
           }
       }
       System.out.println(map);



        /*Collection collection = new ArrayList();
        collection.add("hello");
        Collection set = new HashSet();
        set.add("world");
        collection.addAll(set);
        System.out.println("collection的元素是："+collection);
        collection.retainAll(set);
        System.out.println("collection的元素是："+collection);
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println(Arrays.toString(collection.toArray()));*/
        /*Collection list = new ArrayList();
        list.add("java疯狂讲义");
        list.add("java编程思想");
        list.add("sql必知必会");
        ListIterator i = ((ArrayList) list).listIterator();
        while(i.hasNext()){

            System.out.println(i.next()+String.valueOf(list.size()));
            i.add("===============");
        }


        while (i.hasPrevious()){
            System.out.println(i.previous()+String.valueOf(list.size()));
        }
*/

   /*     map = new HashMap();
        map.put("1", "java");
        map.put("2", "spring");
        map.put("3", "sql");
        System.out.println(map.get("1"));
        System.out.println(map.keySet());
        System.out.println(map.put("3", "hello"));
        System.out.println(map);
        map.remove("3", "hello");
        System.out.println(map);
        map.put("3", "hello");
        for (Object key :map.keySet()){
            System.out.println(map
            .get(key));
        }
        for (Object object :map.entrySet()){
            Map.Entry entry = (Map.Entry)object;
            System.out.println(entry.getKey()+"="+entry.getValue() );
        }
*/


        // for1(list);
        //for2 (list);
        //for3(list);

    }

    /**
     * 使用iterator的forEachRemainning(Comsumer action)方法遍历，该方法参数也可用lambda表达式实现
     * @param list
     */
    private static void for3(Collection list) {
        Iterator iterator = list.iterator();
        iterator.forEachRemaining((obj)->{System.out.println(obj);});
    }

    /**
     * 根据Iteartop的实例作为迭代器迭代
     * @param list
     */
    private static void for2(Collection list) {
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            String book = (String) iterator.next();
            System.out.println(book);

            if(book.equals("sql必知必会")){
                iterator.remove();
            }
        }
        System.out.println(list.toString());
    }

    /**
     * 使用lambda表达式遍历
     * Controler接口继承自Iterable接口，java8新增了forEach(Consumer c)方法，Consumer是函数式接口
     * @param list
     */
    private static void for1(Collection list) {
        list.forEach(obj->{System.out.println(obj);});
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

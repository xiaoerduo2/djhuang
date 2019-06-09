package reflecttest;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ReflectTest {
    private Map<String,Object> objPool=new HashMap<>();


    public Object getObj(String name){
        return objPool.get(name);
    }

    public Object createObj(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        return obj;
    }

    public void initPool() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("b.properties"));
        for (String name:properties.stringPropertyNames()){
            if(!name.contains("%")){
                objPool.put(name, createObj(properties.getProperty(name)));
            }
        }
    }

    public void initProperty() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("b.properties"));
        for (String name:properties.stringPropertyNames()){
            int index = name.indexOf("%");
            if(index>0){
                String objName = name.substring(0, index);
                String methodName = "set"+name.substring(index+1,index+2).toUpperCase()+name.substring(index+2);
                String property = properties.getProperty(name);
                Object object = objPool.get(objName);
                Method method = object.getClass().getDeclaredMethod(methodName,Integer.TYPE);
                method.setAccessible(true);
                method.invoke(object, Integer.parseInt(property));
            }
        }
    }

    public static void main(String[]args) throws Exception {
        /*Properties properties = new Properties();
        properties.put("a", "djhuang.javareflecttest.A");
        properties.put("b", "djhuang.javareflecttest.B");
        properties.store(new FileWriter("b.properties"), "反射测试");*/
        /*ReflectTest reflectTest = new ReflectTest();
        reflectTest.initPool();
        reflectTest.initProperty();
        System.out.println(reflectTest.objPool.get("a"));*/
        /*File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile().getParent());
        File.createTempFile("tset", "txt",file);*/

       /* File newFile= new File(".");
        //newFile.mkdir();
        System.out.println(newFile.exists());
        String[] list = newFile.list();
        for (String name:list){
            System.out.println(name);
        }
        File[] files = File.listRoots();
        System.out.println("++++++++++++++++++++++++++++");
        for (File file:files) {
            System.out.println(file.getName());
        }*/
       /* System.out.println(Math.ceil(5.12f));
        HashMap*/
        /*List <String>list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (int i = 0;i<list.size();i++){
            if(list.get(i).equals("3")){
                list.remove(i);
            }else{
                System.out.println(list.get(i));
            }

        }
        System.out.println(list);*/
       /* for (String s:list) {
            list.remove(s);
        }
        System.out.println(list);*/

        List list = new ArrayList();
        list.add(null);
        System.out.println(list.size());

        Set set = new HashSet();
        set.add(null);
        System.out.println(set.size());
       Map <String,Integer>map = new HashMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        for (Map.Entry<String, Integer> entry:map.entrySet()){
            if("2".equals(entry.getKey())){
                System.out.println(entry.setValue(4)) ;
            }
        }
        System.out.println(map.size());


    }
}

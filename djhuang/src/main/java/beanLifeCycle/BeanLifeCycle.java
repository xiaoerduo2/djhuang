package beanLifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle //implements DisposableBean,  InitializingBean
 {

    public void start(){
        System.out.println("start");
    }

    public void stop(){
        System.out.println("stop");
    }

    public void destroy() throws Exception {
        System.out.println("destory");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void defaultInit(){
        System.out.println("defaultInit");
    }
    public void defaultDestroy(){
        System.out.println("defaultDestroy");
    }
}

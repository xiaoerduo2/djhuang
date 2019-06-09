import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class UnitTestBase {
    //配置文件路径
    private String springXmlPath;

    //上下文对象
    private ClassPathXmlApplicationContext context;

    public UnitTestBase(String springXmlPath){
        this.springXmlPath=springXmlPath;
    }
    @Before
    public void before(){
        if(StringUtils.isEmpty(springXmlPath)){
            springXmlPath="classpath*:spring-*.xml";
        }
        try {
            context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
//            context.start();
        }catch (BeansException e){
            e.printStackTrace();
        }

    }

    @After
    public void after(){
        context.destroy();
    }

    protected <T extends Object>T
    getBean(String beanId){
        try {
            T bean = (T) context.getBean(beanId);
            return bean;
        }catch (BeansException e){
            e.printStackTrace();
            return null;
        }

    }
}

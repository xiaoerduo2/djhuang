import autowire.BeanAutowireService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAutowire extends UnitTestBase{
    public TestAutowire(){
        super("classpath*:spring-autowire.xml");
    }

    @Test
    public void test(){
        BeanAutowireService beanAutowireService = super.getBean("beanAutowireService");
        beanAutowireService.say("this is a test");
    }
}

import annotion.BeanInvok;
import annotion.bean.Store;
import annotion.importResource.MyDriverManage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAnnotation extends UnitTestBase{

    public TestAnnotation (){
        super("classpath*:spring-annotation.xml");
    }

    @Test
    public  void test(){
        BeanInvok beanInvok = super.getBean("beanInvok");
        beanInvok.say();
    }

    @Test
    public  void test2(){
        Store store = super.getBean("store");
        System.out.println(store.getClass().getName());
    }

    @Test
    public  void testDriver(){
        MyDriverManage myDriverManage = super.getBean("myDriverManage");
        System.out.println(myDriverManage.getClass().getName());
    }
}

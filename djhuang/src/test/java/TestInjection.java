import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase{

    public TestInjection(){
        super("classpath*:spring-core.xml");
    }

    @Test
    public void testSetter(){
        InjectionService injectionService = super.getBean("injectionService");
        injectionService.save("这是要保存的参数");
    }
}

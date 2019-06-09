package aware;

import org.springframework.beans.factory.BeanNameAware;

public class DJBeanName implements BeanNameAware {

    public void setBeanName(String name) {
        System.out.println("DJBeanName:" +name);
    }
}

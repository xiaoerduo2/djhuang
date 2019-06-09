package annotion;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

@Component
@Order(2)
public class BeanImplOne implements BeanInterface {
}

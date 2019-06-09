package annotion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class BeanInvok {

    @Autowired
    private List<BeanInterface> list;

    @Autowired
    private Map<String, BeanInterface> map;

    @Autowired
    @Qualifier("beanImplOne")
    private BeanInterface beanInterface;

    public void  say(){
        if(null != list && list.size()>0){
            for (BeanInterface beanInterface:list ) {
                System.out.println(beanInterface.getClass().getName());
            }
        }else{
            System.out.println("list is null");
        }
        if(null != map && map.size()>0){
            for (Map.Entry<String,BeanInterface> entry:map.entrySet()) {
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }else{
            System.out.println("map is null");
        }

        System.out.println();
        System.out.println(beanInterface.getClass().getName());
    }
}

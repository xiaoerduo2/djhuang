package annotion.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfig {

    @Bean(name = "store")
    public  Store getStore(){
        return new StringStore();
    }
}

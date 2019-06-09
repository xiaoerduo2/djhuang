package annotion.importResource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath*:spring-annotation.xml")
public class driverConfig {
    @Value("${url}")
    private String url;
    @Value("${jdbc.userName}")
    private String userName;
    @Value("${password}")
    private String password;

    @Bean
    public MyDriverManage myDriverManage(){
        return new MyDriverManage(url, userName,password);
    }


}

package com.djhuang.rpncalculate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author: djhuang
 * @Description: ${description}
 * @Date: 2019/6/11 20:20
 * @Version: 1.0
 */
@SpringBootApplication
@EnableAsync
public class RpnCalculateApplication {
    public static void main(String [] args){
        SpringApplication.run(RpnCalculateApplication.class);
    }
}

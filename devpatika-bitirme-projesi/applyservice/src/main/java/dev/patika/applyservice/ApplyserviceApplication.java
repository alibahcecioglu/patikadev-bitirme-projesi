package dev.patika.applyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@ComponentScan("dev.patika")
@EnableFeignClients
public class ApplyserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplyserviceApplication.class, args);
    }

}

package dev.patika.scoreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class ScoreserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreserviceApplication.class, args);
    }

}

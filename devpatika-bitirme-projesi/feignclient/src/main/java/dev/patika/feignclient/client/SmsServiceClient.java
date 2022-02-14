package dev.patika.feignclient.client;

import dev.patika.feignclient.model.Sms;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "SmsServiceAPI", url =  "http://localhost:8083")
public interface SmsServiceClient {

    @RequestMapping("/api/sms")
    Sms sendSms(@RequestBody Sms sms);
}

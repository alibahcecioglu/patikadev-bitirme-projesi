package dev.patika.applyservice.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.patika.applyservice.model.CreditLimitResult;
import dev.patika.feignclient.model.Customer;
import dev.patika.feignclient.client.CustomerServiceClient;
import dev.patika.feignclient.client.ScoreServiceClient;
import dev.patika.feignclient.client.SmsServiceClient;
import dev.patika.feignclient.model.Sms;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/creditapply")
@RequiredArgsConstructor
public class ApplyController {
    private final CustomerServiceClient customerServiceClient;
    private final ScoreServiceClient scoreServiceClient;
    private final SmsServiceClient smsServiceClient;

    @GetMapping
    public ResponseEntity save(@RequestParam String ssid) throws JsonProcessingException {

        Customer customer=null;
        int creditScore=0;
        try{
            ResponseEntity<Customer> responseCustomer=this.customerServiceClient.getCustomerBySsid(ssid);
            customer=responseCustomer.getBody();
        }catch (FeignException e){
            return new ResponseEntity(new ObjectMapper().readValue(e.contentUTF8(), Map.class), HttpStatus.BAD_REQUEST);
        }

        try{
            ResponseEntity<Map<String,Object>> responseScore=this.scoreServiceClient.getCreditScoreBySsid(ssid);
            Map<String ,Object> result=responseScore.getBody();
            if (Boolean.parseBoolean(result.get("success").toString())){
                creditScore=Integer.parseInt(result.get("scores").toString());
            }
        }catch (FeignException e){
            return new ResponseEntity(new ObjectMapper().readValue(e.contentUTF8(), Map.class), HttpStatus.BAD_REQUEST);
        }

        CreditLimitResult result=checkCreditLimit(creditScore,customer.getSalary());
        Sms sms=prepareSms(customer,creditScore,result);
        return new ResponseEntity(this.smsServiceClient.sendSms(sms),HttpStatus.OK);

    }

    private CreditLimitResult checkCreditLimit(int creditScore, double salary) {
        CreditLimitResult creditLimitResult=new CreditLimitResult();
        if(creditScore < 500) {
            creditLimitResult.setStatus(false);
            creditLimitResult.setLimit(0);
        }
        else if(creditScore < 1000){
            if(salary < 5000){
                creditLimitResult.setStatus(true);
                creditLimitResult.setLimit(10000);
            } else {
                creditLimitResult.setStatus(true);
                creditLimitResult.setLimit(20000);
            }
        } else{
            creditLimitResult.setStatus(true);
            creditLimitResult.setLimit(salary * 4);
        }

        return creditLimitResult;
    }
    private Sms prepareSms(Customer customer, int creditScore, CreditLimitResult result) {
        String message = "";
        if(result.isStatus())
            message = "Dear " + customer.getFullName() + ", the result of your loan application is positive.credit limit: " + result.getLimit() + " TL";
        else
            message = "Dear " + customer.getFullName() + ", the result of your loan application is negative.";
        Sms sms = new Sms();
        sms.setTimestamp(System.currentTimeMillis());
        sms.setSsid(customer.getSsid());
        sms.setPhoneNo(customer.getPhoneNo());
        sms.setCreditScore(creditScore);
        sms.setSalary(customer.getSalary());
        sms.setCreditLimit(result.getLimit());
        sms.setCreditStatus(result.isStatus());
        sms.setMessage(message);

        return sms;
    }


}

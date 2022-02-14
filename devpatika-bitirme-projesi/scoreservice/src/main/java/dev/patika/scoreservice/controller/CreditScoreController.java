package dev.patika.scoreservice.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/creditScore")
public class CreditScoreController{

    @GetMapping
    public ResponseEntity<Map<String,Object>> getCreditScoreBySsid(@RequestParam String ssid){
        Map<String,Object> result=new HashMap<>();
        if(ssid.isEmpty()){
            result.put("success",false);
            result.put("message","SSID is empty!!");
        }else{
            char lastChar = ssid.charAt(ssid.length() - 1);
            result.put("success", true);
            switch (lastChar) {
                case '0':
                    result.put("scores", 550);
                    break;
                case '2':
                    result.put("scores", 2000);
                    break;
                case '4':
                    result.put("scores", 1000);
                    break;
                case '6':
                    result.put("scores", 900);
                    break;
                case '8':
                    result.put("scores", 400);
                    break;
                default:
                    result.put("success", false);
                    result.put("message", "SSID:  cannot be an odd number.");
                    break;
            }
        }
        if (Boolean.parseBoolean(result.get("success").toString()))
                return new ResponseEntity<>(result, HttpStatus.OK);
        else
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);

    }
}

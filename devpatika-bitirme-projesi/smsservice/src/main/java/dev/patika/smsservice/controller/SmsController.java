package dev.patika.smsservice.controller;

import dev.patika.smsservice.model.Sms;
import dev.patika.smsservice.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sms")
@RequiredArgsConstructor
public class SmsController {
    private final SmsService smsService;

    @GetMapping
    public List<Sms> getAllSms(){
        return this.smsService.gellAllSms();
    }

    @PostMapping
    public Sms sendSms(@Valid @RequestBody Sms sms){
        return this.smsService.save(sms);
    }

}

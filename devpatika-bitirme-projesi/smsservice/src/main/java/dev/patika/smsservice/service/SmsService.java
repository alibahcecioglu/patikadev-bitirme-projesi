package dev.patika.smsservice.service;

import dev.patika.smsservice.model.Sms;

import dev.patika.smsservice.repository.SmsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmsService {
    private final SmsRepository repository;

    public Sms save(Sms sms){
        log.info("Sms saved => " + sms.toString());
        return this.repository.save(sms);
    }

    public List<Sms> gellAllSms(){
        log.info("All sms are listed.");
        return this.repository.findAll();
    }
}

package dev.patika.smsservice.service;

import dev.patika.smsservice.model.Sms;
import dev.patika.smsservice.repository.SmsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SmsServiceTest {
    @Mock
    SmsRepository repository;

    @InjectMocks
    SmsService smsService;

    @Test
    void gellAll() {
        when(repository.findAll()).thenReturn(Collections.singletonList(
                new Sms("212844002154")
        ));

        List<Sms> expected = smsService.gellAllSms();

        assertEquals(expected.get(0).getSsid(), "212844002154");
    }
}
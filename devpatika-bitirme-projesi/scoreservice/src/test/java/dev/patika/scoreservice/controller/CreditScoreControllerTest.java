package dev.patika.scoreservice.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreditScoreControllerTest {

    @InjectMocks
    CreditScoreController controller;

    @Test
    void getCreditScoreBySSID() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("success", false);
        expected.put("message", "SSID is empty!");

        Map<String, Object> actual = this.controller.getCreditScoreBySsid(" ").getBody();

        assertEquals(actual, expected);
    }

    @Test
    void getCreditScoreBySSID2() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("success", false);
        expected.put("message", "SSID: Must consist of 11 digits.");

        Map<String, Object> actual = this.controller.getCreditScoreBySsid("29").getBody();

        assertEquals(actual, expected);
    }
}

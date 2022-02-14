package dev.patika.smsservice.repository;

import dev.patika.smsservice.model.Sms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<Sms,Long> {
}

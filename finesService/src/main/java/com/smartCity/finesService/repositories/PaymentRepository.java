package com.smartCity.finesService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartCity.finesService.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

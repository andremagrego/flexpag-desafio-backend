package com.flexpag.paymentscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.paymentscheduler.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findByNameLike(String name);

}

package com.flexpag.paymentscheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPayment;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "amount", length = 45)
    private double amount;

    @Column(name = "paymentDate", length = 45)
    private String paymentDate;

    @Column(name = "periodFrom", nullable = true, length = 45)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String periodFrom;

    @Column(name = "periodTo", nullable = true, length = 45)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String periodTo;

    @Column(name = "payDay", nullable = true, length = 45)
    private String payDay;

    @Column(name = "status", length = 45)
    private boolean status;
}

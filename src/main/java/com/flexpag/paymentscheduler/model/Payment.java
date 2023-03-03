package com.flexpag.paymentscheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @Column(name = "nome", length = 45)
    private String nome;

    @Column(name = "valor", length = 45)
    private double valor;

    @Column(name = "dataPagamento", length = 45)
    private String dataPagamento;

    @Column(name = "status", length = 45)
    private String status;
}

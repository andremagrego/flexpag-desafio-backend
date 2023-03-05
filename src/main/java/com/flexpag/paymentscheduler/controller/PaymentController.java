package com.flexpag.paymentscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.model.Payment;
import com.flexpag.paymentscheduler.repository.PaymentRepository;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<String> deletarPagamentoPeloId(@PathVariable("id") int id) {
        paymentRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Pagamento deletado com sucesso!");
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Payment> obterPagamentoPeloNome(@PathVariable("nome") String nome) {

        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.findByNomeLike(nome + "%"));
    }

    @Autowired
    private PaymentRepository paymentRepository;

}

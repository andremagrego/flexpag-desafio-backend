package com.flexpag.paymentscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.model.Payment;
import com.flexpag.paymentscheduler.repository.PaymentRepository;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @PostMapping
    public ResponseEntity<Object> createNewPayment(@RequestBody Payment payment) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(paymentRepository.save(payment));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Pagamento já existente" + d.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao tentar realizar o mesmo pagamento" + e.getMessage());
        }
    }

    @PutMapping
    private ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.save(payment));
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<String> deletePaymentById(@PathVariable("id") int id) {
        paymentRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Pagamento deletado com sucesso!");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Payment>> getPaymentById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.findById(id));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Payment> getPaymentByName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.findByNameLike(name + "%"));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.findAll());

    }

    @Autowired
    private PaymentRepository paymentRepository;

}

package com.transaction.challenge.api.controllers;

import com.transaction.challenge.api.application.model.entities.Transaction;
import com.transaction.challenge.api.application.model.entities.User;
import com.transaction.challenge.api.application.services.TransactionService;
import com.transaction.challenge.api.application.services.UserService;
import com.transaction.challenge.api.dtos.TransactionDTO;
import com.transaction.challenge.api.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Transaction>> findAllTransactions(){
        List<Transaction> transactions = this.service.findAllTransacions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Transaction> findOneTransaction(@PathVariable Long id){
        Transaction transaction = this.service.findOneTransaction(id);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/save")
    public ResponseEntity<Transaction> createTrasanction(@RequestBody TransactionDTO transactionDTO){
        Transaction transaction = this.service.createTransaction(transactionDTO);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}

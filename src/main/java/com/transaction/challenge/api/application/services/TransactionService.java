package com.transaction.challenge.api.application.services;

import com.transaction.challenge.api.application.exceptions.ResourceNotFoundException;
import com.transaction.challenge.api.application.model.entities.Transaction;
import com.transaction.challenge.api.application.model.entities.User;
import com.transaction.challenge.api.application.model.repositories.TransactionRepository;
import com.transaction.challenge.api.dtos.TransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final UserService userService;

    public List<Transaction> findAllTransacions(){
        return this.repository.findAll();
    }


    public Transaction findOneTransaction(Long id){
        return this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Transaction createTransaction(TransactionDTO transaction){
        User sender = this.userService.findOneUser(transaction.senderId());
        User receiver = this.userService.findOneUser(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        Transaction transaction1 = new Transaction();
        transaction1.setValue(transaction.value());
        transaction1.setSender(sender);
        transaction1.setReceiver(receiver);
        transaction1.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.repository.save(transaction1);
        userService.saveUser(sender);
        userService.saveUser(receiver);

        return transaction1;
    }
}

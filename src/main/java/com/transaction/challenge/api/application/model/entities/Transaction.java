package com.transaction.challenge.api.application.model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private BigDecimal value;

    private LocalDateTime timestamp;

    public Transaction(){

    }
    public Transaction(User senderId, User receiverId, BigDecimal value){
        this.sender = senderId;
        this.receiver = receiverId;
        this.value = value;
    }
}

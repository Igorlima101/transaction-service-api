package com.transaction.challenge.api.application.model.entities;

import com.transaction.challenge.api.dtos.UserDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String cpf;

    private String email;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(){

    }


    public User(UserDTO userDTO){
        this.fullName = userDTO.fullName();
        this.cpf = userDTO.cpf();
        this.email = userDTO.email();
        this.balance = userDTO.balance();
        this.userType = userDTO.userType();
    }

}

package com.transaction.challenge.api.dtos;

import com.transaction.challenge.api.application.model.entities.UserType;

import java.math.BigDecimal;

public record UserDTO(String fullName, String cpf, String email, BigDecimal balance, UserType userType) {
}

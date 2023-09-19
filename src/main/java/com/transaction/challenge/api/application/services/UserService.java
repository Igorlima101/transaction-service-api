package com.transaction.challenge.api.application.services;

import com.transaction.challenge.api.application.exceptions.InsufficientFoundsException;
import com.transaction.challenge.api.application.exceptions.ResourceNotFoundException;
import com.transaction.challenge.api.application.exceptions.UserTypeException;
import com.transaction.challenge.api.application.model.entities.User;
import com.transaction.challenge.api.application.model.entities.UserType;
import com.transaction.challenge.api.application.model.repositories.UserRepository;
import com.transaction.challenge.api.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAllUsers(){
        return this.repository.findAll();
    }

    public User findOneUser(Long id){
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void validateTransaction(User sender, BigDecimal value){
        if(sender.getUserType() == UserType.MERCHANT){
            throw new UserTypeException();
        }

        if(sender.getBalance().compareTo(value) < 0){
            throw new InsufficientFoundsException();
        }
    }

    public User createUser(UserDTO user){
        User user1 = new User(user);
        this.saveUser(user1);
        return user1;
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}

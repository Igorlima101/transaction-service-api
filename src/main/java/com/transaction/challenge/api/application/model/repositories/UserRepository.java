package com.transaction.challenge.api.application.model.repositories;

import com.transaction.challenge.api.application.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

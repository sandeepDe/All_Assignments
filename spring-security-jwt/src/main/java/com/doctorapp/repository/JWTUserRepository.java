package com.doctorapp.repository;

import com.doctorapp.model.JWTUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JWTUserRepository extends JpaRepository<JWTUser,Integer> {
    JWTUser findByUsername(String username);
}

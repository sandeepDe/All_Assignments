package com.doctorapp.repository;

import com.doctorapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);
}

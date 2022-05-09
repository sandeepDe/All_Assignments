package com.doctorapp.service;

import com.doctorapp.model.JWTUser;
import com.doctorapp.repository.JWTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

public class JWTUserServiceImpl implements UserDetailsService {

    private JWTUserRepository jwtUserRepository;

    @Autowired
    public void setJwtUserRepository(JWTUserRepository jwtUserRepository) {
        this.jwtUserRepository = jwtUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JWTUser user = jwtUserRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("Invalid username");

        List<GrantedAuthority> authorities = Arrays.asList(
                new SimpleGrantedAuthority("ADMIN"),
                new SimpleGrantedAuthority("USER")


        );
        UserDetails userDetails = new User(user.getUsername(),user.getPassword(),authorities);

        return userDetails;
    }
}

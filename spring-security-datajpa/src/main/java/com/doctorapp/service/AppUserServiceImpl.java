package com.doctorapp.service;

import com.doctorapp.model.AppUser;
import com.doctorapp.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

public class AppUserServiceImpl implements UserDetailsService ,IAppUserService{
    private IAppUserRepository iAppUserRepository;

    @Autowired
    public void setiAppUserRepository(IAppUserRepository iAppUserRepository) {
        this.iAppUserRepository = iAppUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepository.findByUsername(username);
        String nusername = appUser.getUsername();
        String password = appUser.getPassword();

        GrantedAuthority authority1 = new SimpleGrantedAuthority("USER");
        GrantedAuthority authority2 = new SimpleGrantedAuthority("ADMIN");
        UserDetails user = new User(nusername , password, Arrays.asList(authority1,authority2));

        return user;
    }


    @Override
    public void addUser(AppUser appUser) {
        iAppUserRepository.save(appUser);
    }

    @Override
    public void updateAppUser(AppUser appUser) {
        iAppUserRepository.save(appUser);
    }

    @Override
    public void deleteAppUser(int userId) {

        iAppUserRepository.deleteById(userId );
    }
}

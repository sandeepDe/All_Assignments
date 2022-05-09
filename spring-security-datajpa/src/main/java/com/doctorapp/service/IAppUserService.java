package com.doctorapp.service;

import com.doctorapp.model.AppUser;

public interface IAppUserService {
    void addUser(AppUser appUser);
    void updateAppUser(AppUser appUser);
    void deleteAppUser(int userId);
}

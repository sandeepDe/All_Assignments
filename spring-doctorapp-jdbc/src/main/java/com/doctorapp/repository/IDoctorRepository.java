package com.doctorapp.repository;

import com.doctorapp.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IDoctorRepository {
    List<Doctor> getAllDoctors();

    List<Doctor> getByNameCategory(String category) ;

    List<Doctor> getByLocation(String city) ;

    List<Doctor> getBySpecializationAndLessPrice(String specialization , double price) ;



    // Admin

    void addDoctor(Doctor doctor);

    void deleteDoctor(int doctorId) ;
}

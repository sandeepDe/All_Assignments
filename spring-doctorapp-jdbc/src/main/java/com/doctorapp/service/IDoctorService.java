package com.doctorapp.service;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> findAllDoctors();

    List<Doctor> findByNameCategory(String category) throws DoctorNotFoundException;

    List<Doctor> findByLocation(String city) throws DoctorNotFoundException;

    List<Doctor> findBySpecializationAndLessPrice(String specialization , double price) throws DoctorNotFoundException;



    // Admin

    void addDoctor(Doctor doctor);

    void deleteDoctor(int doctorId) ;

}

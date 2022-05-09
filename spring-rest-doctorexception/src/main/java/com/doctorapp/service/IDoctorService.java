package com.doctorapp.service;

import com.doctorapp.model.Doctor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDoctorService {
    Doctor addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int doctorId);

    List<Doctor> getAll();
    Doctor getByDoctorId(int id);
    List<Doctor> getByProficiency(String proficiency);
    List<Doctor> getBySpecializationAndExperience(String specialization , int experience);
    List<Doctor> getByLocation(String location);
    List<Doctor> getBySpecialization(String specialization);
    List<Doctor> getBySpecializationAndLessFees(String specialization , double fees);

}

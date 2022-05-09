package com.doctorapp.service;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService{

    @Autowired
    IDoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAllDoctors() {
       return doctorRepository.getAllDoctors();

    }

    @Override
    public List<Doctor> findByNameCategory(String category) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.getByNameCategory(category);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("No One with category");
        return  doctorList;
    }

    @Override
    public List<Doctor> findByLocation(String city) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.getByLocation(city);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("No One in location");
        return  doctorList;

    }

    @Override
    public List<Doctor> findBySpecializationAndLessPrice(String specialization, double price) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.getBySpecializationAndLessPrice(specialization,price);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("No One in location");
        return  doctorList;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.addDoctor(doctor);

    }

    @Override
    public void deleteDoctor(int doctorId) {
doctorRepository.deleteDoctor(doctorId);
    }
}

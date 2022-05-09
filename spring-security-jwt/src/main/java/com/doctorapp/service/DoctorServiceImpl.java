package com.doctorapp.service;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService{

    private IDoctorRepository doctorRepository;

    @Autowired
    public void setDoctorRepository(IDoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor );
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);

    }

    @Override
    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteById(doctorId);


    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getByDoctorId(int id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public List<Doctor> getByProficiency(String proficiency) {
        List<Doctor> doctorList = doctorRepository.findByProficiency(proficiency);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("Doctor With Selected Proficiency Not Available");
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecializationAndExperience(String specialization, int experience) {
        List<Doctor> doctorList = doctorRepository.findBySpecializationAndExperience(specialization,experience);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("Doctor With Selected Proficiency And Experience Not Available");
        return doctorList;
    }

    @Override
    public List<Doctor> getByLocation(String location) {
        List<Doctor> doctorList = doctorRepository.findByLocation(location );
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("Doctor in the selected Location Not Available");
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialization(String specialization) {
        List<Doctor> doctorList = doctorRepository.findBySpecialization(specialization);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("Doctor with Selected Specialization Not Available");
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecializationAndLessFees(String specialization, double fees) {
        List<Doctor> doctorList = doctorRepository.findBySpecializationAndLessFees(specialization,fees);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("Doctor with Specialization and Less than the fees mentioned Not Available");
        return doctorList;
    }
}

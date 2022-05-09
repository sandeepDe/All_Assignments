package com.doctorapp.repository;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.AllQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepositoryImpl implements IDoctorRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Doctor> getAllDoctors() {
        return jdbcTemplate.query(AllQueries.SELECTQUERY,(rs, rowNum) ->{
            Doctor doctor = new Doctor();
            doctor.setDoctorId(rs.getInt("doctorId"));
            doctor.setDoctorName(rs.getString("doctorName"));
            doctor.setCity(rs.getString("city"));
            doctor.setPrice(rs.getDouble("price"));

            return doctor;
        } );
    }

    @Override
    public List<Doctor> getByNameCategory(String category) {
        return jdbcTemplate.query(AllQueries.NAMEQUERY,new DoctorMapper(),"%"+category+"%");
    }

    @Override
    public List<Doctor> getByLocation(String city) {
        return jdbcTemplate.query(AllQueries.LOCATIONQUERY,new DoctorMapper(),city);
    }

    @Override
    public List<Doctor> getBySpecializationAndLessPrice(String specialization, double price) {
        return jdbcTemplate.query(AllQueries.SPECANDPRICEQUERY,new DoctorMapper(), specialization,price);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        Object[] doctorList = {
                doctor.getDoctorId(),doctor.getDoctorName(),
                doctor.getSpecialization(),doctor.getCity(),doctor.getPrice()
        };
        jdbcTemplate.update(AllQueries.ADDQUERY,doctorList);

    }

    @Override
    public void deleteDoctor(int doctorId) {
        jdbcTemplate.update(AllQueries.DELETEQUERY,doctorId);

    }
}

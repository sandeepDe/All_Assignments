package com.doctorapp.repository;

import com.doctorapp.model.Doctor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorMapper implements RowMapper<Doctor> {
    @Override
    public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(rs.getInt("doctorId"));
        doctor.setDoctorName(rs.getString("doctorName"));
        doctor.setSpecialization(rs.getString("specialization"));
        doctor.setCity(rs.getString("city"));
        doctor.setPrice(rs.getDouble("price"));

        return doctor;

    }
}

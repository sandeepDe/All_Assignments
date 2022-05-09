package com.doctorapp.repository;

import com.doctorapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByProficiency(String proficiency);
    @Query("from Doctor d where d.specialization=?1 and d.experience =?2")
    List<Doctor> findBySpecializationAndExperience(String specialization , int experience);
    List<Doctor> findByLocation(String location);
    List<Doctor> findBySpecialization(String specialization);

    @Query("from Doctor d where d.specialization =?1 and d.fees <= ?2")
    List<Doctor> findBySpecializationAndLessFees(String specialization , double fees);

}

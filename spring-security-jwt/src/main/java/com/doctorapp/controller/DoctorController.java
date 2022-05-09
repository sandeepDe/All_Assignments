package com.doctorapp.controller;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor-api")
public class DoctorController {
    private IDoctorService doctorService;

    @Autowired
    public void setDoctorService(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/greet")
    ResponseEntity<String> greetMessage() {
        String msg = "Welcome to Book App";
        //For creating custom headers we need to create instance for HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        // Creating Custom Headers here
        headers.add("desc", "Online Book Application");
        //Below we are creating ResponseEntity object for sending status , headers , body as a response
        System.out.println("HEllo");
        return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    }

    @PostMapping("/doctors")
    ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
         String msg = "Added Doctor Successfully";
         HttpHeaders headers = new HttpHeaders();
         headers.add("desc" , "Added Doctor");

          return ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctor);

    }
    @PutMapping("/doctors")
    ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
        String msg = "Updated Doctor Successfully";
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "updated Doctor");

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctor);

    }
    @DeleteMapping("/doctors/doctorId/{doctorId}")
    ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") int doctorId){
        doctorService.deleteDoctor(doctorId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "Deleted Doctor with the Id provided");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }

    @GetMapping("/all-doctors")
    ResponseEntity<List<Doctor>> getAll(){
        List<Doctor>doctorList = doctorService.getAll();

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "Getting all doctors");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctorList);

    }

    @GetMapping("/doctors/doctorId/{doctorId}")
    ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") int doctorId){
        Doctor doctor = doctorService.getByDoctorId(doctorId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "Getting Doctor By Id");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctor);

    }

    @GetMapping("/doctors/proficiency/{proficiency}")
    ResponseEntity<List<Doctor>> getDoctorProficiency(@PathVariable("proficiency") String proficiency){
        List<Doctor> doctorsList = doctorService.getByProficiency(proficiency);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "Getting Doctors By Proficiency");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctorsList);

    }


    @GetMapping("/doctors/specialization/{specialization}/experience/{experience}")
    ResponseEntity<List<Doctor>> getBySpecializationAndExperience(@PathVariable("specialization") String specialization,@PathVariable("experience") int experience){
        List<Doctor> doctorsList = doctorService.getBySpecializationAndExperience(specialization,experience);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "Getting Doctors By SpecializationAndExperience");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctorsList);

    }


    @GetMapping("/doctors/location/{location}")
    ResponseEntity<List<Doctor>> getDoctorByLocation(@PathVariable("location") String location){
        List<Doctor> doctorsList = doctorService.getByLocation(location);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "Getting Doctors By Location");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctorsList);

    }

    @GetMapping("/doctors/specialization/{specialization}")
    ResponseEntity<List<Doctor>> getDoctorBySpecialization(@PathVariable("specialization") String specialization){
        List<Doctor> doctorsList = doctorService.getBySpecialization(specialization);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "Getting Doctors By Location");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctorsList);

    }


    @GetMapping("/doctors/specialization/{specialization}/fees/{fees}")
    ResponseEntity<List<Doctor>> getBySpecializationAndLessFees(@PathVariable("specialization") String specialization,@PathVariable("fees") int fees){
        List<Doctor> doctorsList = doctorService.getBySpecializationAndLessFees(specialization,fees);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" , "Getting Doctors By SpecializationAndExperience");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(doctorsList);

    }




}

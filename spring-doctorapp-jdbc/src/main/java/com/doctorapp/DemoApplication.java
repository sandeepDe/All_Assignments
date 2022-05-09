package com.doctorapp;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private IDoctorService doctorService;

	@Autowired
	public void setDoctorService(IDoctorService doctorService) {
		this.doctorService = doctorService;
	}


	@Override
	public void run(String... args) throws Exception {
		Doctor doctor = new Doctor(1,"Baba","Eluru","Heart-Catcher",10);

		doctorService.addDoctor(doctor);
	}
}


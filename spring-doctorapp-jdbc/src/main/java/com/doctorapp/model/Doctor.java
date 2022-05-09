package com.doctorapp.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Doctor {

    private Integer doctorId;
    private String doctorName;
    private String city;
    private String specialization;
    private double price;



}

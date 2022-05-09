package com.doctorapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doctor {
    @Id
    @GeneratedValue(generator = "doctor_gen" , strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "doctor_gen" , sequenceName = "doctor_seq",initialValue = 1,allocationSize = 1)
    @ToString.Exclude
    @Column(name = "doctorId")
    private Integer doctorId;
    @Column(length = 40)
    private String doctorName;
    @Column(length = 40)
    private String location;

    private boolean availability;//True or False
    @Column(length = 40)
    private String specialization;//ENT,Cardio
    @Column(length = 40)
    private String proficiency;///Specialist, Super Specialist , Junior Doctor
    @Column
    private Integer experience;
    @Column
    private double fees;


}

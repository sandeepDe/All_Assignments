package com.mobileapp.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter


@NoArgsConstructor
public class Features {

    @Id
    @GeneratedValue(generator = "mobile_gen" ,strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mobile_gen" , sequenceName = "mobile_seq" ,initialValue = 100 , allocationSize = 1)
    private Integer featuresId;
    @Column(length = 20)
    private String processor;
    @Column(length = 20)
     private String storage; // 32GB , 64GB,16GB,32GB

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Camera cameraType; // front , rear


    private String memory; //

    private String operatingSystem;//Android , windows , ios


}

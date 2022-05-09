package com.mobileapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {

    @Column(length = 40)
    private String model;
    @Id
    @GeneratedValue(generator = "mobile_gen" , strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mobile_gen",sequenceName = "mobile_seq" , initialValue = 100 , allocationSize = 1)
    private Integer mobileId;
    @Column(length =40)
    private String brand;

    @Column(length = 40)
    private double price;

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private Processor processor;
    @Column(length = 20)
    private String memory;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Camera cameraType; // front , rear



    @Column(length = 20)
    private String operatingSystem;//Android , windows , ios

    @Column(length = 40)
    private String storage; // 32GB , 64GB,16GB,32GB



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Mobile(String model, String brand, double price, Processor processor, String storage, Camera cameraType, String memory, String operatingSystem) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.processor = processor;
        this.storage = storage;
        this.cameraType = cameraType;
        this.memory = memory;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", processor=" + processor +
                ", memory='" + memory + '\'' +
                ", cameraType=" + cameraType +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }
}

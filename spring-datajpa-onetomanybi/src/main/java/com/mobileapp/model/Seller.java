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
public class Seller {
    @Column(length = 20)
    private String sellerName ;
    @Id
    @GeneratedValue(generator = "seller_gen" , strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "seller_gen",sequenceName = "seller_seq" , initialValue = 100 , allocationSize = 1)
    private Integer sellerId;

    @Column(length = 40)
    private String city ;
    @Column(length = 20)
    private double rating;
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private Set<Mobile> mobiles;


    public Seller(String sellerName, String city, double rating, Set<Mobile> mobiles) {
        this.sellerName = sellerName;
        this.city = city;
        this.rating = rating;
        this.mobiles = mobiles;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerName='" + sellerName + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", mobiles=" + mobiles +
                '}';
    }
}

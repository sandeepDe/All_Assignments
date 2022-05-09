package com.mobileapp.repository;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISellerRepository  extends JpaRepository<Seller , Integer> {



    @Query("from Seller s inner join s.mobiles m where m.brand=?1")
    List<Seller> findByMobBrand(String brand);
    @Query("from Seller s inner join s.mobiles m where m.brand=?1 and m.cameraType=?2")
    List<Seller> findByMobBrandCamera(String brand, Camera cameraType);
    @Query("from Seller s inner join s.mobiles m where m.brand=?1 and m.price=?2")
    List<Seller> findByBrandAndPrice(String brand,double price);
    @Query("from Seller s inner join s.mobiles m where m.operatingSystem=?1 and m.memory=?2")
    List<Seller> findByMobOsMem(String os,String memory);
    Seller findById(int sellerId);
    List<Seller> findByCity(String city);
    List<Seller> findByRating(double ratings);
    @Query("from Seller s inner join s.mobiles m where m.cameraType =?1")
    List<Seller> findByMobCamera(Camera cameraType);
}

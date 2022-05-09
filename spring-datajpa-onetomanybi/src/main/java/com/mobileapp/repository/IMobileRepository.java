package com.mobileapp.repository;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Mobile;
import com.mobileapp.model.Processor;
import com.mobileapp.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMobileRepository extends JpaRepository<Mobile, Integer> {



    List<Mobile> getByBrand(String brand);
    @Query("from Mobile m where m.processor=?1")
    List<Mobile> getByProcessor(Processor processor);

    @Query("from Mobile m where m.cameraType=?1")
    List<Mobile> getByCamera(Camera camera);

    @Query("from Mobile m where m.operatingSystem=?1")
    List<Mobile> getByOs(String os);

    @Query("from Mobile m where m.operatingSystem=?1 and m.memory=?2")
    List<Mobile> getByOsAndMemory(String os , String memory);

    @Query("from Mobile m where m.processor=?1 and m.memory=?2")
    List<Mobile> getByProcessorAndMem(Processor processor , String memory);

    @Query("from Mobile m where m.storage=?1")
    List<Mobile> getByStorage(Storage storage);

    @Query("from Mobile m where m.brand=?1 and m.cameraType=?2")
    List<Mobile> getByBrandAndCamera(String brand , String camera);
    @Query("from Mobile m where m.brand=?1 and m.price <?2")
    List<Mobile>  getByBrandAndLessPrice(String brand , double price);

    @Query("from Mobile m inner join m.seller s where s.sellerName= ?1")
    List <Mobile> findBySellerName(String sellerName);

    @Query("from Mobile m inner join m.seller s where s.sellerName= ?1 and s.city=?2")
    List <Mobile> findBySellerNameAndCity(String sellerName , String city);

}

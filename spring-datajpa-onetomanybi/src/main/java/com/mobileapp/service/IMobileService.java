package com.mobileapp.service;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Mobile;
import com.mobileapp.model.Processor;
import com.mobileapp.model.Storage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMobileService {


    List<Mobile> getAll();

    List<Mobile> getByBrand(String brand);

    List<Mobile> getByProcessor(Processor processor);

    List<Mobile> getByCameraType(Camera camera);
    List<Mobile> getByOs(String os);

    List<Mobile> getByOsAndMemory(String os , String memory);
    List<Mobile> getByProcessorAndMem(Processor processor , String memory);
    List<Mobile> getByStorage(Storage storage);
    List<Mobile> getByBrandAndCamera(String brand , String camera);
    List<Mobile>  getByBrandAndLessPrice(String brand , double price);
    List<Mobile> getBySellerName(String sellerName);
    List<Mobile>  getBySellerNameAndCity(String sellerName , String city);
}

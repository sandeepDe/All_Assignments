package com.mobileapp.service;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Mobile;
import com.mobileapp.model.Processor;
import com.mobileapp.model.Storage;
import com.mobileapp.repository.IMobileRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MobileServiceImpl implements IMobileService{


     IMobileRepository mobileRepository;

    public MobileServiceImpl(IMobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @Override
    public List<Mobile> getAll() {
        return mobileRepository.findAll() ;
    }

    @Override
    public List<Mobile> getByBrand(String brand) {
        return mobileRepository.getByBrand(brand);
    }

    @Override
    public List<Mobile> getByProcessor(Processor processor) {
        return mobileRepository.getByProcessor(processor);
    }


    @Override
    public List<Mobile> getByCameraType(Camera camera) {
        return mobileRepository.getByCamera(camera);
    }

    @Override
    public List<Mobile> getByOs(String os) {
        return mobileRepository.getByOs(os);
    }

    @Override
    public List<Mobile> getByOsAndMemory(String os, String memory) {
        return mobileRepository.getByOsAndMemory(os,memory);
    }

    @Override
    public List<Mobile> getByProcessorAndMem(Processor processor, String memory) {
        return mobileRepository.getByProcessorAndMem(processor, memory);
    }

    @Override
    public List<Mobile> getByStorage(Storage storage) {
        return mobileRepository.getByStorage(storage);
    }

    @Override
    public List<Mobile> getByBrandAndCamera(String brand, String camera) {
        return mobileRepository.getByBrandAndCamera(brand,camera);
    }

    @Override
    public List<Mobile> getByBrandAndLessPrice(String brand, double price) {
        return mobileRepository.getByBrandAndLessPrice(brand,price);
    }

    @Override
    public List<Mobile> getBySellerName(String sellerName) {
        return mobileRepository.findBySellerName(sellerName);
    }

    @Override
    public List<Mobile> getBySellerNameAndCity(String sellerName, String city) {
        return mobileRepository.findBySellerNameAndCity(sellerName,city);
    }
}

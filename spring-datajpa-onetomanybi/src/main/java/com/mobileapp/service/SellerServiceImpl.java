package com.mobileapp.service;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Seller;
import com.mobileapp.repository.ISellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements ISellerService{
    ISellerRepository sellerRepository;

    public SellerServiceImpl(ISellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void addSeller(Seller seller) {
        sellerRepository.save(seller);

    }

    @Override
    public void updateSeller(Seller seller) {
        sellerRepository.save(seller);

    }

    @Override
    public void deleteSeller(int sellerId) {
        sellerRepository.deleteById(sellerId);

    }

    @Override
    public Seller getById(int sellerId) {
        return sellerRepository.findById(sellerId);
    }

    @Override
    public List<Seller> getByCity(String city) {
        return sellerRepository.findByCity(city);
    }

    @Override
    public List<Seller> getByRatings(double ratings) {
        return sellerRepository.findByRating(ratings);
    }

    @Override
    public List<Seller> getByMobBrand(String brand) {
        return sellerRepository.findByMobBrand(brand);
    }

    @Override
    public List<Seller> getByMobBrandCamera(String brand, Camera cameraType) {
        return sellerRepository.findByMobBrandCamera(brand,cameraType);
    }

    @Override
    public List<Seller> getByMobCamera(Camera cameraType) {
        return sellerRepository.findByMobCamera(cameraType);
    }

    @Override
    public List<Seller> getByMobBrandPrice(String brand, double price) {
        return sellerRepository.findByBrandAndPrice(brand,price);
    }

    @Override
    public List<Seller> getByMobOsMem(String os, String memory) {
        return sellerRepository.findByMobOsMem(os,memory);
    }
}

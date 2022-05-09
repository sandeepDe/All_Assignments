package com.mobileapp;

import com.mobileapp.model.*;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringDatajpaOnetomanybiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanybiApplication.class, args);
	}

	ISellerService sellerService;
	@Autowired
	public void setSellerService(ISellerService sellerService) {
		this.sellerService = sellerService;
	}

	IMobileService mobileService;

	@Autowired
	public void setMobileService(IMobileService mobileService) {
		this.mobileService = mobileService;
	}

	@Override
	public void run(String... args) throws Exception {


		Set<Mobile> mobiles = new HashSet<Mobile>(Arrays.asList(
				new Mobile("Note13" , "Mi",40000,Processor.SNAPDRAGON,Storage.STORAGE12.name(),Camera.DUAL,Memory.MEMORY4.totalRam,Os.ANDRIOD.name()),
				new Mobile("7" , "Poco",60000,Processor.MEDIATEK,Storage.STORAGE12.name(),Camera.DUAL,Memory.MEMORY4.totalRam,Os.ANDRIOD.name())
		));

		Seller seller1 = new Seller("Swamy Seller","Bangalore",4.1,mobiles);
		Seller seller2 = new Seller("E3 Seller","Hyderabad",4.7,mobiles);
		Seller seller3 = new Seller("F2 Seller","Rajahmundry",4.3,mobiles);
        //sellerService.addSeller(seller1);

		Seller seller = sellerService.getById(101);

		seller.setCity("Kakinada");

		//sellerService.updateSeller(seller);

		//System.out.println(sellerService.getById(101));

		//sellerService.getByMobBrand("Apple").forEach(System.out::println);

		//sellerService.getByRatings(4.5).forEach(System.out::println);

		//sellerService.getByMobBrandCamera("Samsung",Camera.DUAL).forEach(System.out::println);


		//mobileService.getAll().forEach(System.out::println);

		//mobileService.getBySellerName("Swamy Seller").forEach(System.out::println);

		//mobileService.getByBrandAndLessPrice("Apple" ,70000).forEach(System.out::println);

		//mobileService.getByBrand("Apple").forEach(System.out::println);

		//mobileService.getByBrandAndCamera("Apple" ,"DUAL").forEach(System.out::println);

		//mobileService.getBySellerNameAndCity("Swamy Seller" ,"Bangalore" ).forEach(System.out::println);

		//mobileService.getByProcessor(Processor.MEDIATEK).forEach(System.out::println);


		mobileService.getByCameraType(Camera.DUAL).forEach(System.out::println);





	}
}

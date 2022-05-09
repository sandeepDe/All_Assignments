package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class ProductController {

	private IProductService productService;

	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/")
	public String home(ModelMap map) {

		List<Product> products = productService.getAll();

		map.addAttribute("products", products);

		return "home";
	}

	@RequestMapping("/addProduct")
	public String adProduct(Product product) {
		productService.addProduct(product);

		System.out.println("hello");

		return "admin";
	}

	@RequestMapping("/search")
	public String searchProduct(@RequestParam("choice") String choice, ModelMap map) {

		List<Product> products = productService.findByChoice(choice);

		map.addAttribute("products", products);

		return "home";

	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int prodId) {
		productService.deleteProduct(prodId);
		return "admin";
	}

	@RequestMapping("/getOneProduct")
	public String getOne(@RequestParam("productId") int productId, Model model) {
		Product product = productService.getById(productId);
		model.addAttribute("product", product);
		return "updateProductForm";
	}

	@RequestMapping("/updateProduct")
	public String updateProduct(Product product) {
		productService.updateProduct(product);
		return "admin";
	}

}

package com.productapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.service.IProductService;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String admin() {
		return "admin";

	}

	@RequestMapping("/addForm")
	public String showAddForm() {
		return "addProductForm";
	}

	@RequestMapping("/deleteForm")
	public String deleteForm() {
		return "deleteProductForm";
	}

	@RequestMapping("/editForm")
	public String showeditForm() {
		return "editProductForm";
	}

}

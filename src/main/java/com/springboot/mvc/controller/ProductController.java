package com.springboot.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.mvc.model.Product;
import com.springboot.mvc.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService ps;

//display list of products

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allproductlist", ps.getAllProduct());
		return "index";
	}

//Add list of products
	@GetMapping("/addnew")
	public String addnew(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "add_product";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("product") Product product) {
		ps.save(product);
		return "redirect:/";
	}
//
////update list of products
//
//	@GetMapping("/Update/{id}")
//	public String update(@PathVariable(value = "id") Integer id, Model model) {
//		Product product = ps.getById(id);
//
//		model.addAttribute("product", product);
//		return "update";
//	}

}

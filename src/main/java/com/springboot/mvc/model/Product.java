package com.springboot.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name, made_in, brand;
	private float price;

//getter setter method

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String made_in, String brand, float price) {
		super();
		this.id = id;
		this.name = name;
		this.made_in = made_in;
		this.brand = brand;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMade_in() {
		return made_in;
	}

	public void setMade_in(String made_in) {
		this.made_in = made_in;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

//To String Method

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", made_in=" + made_in + ", brand=" + brand + ", price=" + price
				+ "]";
	}

}

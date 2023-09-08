package com.springboot.mvc.service;

import java.sql.Connection;

import org.springframework.stereotype.Service;


public interface DbService {


	public   Connection getConnection(String method) ;
	
	public  void closeConnection(Connection con,String method);
		// TODO Auto-generated method stub
		
	}
	
	

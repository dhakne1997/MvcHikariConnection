package com.springboot.mvc.service;

import org.springframework.stereotype.Service;


public interface ConfigService {

	public String getProperty(String key,String defaultValue);
	
}

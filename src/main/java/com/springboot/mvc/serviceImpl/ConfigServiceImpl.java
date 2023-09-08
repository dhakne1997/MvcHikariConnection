package com.springboot.mvc.serviceImpl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springboot.mvc.service.ConfigService;



@Service
public class ConfigServiceImpl implements ConfigService {
	//@Autowired
	private Environment env;
	public ConfigServiceImpl(@Autowired Environment env) {
		
		this.env=env;
		System.out.println(getProperty("db", null));
	}
	@Override
	public String getProperty(String key, String defaultValue) {
		return env.getProperty(key, defaultValue);
	}
	
//	@Override
//	public String getProperty(String key, String defaultValue) {
//		return env.getProperty(key, defaultValue);
//	}
	
}

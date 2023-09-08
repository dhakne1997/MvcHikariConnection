package com.springboot.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class UtilImpl implements Util {

	@Override
	public boolean isNeitherNullNorEmpty(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj==null) {
			
			return false;
		}
		
		if(obj instanceof String) {
			
			if( obj.equals("")) {
				
				return false;
			}
		
		}
		return true;
	}

}

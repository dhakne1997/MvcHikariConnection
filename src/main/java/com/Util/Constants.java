package com.Util;

public class Constants {

	
	
	public interface ERROR_CODE{
		public int SUCCESS=100;
		public int INVALID_RTYPE=101;
		public int NO_DATA_FOUND=102;
		public int OTP_GENERATION_FALED=103;
		public int INVALID_MOBILE_NO=104;
		public int SERVER_ERROR=105;
		public int INVALID_OTP=106;
		public int OTP_EXPIRED=107;
	}
	
	
	public interface SESSION_ERRORCODES{
		public String SUCCESS="200";
		public String USER_ID_NULL="201";
		public String SESSION_EXPIRED="202";
		public String APP_VERSION_NOT_COMPATIBLE="203";
		public String HEADER_REQEST_PARAM_NOT_FOUND="204";
		public String AUTH_TOKEN_MISMATCH="205";
		public String AUTH_TOKEN_NULL="206";
		
	}
	
	
	
	public interface R_TYPE{

		
		
		public String PRODUCT="PRODUCT";
	
		
		
	}
	
}

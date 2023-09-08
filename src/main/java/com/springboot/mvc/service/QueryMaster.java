package com.springboot.mvc.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.slf4j.Logger;


public interface QueryMaster {

	 public ResultSet select(String query, List<Object> param, Connection con , Logger log);
	 public int updateInsert(String query, List<Object> param, int poolId, Logger log,Connection con);
}

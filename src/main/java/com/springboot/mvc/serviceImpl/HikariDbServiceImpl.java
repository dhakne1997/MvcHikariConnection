package com.springboot.mvc.serviceImpl;


import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mvc.service.ConfigService;
import com.springboot.mvc.service.DbService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;




@Service
public class HikariDbServiceImpl implements DbService {

	
	//@Autowired
	private ConfigService configService;

	@Autowired
	public HikariDbServiceImpl(ConfigService config) {
		this.configService=config;
		init();
		
	}
	
	HikariDataSource ds=null;

	private void init() {
		

			
			HikariConfig config = new HikariConfig();

			config.setJdbcUrl(configService.getProperty("perstDbUrl", null));

			config.setUsername(configService.getProperty("perstDbUser", null));

			config.setPassword(configService.getProperty("perstDbPassword", null));

			config.setDriverClassName(configService.getProperty("perstDbDriver", null));

			config.setConnectionTestQuery("select 1 ");

			config.setMinimumIdle(Integer.parseInt(configService.getProperty("MIN_POOL_SIZE", "5")));

			config.setMaximumPoolSize(Integer.parseInt(configService.getProperty("MAX_POOL_SIZE", "10")));

			config.setConnectionTimeout(Integer.parseInt(configService.getProperty("CONNECTION_TIMEOUT", "30000")));

			// config.setKeepaliveTime(Integer.parseInt(configService.getConfigValue("KEEP_ALIVE_TIME","600000")));

			config.setMaxLifetime(Integer.parseInt(configService.getProperty("MAX_LIFETIME", "1800000")));

			config.addDataSourceProperty("cachePrepStmts", "true");
			config.addDataSourceProperty("prepStmtCacheSize", "250");
			config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
			ds = new HikariDataSource(config);
		
	}
	
	
	@Override
	public Connection getConnection(String method) {
		Connection con=null;
		try {
			con= ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

	@Override
	public void closeConnection(Connection con, String method) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

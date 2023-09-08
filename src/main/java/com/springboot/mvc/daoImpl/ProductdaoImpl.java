package com.springboot.mvc.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.mvc.dao.Productdao;
import com.springboot.mvc.model.Product;
import com.springboot.mvc.service.DbService;
import com.springboot.mvc.service.QueryMaster;
@Repository
public class ProductdaoImpl implements Productdao{

	static Logger log = LoggerFactory.getLogger(ProductdaoImpl.class);
	QueryMaster queryMaster;
	
	@Autowired
	public ProductdaoImpl(QueryMaster queryMaster) {
		this.queryMaster=queryMaster;
	}
	
	@Autowired
	DbService dbService;
	
	
	@Override
	public List<Product> findAll() {
Connection con=null;
		
		List<Product>list =new ArrayList<Product>();
		try {
			con =dbService.getConnection("getProduct");
			
			StringBuilder query = new StringBuilder();
	
			query.append("select * from Product");
			ResultSet rs = queryMaster.select(query.toString(), null, con, log);
			if (rs != null) {
				while (rs.next()) {
					Product obj = new Product();
					obj.setId(rs.getInt("id"));
					obj.setName(rs.getString("name"));
					obj.setMade_in(rs.getString("made_in"));
					obj.setBrand(rs.getString("brand"));
					obj.setPrice(rs.getInt("price"));
					
					

					list.add(obj);
				}
				
			}
		} catch ( Exception e) {
e.printStackTrace();
		}
		finally {
			dbService.closeConnection(con, "getemp");
		}
		return list;
	}



	

	
	
	
	@Override
	public int save(Product product) {
		
		Connection con=null;
		int result=0;
		try {

			con = dbService.getConnection("getProduct");

			StringBuilder query = new StringBuilder();
			query.append("insert into Product");
			query.append("(id,");
			query.append("name,");
			query.append("made_in,");
			query.append("brand,");
			query.append("price )");

			query.append(" values ");
		
			query.append("(?,");
			query.append("?,");
			query.append("?,");
			query.append("?,");

			query.append("?)");
			
			ArrayList<Object> param = new ArrayList<Object>();

			param.clear();
            param.add(product.getId());
            param.add(product.getName());
            param.add(product.getMade_in());
            param.add(product.getBrand());
            param.add(product.getPrice());
            
            result = queryMaster.updateInsert(query.toString(), param, 0, log, con);


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result=1;
		}
		finally {
			dbService.closeConnection(con, "getProduct");
		
		}
		return result;
	}



		
		
}

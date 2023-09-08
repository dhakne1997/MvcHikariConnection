package com.neml.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.mvc.service.DbService;
import com.springboot.mvc.service.QueryMaster;

import com.springboot.mvc.service.Util;

@Service
@Primary
public class QueryMasterService implements QueryMaster {

	@Autowired
	DbService dbService;

	@Autowired
	Util util;

	@Override
	public ResultSet select(String query, List<Object> param, Connection con, Logger log) {
		long executionStartTime = 0;
		long executionEndTime = 0;
		StringBuffer logString = null;
		ResultSet rs = null;
		try {
			PreparedStatement prepstmt = null;
			if (log != null) {
				// log.write(query);
				log.info("select() :: Query=" + query);
			}
			logString = new StringBuffer("DBUser: " + con.getMetaData().getUserName() + " | " + query)
					.append("  with values ::");
			prepstmt = con.prepareStatement(query);

			if (util.isNeitherNullNorEmpty(param)) {
				int q = param.size();
				for (int j = 1; j <= q; j++) {
					Object temp = param.get(j - 1);
					logString.append(temp).append("|");
					prepstmt.setObject(j, temp);
				}
			}

			if (log != null) {
				// String temp = logString.toString();
				// log.info(temp);
				log.info("select() :: " + logString.toString());
			}
			executionStartTime = System.currentTimeMillis();
			rs = prepstmt.executeQuery();
			executionEndTime = System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
			executionEndTime = System.currentTimeMillis();
			if (log != null) {
				// log.error("Exception while select : " + e.getMessage());
				log.info("select() :: Exception while select :" + e.getMessage());
			}
		} finally {
			try {
				if (log != null) {
					// log.info("Query Execution time :" + (executionEndTime-executionStartTime)+ "
					// milliseconds");
					log.info("select() :: " + "Query Execution time :" + (executionEndTime - executionStartTime)
							+ " milliseconds");
				}
				if (param != null)
					param.clear();
				param = null;
				query = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	/**
	 * @param query The select query which needs to be run on the database
	 * @param param List of objects which form the parameters passed in the query
	 * @param db    Defines which DB needs to be accessed
	 * @param log   Variable of log4j, used for logging into respective classes
	 * @return updateinsertResult (int) - number of rows which got inserted/updated
	 */
	@Override
	public int updateInsert(String query, List<Object> param, int poolId, Logger log, Connection con) {
		int updateinsertResult = 0;
		boolean conToBeClosed = false;
		long executionStartTime = 0;
		long executionEndTime = 0;
		PreparedStatement prepstmt = null;
		StringBuffer logString = null;
		ResultSet rs = null;
		try {

//			if (!Util.isNeitherNullNorEmpty(con) || con.isClosed()){
//				conToBeClosed = true;
//				con = dbService.getConnection("updateInsert", null);
//			}
			logString = new StringBuffer(
					"PoolId: " + poolId + " DBUser: " + con.getMetaData().getUserName() + " | " + query)
							.append("  with values ::");
			prepstmt = con.prepareStatement(query);

			if (param != null) {
				int q = param.size();
				for (int j = 1; j <= q; j++) {
					Object temp = param.get(j - 1);
					logString.append(temp).append(",");
					prepstmt.setObject(j, temp);
				}
			}

			if (log != null) {

				log.info("updateInsert() :: " + logString.toString());

			}

			executionStartTime = System.currentTimeMillis();
			updateinsertResult = prepstmt.executeUpdate();
			executionEndTime = System.currentTimeMillis();
			if (log != null) {
				logString.setLength(0);
				logString.append("result of updateInsert ::").append(updateinsertResult);
				log.info("updateInsert() :: " + logString.toString());
			}
		} catch (Exception e) {
			executionEndTime = System.currentTimeMillis();
			updateinsertResult = -1;
			if (log != null) {
				// log.error("Exception while select : " + e.getMessage());
				log.info("updateInsert() :: Exception while updateInsert :" + e.getMessage());
			}
			e.printStackTrace();
		} finally {
			try {
				if (log != null) {
					// log.info("Query Execution time :" + (executionEndTime-executionStartTime)+ "
					// milliseconds");
					log.info("updateInsert() :: " + "Query Execution time :" + (executionEndTime - executionStartTime)
							+ " milliseconds");
				}
				if (conToBeClosed) {
					if (con != null) {
						dbService.closeConnection(con, "updateInsert");
					}
				}
				if (prepstmt != null) {
					prepstmt.close();
				}
				if (param != null)
					param.clear();
				param = null;
				query = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateinsertResult;
	}

}

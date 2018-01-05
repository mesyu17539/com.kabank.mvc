package com.kabank.mvc.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constants.AdminSql;
import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.AdminDAO;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public void createMembers(String tname) {
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			Statement stat=conn.createStatement();
			stat.executeQuery(AdminSql.CREATE_MEMBER(tname));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> selectTable() {
		List<String> list=new ArrayList<>();
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			Statement stat=conn.createStatement();
			ResultSet set=stat.executeQuery(AdminSql.SELECTOR_TNAME);
			while(set.next()) {
				list.add(set.getString("TNAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

package com.kabank.mvc.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.enums.DDLENUM;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public void createMembers(String tname) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeQuery(DDLENUM.CREATE_TABLE_MEMBER.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> selectTable() {
		List<String> list=new ArrayList<>();
		try {
			ResultSet set=DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeQuery("SELECT * FROM tab");
			while(set.next()) {
				list.add(set.getString("TNAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

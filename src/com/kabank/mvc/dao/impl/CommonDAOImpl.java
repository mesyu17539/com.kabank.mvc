package com.kabank.mvc.dao.impl;

import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.constants.MemberSQL;
import com.kabank.mvc.dao.CommonDAO;
import java.sql.*;

public class CommonDAOImpl implements CommonDAO {

	@Override
	public String selectTableCount() {
		String count="";
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			Statement stat=conn.createStatement();
			ResultSet sel=stat.executeQuery(MemberSQL.count(MemberSQL.MTNAME));
			//스트링이 아닌 method를 쓴 이유는 편집하고나서 편집된 내용은 메소드의 경우 할당되지않고 소멸되어서이다
			while(sel.next()) {
				count = sel.getString("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}

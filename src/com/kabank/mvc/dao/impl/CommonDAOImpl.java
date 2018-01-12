package com.kabank.mvc.dao.impl;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.enums.DMLENUM;
import com.kabank.mvc.enums.TNameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

import java.sql.*;

public class CommonDAOImpl implements CommonDAO {

	@Override
	public String selectTableCount() {
		String count="";
		try {
			ResultSet sel=DatabaseFactory.create(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeQuery(DMLENUM.COUNT.toString()+TNameEnum.MEMBER);
/*			ResultSet sel=stat.executeQuery(MemberSQL.count(MemberSQL.MTNAME));*/
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

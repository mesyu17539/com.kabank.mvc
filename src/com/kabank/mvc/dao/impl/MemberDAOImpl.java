package com.kabank.mvc.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.constants.MemberSQL;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO{
	@Override
	public List<MemberBean> selectMembers(String id, String pass) {
		List<MemberBean> list=new ArrayList<>();
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			Statement stat=conn.createStatement();
			ResultSet sel=stat.executeQuery(MemberSQL.MEMBERS);
			MemberBean member = null;
			while(sel.next()) {
				member=new MemberBean();
				member.setId(sel.getString("ID"));
				member.setPass(sel.getString("PASS"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
}

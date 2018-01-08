package com.kabank.mvc.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.constants.MemberSQL;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.util.Enums;

public class MemberDAOImpl implements MemberDAO{
	List<MemberBean> list;
	Connection conn;
	Statement stat;
	ResultSet sel;
	@Override
	public List<MemberBean> selectMembers(String id, String pass) {
		list=new ArrayList<>();
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			conn=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			stat=conn.createStatement();
			sel=stat.executeQuery(MemberSQL.MEMBERS);
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

	@Override
	public void memberJoin(MemberBean bean) {
		System.out.println("쿼리문 진입");
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			stat=conn.createStatement();
			String a=
					String.format("%s %s %s("
							+Enums.getEnu()+")"
							+ " VALUES("
							+Enums.getBlanks(Enums.MemberCalum.values().length)
							+")",
							Enums.DML.INSERT,
							Enums.DML.INTO,
							Enums.TABLE.MEMBER,
							bean.getId(),
							bean.getName(),
							bean.getPass(),
							bean.getSsn(),
							bean.getPhone(),
							bean.getEmail(),
							bean.getProfile(),
							bean.getAddr()
							);
			System.out.println(a);
			//stat.executeQuery(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

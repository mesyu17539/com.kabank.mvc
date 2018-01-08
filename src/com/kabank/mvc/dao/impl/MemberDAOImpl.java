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
							bean.getPass(),
							bean.getName(),
							bean.getSsn(),
							bean.getPhone(),
							bean.getEmail(),
							bean.getProfile(),
							bean.getAddr()
							);
			System.out.println(a);
			stat.executeQuery(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberBean selectMemberById(MemberBean bean) {
		System.out.println("DAOIMPL 진입");
		MemberBean bea=null;
		String sql="SELECT * FROM MEMBER WHERE id=? AND pass=?";
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1, bean.getId());
			pstat.setString(2, bean.getPass());
			ResultSet rs=pstat.executeQuery();
			while(rs.next()) {
				bea=new MemberBean();
				System.out.println("id 받은 값 : "+rs.getString("id"));
				System.out.println("pass 받은 값 : "+rs.getString("pass"));
				bea.setId(rs.getString("id"));
				bea.setPass(rs.getString("pass"));
				bea.setName(rs.getString("name"));
				bea.setSsn(rs.getString("ssn"));
				bea.setPhone(rs.getString("phone"));
				bea.setEmail(rs.getString("email"));
				bea.setProfile(rs.getString("profile"));
				bea.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bea;
	}
	
}

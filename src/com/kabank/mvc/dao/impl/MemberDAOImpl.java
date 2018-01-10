package com.kabank.mvc.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLENUM;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.util.Enums;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();
	}
	private MemberDAOImpl() {//Thread single패턴
	/*	try {
			Class.forName(DBMS.ORACLE_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
/*	private static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	private MemberDAOImpl() {}
*/	List<MemberBean> list;
	Connection conn;
	Statement stat;
	ResultSet sel;
	@Override
	public List<MemberBean> selectMembers(String id, String pass) {
		list=new ArrayList<>();
		try {
			sel=DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeQuery(new StringBuffer(DMLENUM.SELECT.toString()).insert(7, Enums.getEnu().toString())
							+Enums.TABLE.MEMBER.toString())
					;
			/*SELECT id, pass, name,ssn,phone, 
			 * email,profile,addr FROM MEMBER*/
			/*sel=DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.execute(
							new StringBuffer((String.valueOf(DMLENUM.SELECT))+(Enums.TABLE.MEMBER))
							.insert(6," id, pass, name,ssn,phone,email,profile,addr ")
							
							);*/
/*			sel=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD)
					.createStatement()
					.executeQuery(MemberSQL.MEMBERS)
					;*/			
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
			DatabaseFactory.createDatabase(Vendor.ORACLE)
				.getConnection()
				.createStatement()
				.executeUpdate(String.format("%s %s %s("
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
					));
		}catch(Exception e) {
			e.printStackTrace();
		}
		/*try {
			DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD)
			.createStatement()
			.executeQuery((String.format("%s %s %s("
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
						));
			}catch(Exception e) {
				e.printStackTrace();
			}*/
	}

	public MemberBean selectMemberById(MemberBean bean) {
		System.out.println("DAOIMPL 진입");
		MemberBean bea=null;
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeQuery(
					String.format(new StringBuffer(DMLENUM.SELECT.toString()).insert(7, Enums.getEnu().toString())
							+Enums.TABLE.MEMBER.toString()
							+DMLENUM.WHERE.toString()
							,bean.getId(),bean.getPass()));
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
/*	public MemberBean selectMemberById(MemberBean bean) {
		System.out.println("DAOIMPL 진입");
		MemberBean bea=null;
		try {
			ResultSet rs=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM MEMBER where id= '%s' AND pass='%s'",bean.getId(),bean.getPass()));
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
*//*	public MemberBean selectMemberById(MemberBean bean) {
		System.out.println("DAOIMPL 진입");
		MemberBean bea=null;
		String sql="SELECT * FROM MEMBER WHERE id=? AND pass=?";
		try {
			PreparedStatement pstat=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD).prepareStatement(sql);
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
*/	
}

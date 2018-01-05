package com.kabank.mvc.constants;

public class AdminSql {
	public static String CREATE_MEMBER(String tname) {
		return "CREATE TABLE "
				+tname
				+"("
				+" ID VARCHAR2(20) PRIMARY KEY,"
				+" name VARCHAR2(20), "
				+" pass VARCHAR2(20), "
				+" ssn VARCHAR2(20), "
				+" phone VARCHAR2(20), "
				+" email VARCHAR2(20), "
				+" profile VARCHAR2(20), "
				+" addr VARCHAR2(20) "
				+")";
	}
	public static final String CREATE_ATTEND="",
			SELECTOR_TNAME="SELECT * FROM tab";
	
}

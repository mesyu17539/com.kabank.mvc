package com.kabank.mvc.constants;

public class MemberSQL {
	public static String count(String tname) {
		return "SELECT COUNT(*) AS count FROM "+tname;
	}/*리턴할때마다 변해야하므로 final을 쓰지 않습니다*/
	public static final String MTNAME="Member",
			MEMBERS="SELECT id, pass, name,ssn,phone, email,profile,addr FROM MEMBER";
}

package com.kabank.mvc.util;

public class Enums {
	public enum MemberCalum {
		ID, PASS,NAME,SSN,PHONE,EMAIL,PROFILE,ADDR
	}
	public enum AttendCulum{
		ID, PASS, NAME
	}
	public enum TABLE{
		MEMBER,ATTEND,ADMIN
	}
	public enum DML{
		SELECT,INSERT,INTO,UPDATE,DELETE,FROM
	}
	public static String getEnu() {
		String enu="";
		Enums.MemberCalum[] en=Enums.MemberCalum.values();
		for(int i=0;i<en.length;i++) {
			if(i==en.length-1) {
				enu+=en[i];
			}else {
				enu+=en[i]+",";
			}
		}
		/*for(Enums.MemberCalum n:Enums.MemberCalum.values()) {
			if(n.ordinal()==Enums.MemberCalum.values().length-1) {
				enu+=n+"";
			}else {
				enu+=n+",";
			}
		}*/
		return enu;
	}
	public static String getBlanks(int count) {
		String blanks="";
		for(int i=0;i<count;i++) {
			if(i==count-1) {
				blanks += "'%s'";
			}else {
				blanks += "'%s',";
			}
		}
		return blanks;
	}
	public static String getNBlanks(int count) {
		String blanks="";
		for(int i=0;i<count;i++) {
			if(i==count-1) {
				blanks += "%s";
			}else {
				blanks += "%s ";
			}
		}
		return blanks;
	}
}

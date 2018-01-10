package com.kabank.mvc.util;

public enum MemberEnum {
	ID, PASS,NAME,SSN,PHONE,EMAIL,PROFILE,ADDR,
	PROPERTIES(){
		public String toString() {
			return ID+","+PASS+","+NAME+","+SSN+","+PHONE+","+EMAIL+","+ADDR+","+PROFILE;
		}
	}
}
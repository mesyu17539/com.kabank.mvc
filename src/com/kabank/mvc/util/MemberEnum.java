package com.kabank.mvc.util;

public enum MemberEnum {
	ID, PASS,NAME,SSN,PHONE,EMAIL,PROFILE,ADDR,
	PROPERTIES{
		public String toString() {
			return ID+","+PASS+","+NAME+","+SSN+","+PHONE+","+EMAIL+","+ADDR+","+PROFILE;
		}
	},
	LOGIN{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "SELECT ID, PASS,NAME,SSN,PHONE,EMAIL,ADDR,PROFILE FROM Member "
					+ "where id LIKE '$' AND pass LIKE '@'";
		}
	}
}
package com.kabank.mvc.enums;

public enum TNameEnum {
	MEMBER, ATTEND,
	TNAMES{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return MEMBER+","+ATTEND;
		}
	}
}

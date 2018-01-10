package com.kabank.mvc.enums;

public enum DMLENUM {
	COUNT{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "SELECT COUNT(*) AS count FROM ";
		}
	},
	SELECT{
		@Override
		public String toString() {
			return "SELECT  FROM ";
		}
	},
	WHERE{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " where id= '%s' AND pass='%s'";
		}
	}
}

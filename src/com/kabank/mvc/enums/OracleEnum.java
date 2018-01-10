package com.kabank.mvc.enums;

public enum OracleEnum {
	/*ORACLE_CONECTIONURL="jdbc:oracle:thin:@localhost:1521:xe",
			ORACLE_USERNAME="bitcamp",
			ORACLE_PASSWORD="bitcamp",
			ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";*/
	ORACLE_DRIVER("oracle.jdbc.driver.OracleDriver"),
	ORACLE_CONNECTION_URL("jdbc:oracle:thin:@localhost:1521:xe"),
	ORACLE_USERNAME("bitcamp"),
	ORACLE_USERPASS("bitcamp");
	public final String value;
	private OracleEnum(String value) {//생성자
		this.value=value;
	}
	public String getValue() {
		return value;
	}
}

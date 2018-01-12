package com.kabank.mvc.factory;

import java.sql.Connection;

public class MySql implements IDatabase{
	private Connection conn;
	private String driver,url,id,pw;
	
	public MySql(Connection conn, String driver, String url, String id, String pw) {
		this.conn = conn;
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}

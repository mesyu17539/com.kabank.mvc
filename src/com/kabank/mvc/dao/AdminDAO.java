package com.kabank.mvc.dao;

import java.util.List;

public interface AdminDAO {
	public void createMembers(String tname);
	public List<String> selectTable();
}

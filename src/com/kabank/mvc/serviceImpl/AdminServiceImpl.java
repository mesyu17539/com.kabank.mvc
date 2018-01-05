package com.kabank.mvc.serviceImpl;

import java.util.List;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.dao.impl.AdminDAOImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService{
	AdminDAO adminDAO;

	public AdminServiceImpl() {
		adminDAO=new AdminDAOImpl();
	}
	@Override
	public void creatTable(String tname) {
		boolean bool=true;
		List<String> list=adminDAO.selectTable();
		for(int i=0;i<list.size();i++) {
			if(tname.equals(list.get(i))) {
				bool=false;
			}
		}
		System.out.println(bool);
		if(bool) {
			adminDAO.createMembers(tname);
		}
	}

}

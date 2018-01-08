package com.kabank.mvc.serviceImpl;

import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.dao.impl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{

	@Override
	public boolean login(String id, String pass) {
		List<MemberBean> mbean=new MemberDAOImpl().selectMembers(id,pass);
		boolean bool=false;
		for(int i=0;i<mbean.size();i++) {
			if(id.equals(mbean.get(i).getId())) {
				if(pass.equals(mbean.get(i).getPass()))
				bool=true;
			}
		}
		return bool;
	}

	@Override
	public void join(MemberBean bean) {
		System.out.println("서비스impl :\n"+bean);
		new MemberDAOImpl().memberJoin(bean);
	}

}

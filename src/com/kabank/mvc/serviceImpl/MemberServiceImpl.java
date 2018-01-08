package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.impl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{

	@Override
	public MemberBean findById(MemberBean bean) {
		System.out.println("ServiceIMPL 진입");
		MemberBean mbean=new MemberDAOImpl().selectMemberById(bean);
		boolean bool=false;
		System.out.println("비교문");
/*		List<MemberBean> mbean=new MemberDAOImpl().selectMembers(id,pass);
		for(int i=0;i<mbean.size();i++) {
			if(id.equals(mbean.get(i).getId())) {
				if(pass.equals(mbean.get(i).getPass()))
				bool=true;
			}
		}
*/		System.out.println(bool);
		return mbean;
	}

	@Override
	public void join(MemberBean bean) {
		System.out.println("서비스impl :\n"+bean);
		new MemberDAOImpl().memberJoin(bean);
	}

}

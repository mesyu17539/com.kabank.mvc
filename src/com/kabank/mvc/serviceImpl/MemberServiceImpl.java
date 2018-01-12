package com.kabank.mvc.serviceImpl;

import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.dao.impl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {}
	@Override
	public MemberBean findById(MemberBean bean) {
		System.out.println("ServiceIMPL 진입");
		System.out.println(MemberDAOImpl.getInstance().selectMemberById(bean));
		return MemberDAOImpl.getInstance().selectMemberById(bean);
		
		/*for(int i=0;i<mbean.size();i++) {
			if(bean.getId().equals(mbean.get(i).getId())) {
				if(bean.getPass().equals(mbean.get(i).getPass()))
					bool=true;
					bea=mbean.get(i);
			}
		}*/
/*		List<MemberBean> mbean=new MemberDAOImpl().selectMembers(id,pass);
		for(int i=0;i<mbean.size();i++) {
			if(id.equals(mbean.get(i).getId())) {
				if(pass.equals(mbean.get(i).getPass()))
				bool=true;
			}
		}*/		
	}

	@Override
	public void join(MemberBean bean) {
		System.out.println("서비스impl :\n"+bean);
		 MemberDAOImpl.getInstance().memberJoin(bean);
	}
	@Override
	public MemberBean login() {
		// TODO Auto-generated method stub
		return MemberDAOImpl.getInstance().login();
	}

}

package com.kabank.mvc.serviceImpl;

import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.dao.impl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {
		dao=MemberDAOImpl.getInstance();
	}
	@Override
	public MemberBean findById(MemberBean bean) {
		System.out.println("ServiceIMPL 진입");
		List<MemberBean> mbean=dao.selectMemberById(bean);
		MemberBean bea=null;
		System.out.println("비교문");
		for(MemberBean m:mbean) {
			if(bean.getId().equals(m.getId())&&bean.getPass().equals(m.getPass())) {
				bea=m;
			}
		}
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
		}
*/		System.out.println(bea);
		return bea;
	}

	@Override
	public void join(MemberBean bean) {
		System.out.println("서비스impl :\n"+bean);
		dao.memberJoin(bean);
	}

}

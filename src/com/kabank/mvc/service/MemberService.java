package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	public boolean login(String id,String pass);
	public void join(MemberBean bean);
}

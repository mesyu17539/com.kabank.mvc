package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	public MemberBean findById(MemberBean bean);
	public void join(MemberBean bean);
}

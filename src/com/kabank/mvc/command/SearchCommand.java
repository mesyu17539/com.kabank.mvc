package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.Iterator.ParamIterator;

public class SearchCommand  implements IOrder{
	Map<?,?> map;
	public SearchCommand(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		map=ParamIterator.execute(request);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String id=String.valueOf(map.get("id"));//id는 login jsp 의 name:id.
		String pass=String.valueOf(map.get("pass"));//pass는 login jsp 의 name:pass.
		System.out.println("서치 id : "+id+pass);
		InitCommand.cmd.setColum("id/pass");
		InitCommand.cmd.setData(id+"/"+pass);
	}
}

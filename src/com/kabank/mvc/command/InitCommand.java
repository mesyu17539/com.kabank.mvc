package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.Iterator.ParamIterator;
import com.kabank.mvc.factory.ActionFactory;

public class InitCommand implements IOrder{
	public static Command cmd;
	Map<?,?> map;
	public InitCommand(HttpServletRequest request) {
		cmd=new Command();
		map=ParamIterator.execute(request);
	}
	@Override
	public void execute() {
		String o= String.valueOf(map.get("cmd"));
		if(o.equals("null")) {
			cmd.setAction(ActionFactory.create("move"));
		}
		cmd.setAction(ActionFactory.create(o));
	}
	
}

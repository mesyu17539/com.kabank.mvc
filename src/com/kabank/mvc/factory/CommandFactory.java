package com.kabank.mvc.factory;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.SearchCommand;
import com.kabank.mvc.enums.Action;

public class CommandFactory {
	public static Command create(String dir,String page, Action action,String search, String colum) {
		Command cmd=null;
		System.out.println("CF cmd : "+action);
		if(action==null){action=Action.MOVE;}
		switch (action) {
		case MOVE:
			cmd=new MoveCommand(dir, page, action);
			break;
		case SEARCH:case LOGIN:
			cmd=new SearchCommand(dir, page, action, search, colum);
			break;
		default:System.out.println("ConmmandFac Fail");
			break;
		}
		return cmd;
	}
}

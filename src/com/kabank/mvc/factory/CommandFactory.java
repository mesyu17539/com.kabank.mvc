package com.kabank.mvc.factory;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.SearchCommand;
import com.kabank.mvc.enums.Action;

public class CommandFactory {
	public static Command create(String dir,String page, Action action,String search, String colum) {
		Command cmd=null;
		if(action==null){action=Action.MOVE;}
		switch (action) {
		case MOVE:
			cmd=new MoveCommand(dir, page, action);
			break;
		case SEARCH:cmd=new SearchCommand(dir, page, action, search, colum);
		default:System.out.println("Conmmand Fail");
			break;
		}
		return cmd;
	}
}

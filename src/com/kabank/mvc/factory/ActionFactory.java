package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		System.out.println("cmd action: "+x);
		if(x==null){x="move";}
		switch (x) {
		case "move":
			action=Action.MOVE;break;
		case "login":
			action=Action.LOGIN;break;
		default:
			action=Action.MOVE;
			break;
		}
		System.out.println("Action 값 입력 : "+action.toString());
		return action;
	}
}

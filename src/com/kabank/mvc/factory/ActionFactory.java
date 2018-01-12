package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		System.out.println("cmd action: "+x);
		Action action = null;
		if(x==null){x="move";}
		switch (x) {
		case "move":
			action=Action.MOVE;break;
		case "login":
			action=Action.LOGIN;break;
		default:break;
		}
		System.out.println("Action 값 입력 : "+action);
		return action;
	}
}

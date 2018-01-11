package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		if(x==null){x="move";}
		switch (x) {
		case "move":
			action=Action.MOVE;break;default:break;}
		return action;
	}
}

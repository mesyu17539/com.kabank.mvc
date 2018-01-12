package com.kabank.mvc.command;

import com.kabank.mvc.enums.Action;

public class Command implements Order{
	protected String dir, page, search,colum;
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	protected Action action;
	
	@Override
	public String execute() {
		System.out.println("command 경로 조합 : "+Action.VIEW.toString()
				+dir
				+Action.SEPARATOR
				+page
				+Action.EXTENSION);
		return Action.VIEW.toString()
				+dir
				+Action.SEPARATOR
				+page
				+Action.EXTENSION;
	}
	
	public String getColum() {
		return colum;
	}
	
	public void setColum(String colum) {
		this.colum = colum;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page=(page==null)?"login":page;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
}

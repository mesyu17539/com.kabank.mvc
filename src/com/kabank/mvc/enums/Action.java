package com.kabank.mvc.enums;

public enum Action {
	MOVE, ADD, LOGIN, JOIN, SEARCH, BITCAMP, CHANGE,
	VIEW{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "/WEB-INF/view/";
		}
	},
	EXTENSION{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ".jsp";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "/";
		}
	}
}

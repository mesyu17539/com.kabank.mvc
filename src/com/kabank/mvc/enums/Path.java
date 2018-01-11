package com.kabank.mvc.enums;

public enum Path {
	AUTH{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "auth";
		}
	},
	/*VIEW("/WEB-INF/view/"),
	SEPARATOR("/"),
	EXTENSION(".jsp"),
	DOT(".do");
	public final String value;	
	public String getValue() {
		return value;
	}*/
	VIEW{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "/WEB-INF/view/";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "/";
		}
	},
	EXTENSION{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ".jsp";
		}
	},
	DOT{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ".do";
		}
	};
}

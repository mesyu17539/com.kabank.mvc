package com.kabank.mvc.util;


import com.kabank.mvc.enums.DMLENUM;

public class MainTest {
	public static void main(String[] args) {
		for(Enums.MemberCalum c: // contantpool이 아님에도 상수풀처럼 존재한다
				Enums.MemberCalum.values()) {//values는 안만들어도 존재하고 있다
			System.out.print(c+",");
		}
/*		for(Calum c:Calum.values()) {//values는 안만들어도 존재하고 있다
			System.out.print(c+",");
		}
*/	
		System.out.println("SELECT id, pass, name,ssn,phone,email,profile,addr FROM MEMBER "
		+ new StringBuffer("where id='' AND pass =''").insert(23, "페스워드").insert(10, "아이디"));
		System.out.println();
		StringBuffer buff=new StringBuffer(DMLENUM.SELECT.toString());
		System.out.println("기본 버프 : "+buff);
		buff.insert(6, "Member");
		System.out.println("추가 버프 : "+MemberEnum.PROPERTIES.toString());
		
	}
}

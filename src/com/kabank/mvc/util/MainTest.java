package com.kabank.mvc.util;

public class MainTest {
	public static void main(String[] args) {
		for(Enums.MemberCalum c: // contantpool이 아님에도 상수풀처럼 존재한다
				Enums.MemberCalum.values()) {//values는 안만들어도 존재하고 있다
			System.out.print(c+",");
		}
/*		for(Calum c:Calum.values()) {//values는 안만들어도 존재하고 있다
			System.out.print(c+",");
		}
*/	}
}

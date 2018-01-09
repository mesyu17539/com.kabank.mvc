package com.kabank.mvc.util;

public class ThreadTest {
	public static void main(String[] args) {
		Atm atm=new Atm();
		Runnable hong=new User(atm, "홍길동");
		Runnable kim=new User(atm, "김유선");
		Runnable lee=new User(atm, "이순신");
		Thread thr1=new Thread(hong);
		thr1.start();
		Thread thr2=new Thread(kim);
		thr2.start();
		Thread thr3=new Thread(lee);
		thr3.start();
	}
}
class Atm{
	public synchronized void inchul(String name) {//blocked 처리
		System.out.println(name+"님이 인출 요청함");
		for(int i=0;i<=1000000;i++) {
			if(i==10000) {
				System.out.println(name+"님이 돈을 인출함");
			}
		}
		System.out.println("돈 나감");
	}
}
class User implements Runnable{
	Atm atm;
	String name;
	public User(Atm atm,String name) {
		super();
		this.atm=atm;
		this.name=name;
	}
	@Override
	public void run() {
		atm.inchul(name);
	}
	
}
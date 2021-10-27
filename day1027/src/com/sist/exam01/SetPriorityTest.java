package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Person kim = new Person("김유신");
			Person hong = new Person("홍길동");
			Person lee = new Person("이순신");
			
			kim.start();
			hong.start();
			lee.start();
			
			
			try {
				kim.join();
				hong.join();
				lee.join();
			}catch(Exception e) {
				
			}
			System.out.println("kim의 우선순위" +kim.getPriority());
			System.out.println("hong의 우선순위" +hong.getPriority());
			System.out.println("lee의 우선순위" +lee.getPriority());
			
	}

}

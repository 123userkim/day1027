package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Person kim = new Person("������");
			Person hong = new Person("ȫ�浿");
			Person lee = new Person("�̼���");
			
			kim.start();
			hong.start();
			lee.start();
			
			
			try {
				kim.join();
				hong.join();
				lee.join();
			}catch(Exception e) {
				
			}
			System.out.println("kim�� �켱����" +kim.getPriority());
			System.out.println("hong�� �켱����" +hong.getPriority());
			System.out.println("lee�� �켱����" +lee.getPriority());
			
	}

}

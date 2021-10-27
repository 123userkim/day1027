package com.sist.product2;

import java.util.Random;

public class Product {
	
	//����Ǵ� ��ǰ�� ������ ������� ����
	int number;  //�����ڴ� ������ ������ ��� ����
	
	
	//��ǰ�� ���� �����Ͽ�����, �Һ��ߴ��� �Ǻ��ϱ� ���� ����
	//�����ڰ� ���ο� ��ǰ�� �����ϸ�, true
	//��ǰ �Һ�->false
	public boolean isNew=false;
	
	
	//�����ڰ� ����� ���ο� ��ǰ�� �����ϴ� �޼ҵ�
	//������ ��Ǫ�� �����ϰ��ִ� ���ȿ� �Һ��ڰ� ������ �� ������ �Ӱ迵������ ����
	public synchronized void makeNumber() {
		//���ο� ��ǰ(����)�� ������ �����
		Random r= new Random();
		number =r.nextInt(100); //0���� 100������ ������ ���� number�� ����
		System.out.println("�����ڰ� ���ο� ��ǰ ������ ==>"+ number);	
	}
	
	
	//�Һ��ڰ� ����� �Һ��� �żҵ� ����
	public synchronized int getNumber() {		
		System.out.println("�Һ��ڰ� ��ǰ �Һ���==>"+number); //�Һ��ڰ� ��ǰ�� �Һ���	
		return number;
	}
	

}

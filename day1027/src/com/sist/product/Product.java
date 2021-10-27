package com.sist.product;

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
		
		//���ο���ǰ�� �����ϱ� ���� �Һ� �Ͼ�x���� ���
		while(isNew==true) {		
			//�Һ��ڰ� ��ǰ�� �Һ��ϰ�, isNew�� false
			//notify�� �����ָ� �ݺ��� Ż��
			try{
				wait();
			}catch(Exception e) {
				
			}			
		}
		
		//���ο� ��ǰ(����)�� ������ �����
		Random r= new Random();
		number =r.nextInt(100); //0���� 100������ ������ ���� number�� ����
		System.out.println("�����ڰ� ���ο� ��ǰ ������ ==>"+ number);
		isNew = true;			//���ο� ��ǰ�� �����ߴ�
		notify(); 				//������� ������(�Һ���) �����
	}
	
	
	//�Һ��ڰ� ����� �Һ��� �żҵ� ����
	public synchronized int getNumber() {
		//�����ڰ� ���ο� ��ǰ�� ������ ������ ������ : ���ο� ��ǰ ����x 
		//�����ڰ� ���ο� ��ǰ ���� ->isNew�� true->notify�� �����ָ� Ż��
		while(isNew == false) {
			try{
				wait();
			}catch(Exception e) {
				
			}
		}
		System.out.println("�Һ��ڰ� ��ǰ �Һ���==>"+number); //�Һ��ڰ� ��ǰ�� �Һ���
		isNew = false; //�Һ��ڰ� ��ǰ�� �Һ����� =>false
		notify();//������� �����ڸ� ������
		return number;
	}
	

}

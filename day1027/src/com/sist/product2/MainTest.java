package com.sist.product2;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ǰ ��ü�� ����
		Product product= new Product();
		
		//������ ������ ��ü ���� : �����ÿ� product��������
		Producer producer= new Producer(product);
		
		//�Һ��� ������ ��ü�� ����
		Consumer consumer= new Consumer(product);
		
		//�����ڿ� �Һ��ڸ� ������
		producer.start();
		consumer.start();
		
		

	}

}

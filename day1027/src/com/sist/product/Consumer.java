package com.sist.product;


//�Һ��ڸ� ���� Ŭ������ ������
public class Consumer extends Thread{
	
	//�����ڰ� ���� �ִ� product�� ������. �����ڿ��� �� -> ��ǰ�� ���� Ŭ������ ��������� ����
	private Product product;
	
	//�Һ��� ��ü�����ÿ� ��ǰ ��ü�� �Ű������� ���޹޾� ��������� ����
	public Consumer (Product product) {
		this.product = product;
	}
	
	//�����尡 �ؾ��� ���� run�� �������̵��Ͽ� �� ��
	public void run() {
		//�ݺ������Ͽ� 10���� ��ǰ�� ����ϵ��� ��
		for(int i=1; i<=10;i++) {
			product.getNumber();
			try {
				Thread.sleep(300);
			}catch(Exception e) {
				
			}
		}
	}
	
}

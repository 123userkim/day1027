package com.sist.product;

//�����ڸ� ���� Ŭ������ ����
public class Producer extends Thread{
	private Product product;  //��ǰ�� ���� Ŭ������ ��������� ������
	
	//������ ��ü �����ÿ� ��ǰ��ü�� �Ű������� ���޹޾�, ������� "��ǰ"�� �ʱ�ȭ��
	public Producer(Product product) {
		this.product = product;
	}
	
	//������ Ŭ������ ��� ���ο� ��ǰ�� �����ϱ� ���� �޼ҵ带 ȣ���Ű ����
	//�����尡 �ؾ��ϴ� ���� run�޼ҵ带 �������̵�
	public void run() {
		
		//10���� ���ο� ��ǰ�� �����ϵ��� 
		for(int i=1 ;i<=10;i++) {
			product.makeNumber();	
			//���ο� ��ǰ�� �����ϱ� ���� ��ǰ���� �޼ҵ� ȣ��
			try {
				Thread.sleep(200);
			}catch(Exception e) {
				
			}
			
		}
		
	}
}

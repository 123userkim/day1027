package com.sist.exam02;
//�����ڸ� ���� Ŭ������ �����带 ��ӹ޾Ƽ� ����
public class Donor extends Thread{	
	private Account tvArs; //�����ڵ��� ��ݾ��� �����ϱ� ���� ��������� ����
	private String name;
	
	//������ ��ü �����ÿ� �̸��� ������ ��ݾװ�ü�� �Ű������� ���޹޾� ��������� ����
	public Donor(Account tvArs,String name) {
		this.tvArs = tvArs;
		this.name = name;
	}
	 
	//�����尡 �ؾ��� ���� run �������̵�
	public void run() {
		for(int i=1; ;i++) {
			
			//�Ա��ϱ� ���� 10���� �Ǿ����� : �Ѿ����� �ݺ����� Ż��
			if(tvArs.getBalance()>=100000) {
				break;
			}
				tvArs.deposit(1000);
				System.out.println(name +"��(��)" + i +"��° �Ա��Ͽ����ϴ�.");
			try {
				Thread.sleep(200); //0.2�� ���
			}catch(Exception e) {
				
			}
		}
	}

}

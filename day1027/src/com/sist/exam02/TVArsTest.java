package com.sist.exam02;

public class TVArsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��ݾ� ���¸� ���� ��ü�� ����
		Account account = new Account();
		
		//������ 5���� ������ ��ü�� ����
		Donor d1= new Donor(account, "�����");
		Donor d2= new Donor(account, "��þ�");
		Donor d3= new Donor(account, "�ӻ���");
		Donor d4= new Donor(account, "������");
		Donor d5= new Donor(account, "���ڿ�");
		
		//5���� �����ڵ��� �����ϰ� �Ա��ϵ��� �����带 ����
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		try {   //�������� �۾��� �Ϸ�� ������ ����Ű�� ���� : join�޼ҵ带 ȣ��
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch(Exception e) {   //join�� ���ܸ� ����
			
		}
		
		System.out.println("��ü ��ݾ� :"+account.getBalance());
	
		
	}

}

package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�̸�, ���̸� ���Ϸ� �����ϱ�
		
		//���ڴ����� ����� ���� Writer�� �ļ��߿� ���Ϸ� ����� ���� FileWriter ����
		try {
			FileWriter fw= new FileWriter("c:/MyData/hello.txt");
			fw.write("���� �̸��� ȫ�浿�̰�\n");
			fw.write("���̴� 20��");
			fw.close();
			//������ ����� ������, ������ �ݾ���� �� 
			//->������ �ȳ�����, �ٸ� �������� ���� ��� ����;
			System.out.println("���� ���� ����!");
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
	}

}

package com.sist.inputoutput;


import java.io.File;
import java.io.FileReader;

public class ReadFile {
	public static void main(String[] args) {
		//�Ʊ� ������ ���� �о���̱� c:/Mydata/hello.txt ȭ�� ����ϱ�				
		///�� ���ھ� �б�
		
		try {
			FileReader reader = new FileReader("c:/Mydata/hello.txt");
			int ch;   //�� ���� ����
			while((ch = reader.read()) != -1){    //���� �� ������ -1��ȯ
				System.out.print((char)ch);
			}
			reader.close();			
		}catch(Exception e) {
			System.out.println("���ܹ߻� :"+e.getMessage());
		}
	}
}


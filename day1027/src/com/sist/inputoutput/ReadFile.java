package com.sist.inputoutput;


import java.io.File;
import java.io.FileReader;

public class ReadFile {
	public static void main(String[] args) {
		//아까 생성한 파일 읽어들이기 c:/Mydata/hello.txt 화면 출력하기				
		///한 글자씩 읽기
		
		try {
			FileReader reader = new FileReader("c:/Mydata/hello.txt");
			int ch;   //한 글자 설정
			while((ch = reader.read()) != -1){    //읽을 게 없으면 -1반환
				System.out.print((char)ch);
			}
			reader.close();			
		}catch(Exception e) {
			System.out.println("예외발생 :"+e.getMessage());
		}
	}
}


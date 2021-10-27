package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//이름, 나이를 파일로 생성하기
		
		//문자단위의 출력을 위한 Writer의 후손중에 파일로 출력을 위한 FileWriter 생성
		try {
			FileWriter fw= new FileWriter("c:/MyData/hello.txt");
			fw.write("나의 이름은 홍길동이고\n");
			fw.write("나이는 20살");
			fw.close();
			//파일의 사용이 끝나면, 파일을 닫아줘야 함 
			//->에러는 안나지만, 다른 곳에서도 사용될 경우 난감;
			System.out.println("파일 생성 성공!");
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
	}

}

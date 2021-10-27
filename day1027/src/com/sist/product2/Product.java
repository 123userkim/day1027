package com.sist.product2;

import java.util.Random;

public class Product {
	
	//생산되는 제품을 임의의 정수라고 하자
	int number;  //생산자는 임의의 정수를 계속 만듦
	
	
	//제품을 새로 생산하였는지, 소비했는지 판별하기 위한 변수
	//생산자가 새로운 제품을 생산하면, true
	//제품 소비->false
	public boolean isNew=false;
	
	
	//생산자가 사용할 새로운 제품을 생성하는 메소드
	//생산자 제푸을 생산하고있는 동안엔 소비자가 접근할 수 없도록 임계영역으로 설정
	public synchronized void makeNumber() {
		//새로운 제품(정수)는 난수로 만들기
		Random r= new Random();
		number =r.nextInt(100); //0에서 100사이의 난수를 만들어서 number에 넣음
		System.out.println("생산자가 새로운 제품 생성함 ==>"+ number);	
	}
	
	
	//소비자가 사용할 소비할 매소드 정의
	public synchronized int getNumber() {		
		System.out.println("소비자가 제품 소비함==>"+number); //소비자가 제품을 소비함	
		return number;
	}
	

}

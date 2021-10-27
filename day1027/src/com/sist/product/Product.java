package com.sist.product;

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
		
		//새로운제품을 생산하기 전에 소비가 일어x동안 대기
		while(isNew==true) {		
			//소비자가 제품을 소비하고, isNew에 false
			//notify를 깨워주면 반복문 탈출
			try{
				wait();
			}catch(Exception e) {
				
			}			
		}
		
		//새로운 제품(정수)는 난수로 만들기
		Random r= new Random();
		number =r.nextInt(100); //0에서 100사이의 난수를 만들어서 number에 넣음
		System.out.println("생산자가 새로운 제품 생성함 ==>"+ number);
		isNew = true;			//새로운 제품을 생산했다
		notify(); 				//대기중인 쓰레드(소비자) 깨우기
	}
	
	
	//소비자가 사용할 소비할 매소드 정의
	public synchronized int getNumber() {
		//생산자가 새로운 제품을 생산할 때까지 대기상태 : 새로운 제품 생산x 
		//생산자가 새로운 재품 생산 ->isNew에 true->notify로 깨워주면 탈출
		while(isNew == false) {
			try{
				wait();
			}catch(Exception e) {
				
			}
		}
		System.out.println("소비자가 제품 소비함==>"+number); //소비자가 제품을 소비함
		isNew = false; //소비자가 제품을 소비했음 =>false
		notify();//대기중인 생산자를 깨워줌
		return number;
	}
	

}

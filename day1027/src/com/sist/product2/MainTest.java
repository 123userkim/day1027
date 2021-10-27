package com.sist.product2;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//제품 객체를 생성
		Product product= new Product();
		
		//생산자 쓰레드 객체 생성 : 생성시에 product전달해줌
		Producer producer= new Producer(product);
		
		//소비자 쓰레드 객체를 생성
		Consumer consumer= new Consumer(product);
		
		//생산자와 소비자를 가동함
		producer.start();
		consumer.start();
		
		

	}

}

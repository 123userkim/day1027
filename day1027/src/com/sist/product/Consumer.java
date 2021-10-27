package com.sist.product;


//소비자를 위한 클래스를 만들어보기
public class Consumer extends Thread{
	
	//생산자가 갖고 있는 product과 동일함. 공유자원인 것 -> 제품을 위한 클래스를 멤버변수로 선언
	private Product product;
	
	//소비자 객체생성시에 제품 객체를 매개변수로 전달받아 멤버변수에 대입
	public Consumer (Product product) {
		this.product = product;
	}
	
	//쓰레드가 해야할 일을 run을 오버라이딩하여 써 줌
	public void run() {
		//반복실행하여 10개의 제품을 사용하도록 함
		for(int i=1; i<=10;i++) {
			product.getNumber();
			try {
				Thread.sleep(300);
			}catch(Exception e) {
				
			}
		}
	}
	
}

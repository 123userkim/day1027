package com.sist.exam02;
//성금자를 위한 클래스를 쓰레드를 상속받아서 구현
public class Donor extends Thread{	
	private Account tvArs; //성금자들이 모금액을 공유하기 위해 멤버변수로 설정
	private String name;
	
	//성금자 객체 생성시에 이름과 공유할 모금액객체를 매개변수로 전달받아 멤버변수에 설정
	public Donor(Account tvArs,String name) {
		this.tvArs = tvArs;
		this.name = name;
	}
	 
	//쓰레드가 해야할 일을 run 오버라이딩
	public void run() {
		for(int i=1; ;i++) {
			
			//입금하기 전에 10만원 되었는지 : 넘었으면 반복문을 탈출
			if(tvArs.getBalance()>=100000) {
				break;
			}
				tvArs.deposit(1000);
				System.out.println(name +"이(가)" + i +"번째 입금하였습니다.");
			try {
				Thread.sleep(200); //0.2초 대기
			}catch(Exception e) {
				
			}
		}
	}

}

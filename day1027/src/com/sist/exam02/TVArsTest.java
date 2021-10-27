package com.sist.exam02;

public class TVArsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//모금액 계좌를 위한 객체를 생성
		Account account = new Account();
		
		//성금자 5명의 성금자 객체를 생성
		Donor d1= new Donor(account, "김수연");
		Donor d2= new Donor(account, "김시아");
		Donor d3= new Donor(account, "임상진");
		Donor d4= new Donor(account, "윤태인");
		Donor d5= new Donor(account, "정자영");
		
		//5명의 성금자들이 공평하게 입금하도록 쓰레드를 가동
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		try {   //쓰레드의 작업이 완료될 때까지 대기시키기 위함 : join메소드를 호출
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch(Exception e) {   //join도 예외를 가짐
			
		}
		
		System.out.println("전체 모금액 :"+account.getBalance());
	
		
	}

}

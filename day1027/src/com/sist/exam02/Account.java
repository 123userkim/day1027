package com.sist.exam02;


public class Account {
	//전체 모금액
	private int balance;
	
	
	//입금을 하는 메소드
	 public synchronized void deposit(int amount) {
		balance += amount;	
	}
	 
	 //현재의 모금액을 반환하는 메소드
	 public int getBalance() {
		 return balance;
	 }
}

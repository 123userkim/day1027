package com.sist.game;

import javax.swing.JFrame;

// GUI(Graphic User Interface)프로그래밍에서 
// "창"을 만들기 위해서는 JFrame을 상속받아요.
public class MyFrame extends JFrame {
	
	//생성자에서
	public MyFrame() {
		setTitle("My Game"); // 창의 제목을 설정합니다.
		add(new MyPanel());	 // "적","미사일","우주선"을 포함하고 있는 "패널"을 생성하여 "프레임"에 담아요
		setSize(500, 500);	 // 프레임의 크기를 설정합니다.
		setVisible(true);	 // 프레임을 화면에 보이도록 설정합니다.
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();		//프레임을 생성합니다.
	}
}

package com.sist.game;

import javax.swing.JFrame;

// GUI(Graphic User Interface)���α׷��ֿ��� 
// "â"�� ����� ���ؼ��� JFrame�� ��ӹ޾ƿ�.
public class MyFrame extends JFrame {
	
	//�����ڿ���
	public MyFrame() {
		setTitle("My Game"); // â�� ������ �����մϴ�.
		add(new MyPanel());	 // "��","�̻���","���ּ�"�� �����ϰ� �ִ� "�г�"�� �����Ͽ� "������"�� ��ƿ�
		setSize(500, 500);	 // �������� ũ�⸦ �����մϴ�.
		setVisible(true);	 // �������� ȭ�鿡 ���̵��� �����մϴ�.
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();		//�������� �����մϴ�.
	}
}

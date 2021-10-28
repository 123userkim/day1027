package com.sist.game;

import java.awt.event.KeyEvent;

//�츮��(���ּ�)�� ���� Ŭ�����Դϴ�.
public class SpaceShip extends GraphicObject {
	
	//�����ÿ� �̹������ϸ��� �Ű������� ���޹޾� �θ��� �����ڿ� �����մϴ�.
	public SpaceShip(String name) {
		super(name);
		
		//��ó�� ���ּ��� ��ġ x,y�� �����մϴ�.
		x = 150;
		y = 350;
	}
	
	//"���ּ�"�� ������ ����Ű�� ���� ���ּ��� ��ġ�� �̵����ѿ�
	//�Ű������� ���޹��� KeyEvent event�� ���ؼ� �Ű�� ���������� �� �� �ֿ�.
	public void keyPressed(KeyEvent event) { 
		
		//���ʹ���Ű�� ��������
		if(event.getKeyCode() ==  KeyEvent.VK_LEFT) {
			//x��ǥ�� �������� �̵���Ű�� ���Ͽ� 10�� �����ؿ�.
			x -= 10;
		}
		
		//�����ʹ���Ű�� ��������
		if(event.getKeyCode() ==  KeyEvent.VK_RIGHT) {
			//x��ǥ�� ���������� �̵���Ű�� ���Ͽ� 10�� �����ؿ�.
			x += 10;
		}
		//���ʹ���Ű�� ��������
		if(event.getKeyCode() ==  KeyEvent.VK_UP) {
			//y��ǥ�� �������� �̵���Ű�� ���Ͽ� 10�� �����ؿ�.
			y -= 10;
		}
		//�Ʒ��ʹ���Ű�� ��������
		if(event.getKeyCode() ==  KeyEvent.VK_DOWN) {
			//y��ǥ�� �Ʒ������� �̵���Ű�� ���Ͽ� 10�� �����ؿ�.
			y += 10;
		}
	}
}









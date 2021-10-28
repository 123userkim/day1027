package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	
	// "��"�� x������ �����̴� ������ ���� ����
	// ��ó������ ������ ������ �������� �����̵��� �ϱ� ���Ͽ� ������ �����մϴ�.
	//int dx = -10;
	//int dy = 10;
	
	//���� �̵���θ� ������ ������
	int dx;
	int dy;
	
	//�����ÿ� "��"���� ǥ���� �׷��� �����̸��� �Ű������� ���޹޾� �θ�Ŭ������ �����ڿ��� �����մϴ�.
	public Enermy(String name) {
		super(name);
		
		//��ó���� ���α׷� �����Ͽ������� "��"�� ��ġ�� ������ ��ܿ� ��ġ��Ű�� ���Ͽ� 
		//x=500, y=0���� �����մϴ�.
		//x = 500;
		//y = 0;
		
		Random r = new Random();
		//��ó���� ���� ��ġ�� ������ �����ؿ�
		x = r.nextInt(500);
		y = r.nextInt(300);
		
		//���� �̵���ΰ��� �����ÿ� ������ ������.
		//�̵��ϴ� �ּҰ�: 10
		//�̵��ϴ� �ִ밪: 100
		// � ������ ���� 91���� ���� ������ 10�� ���ϸ� �ǰڽ��ϴ�.
		
		
		
		dx = r.nextInt() % 30;
		dy = r.nextInt() % 30;
		
		if(dx >= 0) {
			dx += 10;
		}else {
			dx -= 10;
		}
		
		if(dy >= 0) {
			dy += 10;
		}else {
			dy-=10;
		}
		
		
		System.out.println("dx:"+dx);
		System.out.println("dy:"+dy);
	}
	
	
	public void update() {
		
		// x��ǥ�� dx��ŭ �����ŵ�ϴ�.
		x += dx;
		y += dy;
		
		//x������ ���� ���������� ��ȣ�� �ٲ��ݴϴ�.
		if(x < 0 || x >500) {
			dx = dx * -1;
		}
		
		//y������ ���� ���������� �θ� �ٲ��ݴϴ�.
		if(y <0 || y >= 300) {
			dy = dy * -1;
		}
		
		/*
		//���� ���ʳ��� �����ϸ� ���������� �̵���Ű�� ���Ͽ� dx�� ����� ����ϴ�.
		if(x < 0) {
			dx = 10;
		}
		
		//���� ������ ���� �����ϸ� �ٽ� �������� �̵���Ű�� ���Ͽ� dx�� ������ ����ϴ�.
		if( x > 500) {
			dx = -10;
		}
		
		if(y >=400) {
			dy = -10;
		}
		
		if(y < 0 ) {
			dy = 10;
		}*/
		
	}
	
	
	//"��"(����)�� "�̻���"�� �¾Ҵ��� �Ǻ��ϴ� �޼ҵ� ����
	//�̸޼ҵ尡 ���� �Ϸ��� �Ű������� ������ �ʿ��ұ��?
	
	public void crush( Missile missile ){
		
		//"��"�� "�̻���"�� �¾Ҵ��� �Ǻ�
		if(missile.x >= x && missile.x <= x + 40   && missile.y >= y && missile.y <= y +40) {
			//System.out.println("���� �¾Ҿ��!");
			
			//�Ҹ����� ��ü�� �����մϴ�.
			File file = new File("EXPLODE.WAV");
			try {
				//����� ������ �о���� ���� �غ� �մϴ�.
				Clip clip = AudioSystem.getClip();
				
				//����� ������ �о�ɴϴ�.
				clip.open( AudioSystem.getAudioInputStream(file));
				
				//����� ������ ����մϴ�.
				clip.start();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			y = -1000;
		}
	}
}













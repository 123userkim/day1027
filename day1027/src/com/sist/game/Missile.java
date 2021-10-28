package com.sist.game;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Missile extends GraphicObject {
	
	//�̻����� �߻� �Ǿ����� �Ǻ��ϱ� ���� ����
	boolean launched = false;
	
	//�����ÿ� �̹��������̸��� �Ű������� ���޹޾� 
	public Missile(String name) {
		
		//�θ��� �����ڿ��� �����մϴ�.
		super(name);
		
		//��ó�� �̻����� ��ġ�� �Ⱥ��̰� �ϱ� ���Ͽ� y��ǥ�� ������ �Ⱥ��̴� �������� �����մϴ�.
		y = -200;
	}
	
	public void update() {
		//���࿡ �̻����� �߻� �Ǿ��ٸ� y��ǥ�� 1�� �����մϴ�.
		if(launched) {
			y -= 10;
		}
		
		//�̻����� y��ǥ�� ȭ���� ���� �Ⱥ��̴� �����̸� launched�� false�� �����մϴ�
		if(y < -100) {
			launched = false;
		}		
	}
	
	
	// Ű���尡 �������� 
	// ���� ���ּ��� �ִ� ��ġ x,y��ǥ���� ���� ����Ͽ� 
	// �̻����� �߻��Ű�� ���Ͽ� keyPressed�޼ҵ带 �������̵� �մϴ�.
	// ���� �Ű������� ���޹޴� KeyEvent event�� ���ؼ� � key�� ���������� �˼� �־��
	// ��, �Ű����� x,y�� ���ּ��� ��ġ x,y�� ���޹޾ƿ�.
	public void keyPressed(KeyEvent event, int x, int y) {
		
		//������ Ű�� �����̽��� �̶��
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			
			launched = true; //�̻����� �߻��Ű�� ���Ͽ� launched�� true�� �����մϴ�.
			
			//�̻����� x,y��ǥ�� ���ּ��� x,y�� �����մϴ�.
			this.x = x;
			this.y = y;
			
			//�̻����� �߻�ɶ��� �Ҹ��� ���� �սô�.
			
			//�Ҹ����� ��ü�� �����մϴ�.
			File file = new File("LASER.WAV");
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
		}
	}
}













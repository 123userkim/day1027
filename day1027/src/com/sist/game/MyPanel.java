package com.sist.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

// "��", "�̻���", "���ּ�"�� ���ÿ�(�Ѳ�����) ������ �ִ� "�г�"Ŭ������ ������
// ��, "�г�"�� Ű���尡 �������� �̺�Ʈ�� ó���ϱ� ���Ͽ� KeyListener�� �����մϴ�.
public class MyPanel extends JPanel implements KeyListener {
	
	//"��","�̻���","���ּ�"�� "�г�"�� �ɹ������� �����մϴ�.
	//Enermy enermy;
	
	//�������� "��"�� ����� ���Ͽ� ArrayList�� ������
	ArrayList<Enermy> enermyList ;

	Missile missile;
	SpaceShip spaceship;
	
	//�����ڿ� ��, �г��� �����ʰ� ���ÿ� �����Ͽ�
	public MyPanel() {
		addKeyListener(this);  		// �г��� Ű���� �̺�Ʈ�� ����մϴ�.
		requestFocus();				// �г��� Ű���� ��û�� �����մϴ�.		A
		setFocusable(true);			// �гο� ��Ŀ���� �����մϴ�.			B
		// �г��� ȭ�鱸������߿� �������� Ű����� ���� �Է¹޾� ���̴� �뵵�� �ƴϱ� ������ 
		// Ű����� ���� �Է��� �޾Ƶ��̰� �Ϸ��� "�г�"�� �ϴ��� "��Ŀ��"�� �����ؾ� �մϴ�.
		
		//�������� "��"�� ��� ���� ArrayList��ü�� �����մϴ�.
		enermyList = new ArrayList<Enermy>();
		
		//"��"�� 5�� ������(���� ����Ʈ�� ��ƿ�)
		enermyList.add(new Enermy("enemy.png"));
		enermyList.add(new Enermy("enemy.png"));
		enermyList.add(new Enermy("enemy.png"));
		enermyList.add(new Enermy("enemy.png"));
		enermyList.add(new Enermy("enemy.png"));
		
		
		//enermy = new Enermy("enemy.png");			//�̹������ϸ��� ���� "��" ��ü�� �����մϴ�.
		spaceship = new SpaceShip("player.png");    //�̹������ϸ��� ���� "���ּ�" ��ü�� �����մϴ�.
		missile = new Missile("misile.png");		//�̹������ϸ��� ���� "�̻���" ��ü�� �����մϴ�.
		
		
		//"�г�"�� ��������� "��","�̻���","���ּ�"�� ���� ����������(���ÿ�,�����ϰ�) �����̵��� �ϱ� ���Ͽ� 
		//"��Ƽ������"�� �����ؿ�
		// "��","�̻���","���ּ�"�� ���ÿ�(�����ϰ�) �����̰� �ϴ� ����� �ٸ� �������� ������ ���� 
		// ���� �̰� "�г�"������ �ʿ��ؿ�
		// �̷����� Ŭ������ Ŭ�����ȿ� ���� �� �־��
		// �̰��� inner class��� �մϴ�.
		
		class MyThread extends Thread{			// ThreadŬ������ ��ӹ޾� "��Ƽ������"�� �����մϴ�.
			public void run() {					// run�� �������̵��Ͽ� ���ÿ� �����ų ��ɾ�(��)�� ���ݴϴ�.
				while(true) {					// ��� �ݺ��Ͽ� "��","�̻���","���ּ�"�� �����̵��� �ϱ� ���Ͽ� while(true)�� �̿��մϴ�
					
					missile.update();
					
					//����Ʈ�� ��� "��"�� ����ŭ �ݺ��Ͽ� "��"�� ��ġ�� ������ѿ�.
					for(Enermy enermy :enermyList) {
						enermy.update();
						enermy.crush(missile);
					}
					
					repaint();		
					
					try {
						Thread.sleep(50);
					}catch (Exception e) {
						// TODO: handle exception
					}//end catch
				}//end while
			}//end run
		}// end MyThread 
		
		
		// "��", "�̻���", "���ּ�"�� ���� ���������� �����̵��� ����
		// ��Ƽ������ ��ü MyThread�� �����մϴ�.
		Thread t = new MyThread();
		
		//�����带 �����մϴ�.
		t.start();
	}
	
	
	
	
	
	// "��","�̻���","���ּ�"�� ����� ��ġ�� �׷����� �ٽ� �׷��ݴϴ�.
	// "�г�"�� �׷����� ǥ���ϱ� ���ؼ��� paintComponent�� �������̵� �� �ݴϴ�.
	// �̶� �Ű������� ���޹��� Graphics�� �׷����� ǥ���ϱ� ���� �پ��� �޼ҵ���� �־��@
	@Override
	protected void paintComponent(Graphics g) {  
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//�������� "��"�� ��� �ִ� ����Ʈ�� ����ŭ �ݺ��Ͽ� "��"�� �ٽ� �׷� �ݴϴ�.
		for(Enermy enermy:enermyList) {
			enermy.draw(g);	
		}	
		spaceship.draw(g);	
		missile.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// "�г�"���� Ű���尡 ��������
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		spaceship.keyPressed(e); 		// ������ Ű�����̺�Ʈ�� ������ "���ּ�"���� �����մϴ�.
		
		missile.keyPressed(e, spaceship.x, spaceship.y);
		//������ Ű�����̺�Ʈ�� ������ ���ּ��� ��ġ�� "�̻���"���� �����մϴ�.
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

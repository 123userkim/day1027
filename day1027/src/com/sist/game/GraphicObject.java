package com.sist.game;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

// ��, ���ּ�, �̻��� Ŭ�������� ���������� �������� �Ӽ��� ������ �̾� "�Ϲ�ȭ"�մϴ�.
public class GraphicObject {
	
	BufferedImage img = null;//ȭ�鿡 �׸��� ǥ���ϱ� ���� ��ü	
	int x=0, y=0;//�׸��� ��µ� ��ġ
	
	//�����ÿ� �׷����̹��� ������ �Ű������� ���޹޾ƿ�
	public GraphicObject(String name) {
		
		//�Ű������� ���޹��� ���ϸ����� BufferdImage��ü�� �����մϴ�.
		try {
			img = ImageIO.read(new File(name));
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
	
	//�׷����̹����� ��ġ�� �����ϱ� ���� �޼ҵ��̸� �ڽ�Ŭ�������� �ڽſ��� �µ��� ������ �� ���Դϴ�.
	public void update() {}
	
	//����� ��ġ�� �̹����� �ٽ� �׸��� ���� �޼ҵ��Դϴ�.
	public void draw(Graphics g) {
		g.drawImage(img,x,y,null);// x,y��ǥ�� �̹����� �׷� �ݴϴ�.
	}
	
	//��, �̻���, ���ּ� ������ ��ü���� keyPressed�� �ڽſ��� �µ��� ������� �մϴ�.
	public void keyPressed(KeyEvent event) {}
}













package com.sist.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

// "적", "미사일", "우주선"을 동시에(한꺼번에) 담을수 있는 "패널"클래스를 만들어요
// 또, "패널"에 키보드가 눌러지는 이벤트를 처리하기 위하여 KeyListener도 구현합니다.
public class MyPanel extends JPanel implements KeyListener {
	
	//"적","미사일","우주선"을 "패널"의 맴버변수로 선언합니다.
	//Enermy enermy;
	
	//여러개의 "적"을 만들기 위하여 ArrayList를 만들어요
	ArrayList<Enermy> enermyList ;

	Missile missile;
	SpaceShip spaceship;
	
	//생성자에 즉, 패널이 생성됨고 동시에 동작하여
	public MyPanel() {
		addKeyListener(this);  		// 패널의 키보드 이벤트를 등록합니다.
		requestFocus();				// 패널의 키보드 요청을 설정합니다.		A
		setFocusable(true);			// 패널에 포커스를 설정합니다.			B
		// 패널은 화면구성요소중에 원래부터 키보드로 부터 입력받아 들이는 용도가 아니기 때문에 
		// 키보드로 부터 입력을 받아들이게 하려면 "패널"에 일단은 "포커스"를 설정해야 합니다.
		
		//여러개의 "적"을 담기 위한 ArrayList객체를 생성합니다.
		enermyList = new ArrayList<Enermy>();
		
		//"적"을 5개 만들어요(만들어서 리스트에 담아요)
		enermyList.add(new Enermy("enemy.png"));
		enermyList.add(new Enermy("enemy.png"));
		enermyList.add(new Enermy("enemy.png"));
		enermyList.add(new Enermy("enemy.png"));
		enermyList.add(new Enermy("enemy.png"));
		
		
		//enermy = new Enermy("enemy.png");			//이미지파일명을 갖고 "적" 객체를 생성합니다.
		spaceship = new SpaceShip("player.png");    //이미지파일명을 갖고 "우주선" 객체를 생성합니다.
		missile = new Missile("misile.png");		//이미지파일명을 갖고 "미사일" 객체를 생성합니다.
		
		
		//"패널"의 구성요소인 "적","미사일","우주선"이 서로 독립적으로(동시에,공평하게) 움직이도록 하기 위하여 
		//"멀티쓰레드"로 구현해요
		// "적","미사일","우주선"이 동시에(공평하게) 움직이게 하는 기능은 다른 곳에서는 쓸일이 없고 
		// 여기 이곳 "패널"에서만 필요해요
		// 이럴때에 클래스를 클래스안에 만들 수 있어요
		// 이것을 inner class라고 합니다.
		
		class MyThread extends Thread{			// Thread클래스를 상속받아 "멀티쓰레드"를 구현합니다.
			public void run() {					// run을 오버라이딩하여 동시에 실행시킬 명령어(들)을 써줍니다.
				while(true) {					// 계속 반복하여 "적","미사일","우주선"이 움직이도록 하기 위하여 while(true)를 이용합니다
					
					missile.update();
					
					//리스트에 담긴 "적"의 수만큼 반복하여 "적"의 위치를 변경시켜요.
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
		
		
		// "적", "미사일", "우주선"이 서로 독립적으로 움직이도록 만든
		// 멀티쓰레드 객체 MyThread를 생성합니다.
		Thread t = new MyThread();
		
		//쓰레드를 가동합니다.
		t.start();
	}
	
	
	
	
	
	// "적","미사일","우주선"의 변경된 위치에 그래픽을 다시 그려줍니다.
	// "패널"에 그래픽을 표현하기 위해서는 paintComponent를 오버라이딩 해 줍니다.
	// 이때 매개변수로 전달받은 Graphics에 그래픽을 표현하기 위한 다양한 메소드들이 있어요@
	@Override
	protected void paintComponent(Graphics g) {  
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//여러개의 "적"이 담겨 있는 리스트의 수만큼 반복하여 "적"을 다시 그려 줍니다.
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

	// "패널"에서 키보드가 눌러지면
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		spaceship.keyPressed(e); 		// 눌러진 키보드이벤트의 정보를 "우주선"에게 전달합니다.
		
		missile.keyPressed(e, spaceship.x, spaceship.y);
		//눌러진 키보드이벤트의 정보와 우주선의 위치를 "미사일"에게 전달합니다.
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

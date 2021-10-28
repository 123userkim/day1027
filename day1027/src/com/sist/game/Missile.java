package com.sist.game;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Missile extends GraphicObject {
	
	//미사일이 발사 되었는지 판별하기 위한 변수
	boolean launched = false;
	
	//생성시에 이미지파일이름을 매개변수로 전달받아 
	public Missile(String name) {
		
		//부모의 생성자에게 전달합니다.
		super(name);
		
		//맨처음 미사일의 위치를 안보이게 하기 위하여 y좌표를 음수로 안보이는 영역으로 설정합니다.
		y = -200;
	}
	
	public void update() {
		//만약에 미사일이 발사 되었다면 y좌표를 1씩 감소합니다.
		if(launched) {
			y -= 10;
		}
		
		//미사일의 y좌표가 화면의 눈에 안보이는 영역이면 launched에 false를 설정합니다
		if(y < -100) {
			launched = false;
		}		
	}
	
	
	// 키보드가 눌러지면 
	// 현재 우주선이 있는 위치 x,y좌표에서 부터 출발하여 
	// 미사일을 발사시키기 위하여 keyPressed메소드를 오버라이딩 합니다.
	// 여기 매개변수로 전달받는 KeyEvent event를 통해서 어떤 key가 눌러졌는지 알수 있어요
	// 또, 매개변수 x,y는 우주선의 위치 x,y를 전달받아요.
	public void keyPressed(KeyEvent event, int x, int y) {
		
		//눌러진 키가 스페이스바 이라면
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			
			launched = true; //미사일을 발사시키기 위하여 launched에 true를 설정합니다.
			
			//미사일의 x,y좌표를 우주선의 x,y로 설정합니다.
			this.x = x;
			this.y = y;
			
			//미사일이 발사될때에 소리도 나게 합시다.
			
			//소리파일 객체를 생성합니다.
			File file = new File("LASER.WAV");
			try {
				//오디오 파일을 읽어오기 위한 준비를 합니다.
				Clip clip = AudioSystem.getClip();
				
				//오디오 파일을 읽어옵니다.
				clip.open( AudioSystem.getAudioInputStream(file));
				
				//오디오 파일을 재생합니다.
				clip.start();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}













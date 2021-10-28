package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	
	// "적"이 x축으로 움직이는 간격을 위한 변수
	// 맨처음에는 오른쪽 끝에서 왼쪽으로 움직이도록 하기 위하여 음수를 설정합니다.
	//int dx = -10;
	//int dy = 10;
	
	//적의 이동경로를 난수로 만들어요
	int dx;
	int dy;
	
	//생성시에 "적"으로 표현할 그래픽 파일이름을 매개변수로 전달받아 부모클래스의 생성자에게 전달합니다.
	public Enermy(String name) {
		super(name);
		
		//맨처음에 프로그램 실행하였을때에 "적"의 위치를 오른쪽 상단에 위치시키기 위하여 
		//x=500, y=0으로 설정합니다.
		//x = 500;
		//y = 0;
		
		Random r = new Random();
		//맨처음에 적의 위치도 난수로 설정해요
		x = r.nextInt(500);
		y = r.nextInt(300);
		
		//적의 이동경로값을 생성시에 난수로 만들어요.
		//이동하는 최소값: 10
		//이동하는 최대값: 100
		// 어떤 난수를 만들어서 91으로 나눈 나머지 10을 더하면 되겠습니다.
		
		
		
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
		
		// x좌표를 dx만큼 변경시킵니다.
		x += dx;
		y += dy;
		
		//x축으로 끝에 도달했으면 부호를 바꿔줍니다.
		if(x < 0 || x >500) {
			dx = dx * -1;
		}
		
		//y축으로 끝에 도달했으면 부모를 바꿔줍니다.
		if(y <0 || y >= 300) {
			dy = dy * -1;
		}
		
		/*
		//만약 완쪽끝에 도달하면 오른쪽으로 이동시키기 위하여 dx를 양수로 만듭니다.
		if(x < 0) {
			dx = 10;
		}
		
		//만약 오른쪽 끝에 도달하면 다시 왼쪽으로 이동시키기 위하여 dx를 음수로 만듭니다.
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
	
	
	//"적"(내가)이 "미사일"에 맞았는지 판별하는 메소드 정의
	//이메소드가 일을 하려면 매개변수가 무엇이 필요할까요?
	
	public void crush( Missile missile ){
		
		//"적"이 "미사일"에 맞았는지 판별
		if(missile.x >= x && missile.x <= x + 40   && missile.y >= y && missile.y <= y +40) {
			//System.out.println("적이 맞았어요!");
			
			//소리파일 객체를 생성합니다.
			File file = new File("EXPLODE.WAV");
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
			
			y = -1000;
		}
	}
}













package com.kopo.game;

import java.util.Random;

/***
 * Cat2 클래스
 * 두 번째 고양이 캐릭터 "춘배"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 춘배
 * - 나이: 7살
 * - 성별: 수컷
 * - 민첩성: 2
 */
public class Cat2 extends Base {
	/***
	 * Cat2의 기본 생성자
	 * 춘배의 기본 특성을 초기화합니다.
	 * super()에 '파라미터를 4개' 줌으로써, 
	 * 부모 클래스 기본생성자가 아닌 '4개의 파라미터를 받아오는 메소드' 실행
	 */
	Cat2(){
		super("춘배", 7, "수컷", 2, "쓰담쓰담 손길에 약함");
	}
	
	/***
	 * 춘배를 찾는 메소드
	 * 33% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 춘배를 발견함
	 *         false: 춘배를 발견하지 못함
	 */
	@Override
	public boolean findCat() {
		Random random = new Random();
		int randNumber = random.nextInt(3);
		if(randNumber==1) {
			System.out.println("[탐색 성공]");
			System.out.println(this.name + "을(를) 발견했습니다!!");
			return true;
		}
		System.out.println("[탐색 실패]");
		System.out.println("무심코 돌멩이를 들었지만... 벌레만 있었네요.");
		return false;
	}
	
	/***
	 * 고양이 포획하는 메소드
	 * Base 클래스의 printItem() 메소드 파라미터로 아이템(2/3/4개)과 정답 전달받음
	 * 입력 아이템에 따라 포획 결과가 결정됩니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 포획 성공
	 *         false: 포획 실패
	 */
	@Override
	public boolean catchCat() {
		printItem("고함", "조심스런 손길", 2);

		String input = Config.scanner.nextLine();

		// 문자 입력 시 오류 예외 처리
		try {
			int inputNum = Integer.parseInt(input);

			if(inputNum == answer) {
				System.out.println("[잡았다!]");
				System.out.println(this.name + "가(이) 당신의 손에 고롱고롱하며 따라옵니다.");
				this.isCatch = true;
				return true;
			} else {
				System.out.println("[포획 실패..]");
				System.out.println(this.name + "이(가) 도망쳤다...");
				return false;
			}
		} catch (NumberFormatException e) {		// 숫자 외 문자를 입력한 경우
			System.out.println("###보기에 해당하는 숫자를 입력해주세요.###");
			System.out.println("[포획 실패..]");
			System.out.println(this.name + "이(가) 도망쳤다...");
			return false; 
		}
	}
}

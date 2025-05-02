package com.kopo.game;

import java.util.Random;

/***
 * Cat6 클래스
 * 여섯 번째 고양이 캐릭터 "뚱자"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 뚱자
 * - 나이: 9살
 * - 성별: 수컷
 * - 민첩성: 6
 */
public class Cat6 extends Base {
	/***
	 * Cat6의 기본 생성자
	 * 뚱자의 기본 특성을 초기화합니다.
	 * super()에 '파라미터를 4개' 줌으로써, 
	 * 부모 클래스 기본생성자가 아닌 '4개의 파라미터를 받아오는 메소드' 실행
	 */
	Cat6(){
		super("뚱자", 9, "수컷", 6, "집돌이");
	}
	
	/***
	 * 뚱자를 찾는 메소드
	 * 14% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 뚱자를 발견함
	 *         false: 뚱자를 발견하지 못함
	 */
	@Override
	public boolean findCat() {
		Random random = new Random();
		int randNumber = random.nextInt(7);
		if(randNumber==1) {
			System.out.println("[탐색 성공]");
			System.out.println(this.name + "을(를) 발견했습니다!!");
			return true;
		}
		System.out.println("[탐색 실패]");
		System.out.println("소리 하나 없이 고요합니다. 고양이도 숨을 죽인 걸까요?");
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
		printItem("얼음", "냉장고", "온돌방", 3);

		String input = Config.scanner.nextLine();

		// 문자 입력 시 오류 예외 처리
		try {
			int inputNum = Integer.parseInt(input);

			if(inputNum == answer) {
				System.out.println("[잡았다!]");
				System.out.println(this.name + "가(이) 방 한가운데 떡하니 누워 있다가 느릿느릿 붙잡혔다. 움직임엔 관심이 없어요.");
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

package ex08class;

/*
시나리오]
다음에 주어진 조건으로 '사람'을 추상화 하시오.
-속성 : 이름, 나이, 에너지
-행동 : 걷는다, 생각한다, 먹는다, 현재상태표현
-행동의 조건 
	먹으면 에너지가 2 증가
	걸으면 에너지가 1감소
	생각하면 에너지가 2감소
	단, 에너지의 최대/최소값은 0~10으로 한다.
	무한히 먹을수 없고, 에너지는 마이너스가 될수 없기 때문이다. 
 */
public class Human {
		
	//객체의 속성을 표현하는 멤버변수
	String name;//이름
	int age;//나이
	int energy;//에너지
	
	//행동을 표현하는 멤버메서드
	void walking() {//"걷는다"를 표현
		//에너지는 1 차감된다.
		energy--;
		if(energy<0) {
			//차감 후 만약 에너지가 음수이면 0으로 고정하고 아래 메세지를 출력한다.
			energy = 0;
			System.out.println("[walk]에너지는 0이 최소입니다.");
			System.out.println("0으로 고정됩니다.");
		}
		else {
			//정상적으로 차감된 경우 출력
			System.out.println("[walk]에너지가 1 감소하였습니다");
		}
	}
	//"생각하다"를 표현
	void thinking() {
		//2 차감후 음수인지 확인
		energy -= 2;
		if(energy<0) {
			energy = 0;
			System.out.println("[thinking]에너지는 0이 최소입니다.");
			System.out.println("0으로 고정됩니다.");
		}
		else { 
			System.out.println("[thinking]에너지가 2 감소하였습니다.");
		}
	}
	//"먹는다"를 표현
	void eat() {
		//2 증가후 10을 초과하는지 확인후 메세지 출력
		energy += 2;
		if(energy>10) {
			energy = 10;
			System.out.println("[eat]에너지는 10이 " + "최대치입니다.");
		}
		else {
			System.out.println("[eat]에너지가 2 증가하였습니다.");
		}
	}
	//객체의 현재상태를 출력하는 멤버메서드
	void showState() {
		System.out.println("===님의 현재상태는===");
		System.out.println("이름:"+ name);
		System.out.println("나이:"+ age);
		System.out.println("에너지:"+ energy);
		System.out.println("=====================");
	}
}


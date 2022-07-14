package bokang;

import bokang.sub.CheckCard1;
import bokang.sub.CheckCard2;
import bokang.sub.CheckCard3;

public class R06class {

	public static void main(String[] args) {

		/*
		체크카드 클래스 Ver.01
			숫자를 구분할때 언더바(언더스코어)를 사용할 수 있다.
			단, 숫자사이에 쓰는것만 허용된다.
			잘못된방법]
				3._1234
				123_456_
				_123_456
				이와같이 언더바로 시작하거나 끝날 수 없고, 소수점과 연결해서도
				사용할 수 없다.
		 */
		CheckCard1 cc1 = new CheckCard1();
		cc1.cardNumber = 1234_5678_9012_3456L;
		cc1.owner = "홍길동";
		cc1.balance = 10000;
		cc1.point = 0;
		cc1.payment(5000);//5000원 결제
		cc1.payment(10000);//10000원 결제 : 잔고가 부족한 상태지만 결제가 된다.
		cc1.showState();//상태를 보면 마이너스 금액이 출력된다.(논리적오류)
		cc1.balance = 100000000;//입금처리 없이 잔고의 변경이 가능하다.(논리적오류)
		
		
		/*
		체크카드 클래스 Ver.02 
		 */
		/*
		빈 객체를 생성한 후 초기화 메서드를 통해 객체를 초기화한다.
		이 경우 객체생성과 초기화를 별도로 진행해야 한다.
		 */
		CheckCard2 cc21 = new CheckCard2();
		cc21.initMembers(1111_2222_3333_4444l, "손오공", 30000, 0);
		cc21.payment(10000);//결제
		cc21.charge(5000);//충전
		cc21.showState();//상태확인
//		cc2.balance = 900000000;//정보은닉 되어있으므로 접그불가 에러발생.
	
		/*
		생성자 메서드를 사용하면 객체의 생성과 초기화를 동시에 할 수 있으므로
		초기화 메서드보다 편리하다. 따라서 객체생성은 생성자를 사용하는것이 좋다.
		 */
		CheckCard2 cc22 = new CheckCard2(9999_8888_7777_6666L, "유비", 40000, 40);
		cc22.payment(5000);
		cc22.showState();
		/*
		정보은닉되어 멤버변수에 직접 접근할수는 없으나 아직까지도 사용금액에
		대한 처리가 안되어있다.
		*/
		cc22.payment(100000);
		cc22.showState();//마이너스 금액이 출력된다.
		
		
		/*
		체크카드 클래스 Ver.02 
		 */
		CheckCard3 cc3 = new CheckCard3(7777_7777_7777_7777L, "이순신", 100_000, 0);
		cc3.charge(200_000);
		cc3.payment(10_000);
		cc3.payment(110_000);
		cc3.payment(500_000);
		cc3.showState();
	}
}

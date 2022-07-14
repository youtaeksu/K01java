package ex08class;

//과일판매자를 추상화한 클래스
class FruitSeller{
	
	//멤버변수(상태, 속성)
	int numOfApple = 100; //판매자가 보유한 사과의 갯수
	int myMoney = 0; //판매수익
	final int APPLE_PRICE = 1000; //사과의 단가
	/*
 	클래스에 멤버상수를 선언하는 경우 반드시 선언과 동시에 초기화 해야한다.
 	만약 초기화를 별도로 진행한다면 에러가 발생한다.
 	(차후 복습시 1000을 지워본다.)
	 */
		
	//멤버메서드(행위, 기능 등을 표현)
	/*
	판매자가 사과를 판매하는 행위를 표현한 멤버메서드
	1.구매자로부터 금액을 전달받는다.(메서드 호출시 매개변수를 통해 받음)
	2.금액/사과의단가=판매될 사과의 갯수를 계산한다.(5000/1000=5개)
	3.보유한 사과의 갯수에서 판매할 갯수만큼 차감한다. (100-5=95)
	4.판매수익이 증가한다.(5000원 증가)
	5.구매자에게 사과 5개를 반환한다. (return num)
	 */
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	//판매자의 현재상태를 출력한다.
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}

//구매자를 추상화한 클래스
class FruitBuyer{
	
	//멤버변수
	int myMoney = 5000; //보유한 금액
	int numOfApple = 0; //구매한 사과의 갯수
	
	/*
	구매자가 판매자에게 사과를 구매하는 행위를 표현한 멤버메서드
	1.판매자에게 금액을 지불한다
	==> 여기에서 seller객체의 saleApple() 메서드가 호출된다.
	2.판매자가 금액에 해당하는 사과의 갯수를 반환하면, 해당 갯수만큼
	보유한 사과가 증가된다.
	==> numOfApple += 메서드호출()
	3.판매자에게 지불한 금액만큼 차감된다.
	 */
	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	//구매자의 현재상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}

public class E06FruitSalesMain1 {

	public static void main(String[] args) {

		//판매자와 구매자 객체를 생성
		FruitSeller seller = new FruitSeller();
		FruitBuyer buyer = new FruitBuyer();
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller.showSaleResult();
		buyer.showBuyResult();
		
		//구매자가 5000원을 지불하고 사과를 구매한다.
		buyer.buyApple(seller, 5000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller.showSaleResult();
		buyer.showBuyResult();
	}
}

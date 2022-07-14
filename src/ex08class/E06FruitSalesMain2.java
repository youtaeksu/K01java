package ex08class;

/*
FruitSalesmain 첫번째 버전은 각 클래스가 멤버변수의 초깃값이 고정되어
상태가 다른 객체를 생성할 수 없는 단점ㅇ이 있었다.
두번째 버전에서는 다양한 초깃값을 부여할 수 있도록 초기화메서드를 도입해본다.
 */

class FruitSeller2{
	
	//멤버변수의 초깃값을 모두 제거한 후 선언만 해둔다.
	int numOfApple; 
	int myMoney; 
	int apple_price;/*
		사과의 단가를 표현하는 멤버변수는 일반변수로 변경한다.
		클래스의 멤버상수는 선언과 동시에 초기화 해야 되므로 상수는
		초깃값이 없는 상태로 선언 자체가 불가능하다.
		따라서 변수명도 전체 소문자로 변경한다.
	 */
		
	/*
	초기화 메서드를 선언하여 객체 생성후 다양한 형태의 초기화가 가능하다. 
	 */
	public void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	}
		
	public int saleApple(int money) {
		int num = money / apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}

class FruitBuyer2{
	
	//멤버변수의 초깃값을 제거한 후 초기화 메서드를 통해 초기화한다.
	int myMoney; 
	int numOfApple; 
	
	public void initMembers(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller2 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}

public class E06FruitSalesMain2 {

	public static void main(String[] args) {
		
		/*
		초기화 메서드가 정의되었으므로 상태가 다른 객체를 생성할 수 있다.
		 */
		//판매자1 : 사과 100개, 단가 1000원
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMembers(0, 100, 1000);
		//판매자2 : 사과 80개, 단가 500원
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.initMembers(0, 80, 500);
		//구매자 : 보유금액 10000원
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMembers(10000, 0);
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//각각의 판매자에게 5000원씩 지불하고 사과를 구매한다.
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
	}
}

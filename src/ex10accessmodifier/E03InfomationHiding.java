package ex10accessmodifier;

/*
세번째 버전에서는 초기화 메서드를 생성자로 변경한다.
 */
class FruitSeller6{
			
		private int numOfApple; 
		private int myMoney; 
		private final int APPLE_PRICE;/*
				멤버상수는 값의 변경이 불가능하고, 단 한번만 초기화되기 때문에
				일반 멤버메서드에서는 초기화 할 수 없다. 또한 초깃값이 없는 상태로
				선언 자체가 불가능하다.
				하지만 생성자는 객체생성시 딱 한번만 호출되고, 개발자가 마음대로
				호출할 수 없으므로 한번 이상 초기화 되지 않음이 보장된다.
				따라서 멤버상수는 생서자에서 초기화 할 수 있다.
				*/
		
		public FruitSeller6(int money, int appleNum, int price) {
				myMoney = money;
				numOfApple = appleNum;
				APPLE_PRICE = price;
		}
		public int saleApple(int money) {
				int num = money / APPLE_PRICE;
				numOfApple -= num;
				myMoney += money;
				return num;
		}
				
		public void showSaleResult() {
				System.out.println("[판매자]남은사과갯수:"+ numOfApple);
				System.out.println("[판매자]판매수익:"+ myMoney);
		}
}

class FruitBuyer6{
			
		private int myMoney; 
		private int numOfApple; 
		
		public FruitBuyer6(int _myMoney, int _numOfApple) {
			myMoney = _myMoney;
			numOfApple = _numOfApple;
		}
			
		public void buyApple(FruitSeller6 seller, int money) {
				numOfApple += seller.saleApple(money);
				myMoney -= money;
			}
			
			public void showBuyResult() {
				System.out.println("[구매자]현재잔액:"+ myMoney);
				System.out.println("[구매자]사과갯수:"+ numOfApple);
			}
		}

		public class E03InfomationHiding {

			public static void main(String[] args) {
				
				/*
				초기화 메서드를 사용하는 경우 객체생성과 초기화를 별도로 진행하지만
				생성자를 사용하면 생성과 초기화를 동시에 할 수 있다.
				 */
				//판매자1 : 사과 100개, 단가 1000원
				FruitSeller6 seller1 = new FruitSeller6(0, 100, 1000);
				//판매자2 : 사과 80개, 단가 500원
				FruitSeller6 seller2 = new FruitSeller6(0, 80, 500);
				//판매자3 : 보유금액10000원
				FruitBuyer6 buyer = new FruitBuyer6(10000, 0);
				
				
				System.out.println("구매행위가 일어나기전의 상태");
				seller1.showSaleResult();
				seller2.showSaleResult();
				buyer.showBuyResult();
				
				/////////////////////////////////////////////////
				/*
				멤버변수를 private으로 선언하면 클래스 외부에서는 접근이 불가능하므로
				기존 코드는 모두 에러가 발생한다.(주석으로 처리했음)
				즉, 멤버변수의 정보은닉을 통해 비정상적인 접근을 차단하고, 멤버메서드를
				통해서만 구매가 이뤄질수 있도록 구현해야 한다.
				 */
				//각각의 판매자에게 5000원씩 지불하고 사과를 구매한다.
				buyer.buyApple(seller1, 5000);
				buyer.buyApple(seller2, 5000);
				
				
				/*
				seller1.myMoney += 1000;    //판매자1에게 1000원을 지불하고
				seller1.numOfApple -= 50;	//사과 50개를 구매한다.
				buyer.numOfApple += 50;		//구매자는 50개의 사과가 증가했다.
				
				seller2.myMoney += 1000;	//판매자2에게 1000원을 지불하고
				seller2.numOfApple -= 70;	//사과 70개를 구매했다.
				buyer.numOfApple += 70;		//따라서 구매자는 사과 70개가 증가했다.
											//하지만 구매자의 금액은 전혀 차감되지 않았다.
				*/
				/////////////////////////////////////////////////
				
				System.out.println("구매행위가 일어난 후의 상태");
				seller1.showSaleResult();
				seller2.showSaleResult();
				buyer.showBuyResult();
			}
		}
		
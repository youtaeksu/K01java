package ex12Inheritance;
/*
class A{}
class B extends A{}
=> 이 경우 클래스A, B에는 생성자를 정의하지 않았으므로 디폴트 생성자가
	컴파일러에 의해 추가된다. 따라서 위 코드는 정상적으로 실행된다.
	아래는 컴파일 된 모습이다.
	class A{
		public A(){} <- 디폴트생성자
	}
	class B extends A{
		public B(){
			super(); <- 디폴트생성자 및 부모클래스의 생성자 호출
		}
	}
===========================================================================
class C{
	public C(int x){} <- 개발자가 직접 정의한 인자생성자
}
class D extends C{
	public D(){
	super(99); <- 부모의 인자생성자를 호출하는 super()를 반드시 기술해야
				한다. 생성자를 정의하는 순간 디폴트 생성자는 추가되지
				않으므로 super()를 기술하지 않으면 에러가 발생한다.
	}
}
 */
class Account {
	/*
	멤버변수가 상속관계에 있다 하더라도 private 으로 선언되면 클래스
	내부에서만 접근할 수 있다. 즉 상속받은 하위클래스에서는 직접
	접근이 불가능하다.
	 */
	private int money;
	/*
	이와같이 개발자가 생성자를 직접 정의하면 디폴트 생성자는
	추가되지 않는다. 디폴트 생성자는 개발자가 생성자를 정의하지
	않았을때만 컴파일러에 의해 자동으로 추가된다.
	 */
	public Account(int init) {
		money = init;
	}
	//입금처리 : protected로 선언되었으므로 상속관계에서 접근가능
	protected void depositMoney(int _money) {
		if(_money<0) {
			System.out.println("마이너스 금액은 입금처리 불가합니다");
			return;
		}
		//멤버변수에 매개변수로 전달된 금액을 더한다.
		money += _money;
	}
	//private멤버변수를 외부로 반환할때 사용한다. (getter메서드)
	protected int getAccMoney() {
		return money;
	}
}
class SavingAccount extends Account {
	/*
	인자생성자에서 부모의 생성자를 호출하기 위한 super()를 사용한다.
	이때 인자가 하나인 부모클래스의 생성자가 호출된다.
	현재 부모클래스에는 인자가 하나인 생성자가 유일하므로 만약 아래와
	같이 호출하지 않으면 에러가 발생한다.
	 */
	public SavingAccount(int initVal) {
		super(initVal);
	}
	/*
	부모클래스의 protected로 선언된 멤버메서드를 호출해서
	입금처리를 한다.
	 */
	public void saveMoney(int money) {
		depositMoney(money);
	}
	public void showAccountMoney() {
		//money는 private멤버이므로 직접 접근 불가
		//System.out.println("지금까지의 누적금액:"+ money);
		
		//따라서 접근이 가능한 메서드를 통해 간접적으로 접근한다.
		System.out.println("지금까지의 누적금액:"+ getAccMoney());
	}
}
public class E02PrivateInheritanceMain {

	public static void main(String[] args) {

		//자식클래스를 통해 객체 생성
		SavingAccount sa = new SavingAccount(10000);
		
		/*
		private멤버이므로 상속받은 하위클래스의 참조변수를 통해서는
		접근할 수 없다. 은닉된 정보이므로 'not visible'이라는 에러메세지를
		볼 수 있다.
		 */
//		sa.money = 100000; //에러발생
		sa.saveMoney(5000);//입금처리
		sa.showAccountMoney();//잔액조회
		
		sa.saveMoney(-1000);//음수이므로 입금 처리 안됨.
		sa.showAccountMoney();
		
		/*
		부모클래스의 참조변수를 통해서도 private 멤버는 접근할수 없다.
		현재 접근하려는 위치가 Account 클래스 외부이기 때문이다.
		즉, private멤버는 무조건 해당 클래스 내에서만 접근할 수 있다.
		 */
		Account account = new Account(1000);
//		account.money = 1000; //에러발생
	}
}

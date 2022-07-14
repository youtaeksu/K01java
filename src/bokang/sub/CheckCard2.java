package bokang.sub;
/*
체크카드 클래스 Ver.02

버전02에서 추가부분
	1. 멤버변수 초기화 메소드 정의 
		메소드명 : initMembers()
	2. 기본생성자, 인자생성자 정의
	3. 멤버변수 정보은닉
	4. getter/setter 메소드 추가
 */
public class CheckCard2 {
	//멤버변수
	private long cardNumber;
	private String owner;
	private int balance;
	private int point;
	
	//초기화 메서드
	public void initMembers(long cn, String o, int b, int p) {
		this.cardNumber = cn;
		this.owner = o;
		this.balance = b;
		this.point = p;	
	}
	/*
	생성자 메서드와 초기화 메서드의 차이점
	1.반환타입 : 생성자는 반환타입이 없다.
	2.호출시기와 방법 : 객체를 생성할 때 딱 한번만 호출된다. 우리가 원할때
		호출할 수 없다.
	3.멤버상수 초기화 : 생성자에서는 멤버상수를 초기화 할수있다. 하지만
		멤버메서드에서는 초기화 할 수 없다.
	 */
	//기본생성자 : 초깃값이 없는 빈 객체를 만들 수 있다.
	public CheckCard2() {}
	//인자생성자 : 객체 생성과 동시에 초기화한다.
	public CheckCard2(long cardNumber, String owner, int balance, int point) {
		super();
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	/*
	생성자와 getter, setter메서드는 항상 자동생성 메뉴를 사용한다.
	 */
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	//멤버메소드 :
	//충전(입금) : 매개변수로 전달된 금액만큼 잔고에 더해준다. 
	public void charge(int amount) {
		this.balance += amount;
		System.out.println(amount+"원이 충전되었습니다.");
	}
	
	//결제 : 매개변수로 전달된 금액만큼 잔고에서 차감한다.
	public void payment(int amount) {
		this.balance -= amount;
		System.out.println(amount+"원이 결제되었습니다.");
		//체크카드 사용시 적립금이 발생하므로 해당 메서드에서 호출해야한다.
		savingPoint(amount);
	}
	
	//적립,
	public void savingPoint(int amount) {
		double plusPoint = amount * 0.1;
		/*
		멤버변수 point는 int형이므로 double형과 연산하면 double로 자동형변환된다.
		따라서 아래 문장은 에러가 발생되므로 강제형변환 하거나 point를 double로 변경해야한다.
		 */
		//this.point = this.point + plusPoint;
		/*
		포인트는 보통 원단위 이하는 절삭하므로 아래와 같이 복합대입연산자를 사용하면
		별도의 형변환없이 int형으로 계산할 수 있다.
		 */
		this.point += plusPoint;
	}
	
	//현재상태출력
	public void showState() {
		System.out.println("카드번호:" +this.cardNumber);
		System.out.println("소유자:" +this.owner);
		System.out.println("잔고:" +this.balance);
		System.out.println("포인트:" +this.point);
	}
}

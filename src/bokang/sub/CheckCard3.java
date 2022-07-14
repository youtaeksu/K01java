package bokang.sub;
/*
체크카드 클래스 Ver.03
	: initMembers 초기화 메소드는 삭제처리 
	
	1.충전은 10000원 단위로만 가능하다.
	만약 5000원을 충전하면 충전불능으로 처리한다.
	
	2.잔고가 부족하면 결제불능으로 처리해야 한다.
		
	3.생성자 오버로딩 처리
		new CheckCard3(카드번호, 소유자, 잔고, 포인트);
		new CheckCard3(카드번호, 소유자, 잔고); => 포인트 0으로 초기화
		new CheckCard3(카드번호, 소유자); => 잔고, 포인트 0으로 초기화
	
	4.포인트 적립율 변경
		10만원 이하결재 : 10%적립
		10만원 초과결재 : 30%적립
 */
public class CheckCard3 {
	//멤버변수
	private long cardNumber;
	private String owner;
	private int balance;
	private int point;
	
	//초기화 메서드
	public void initMembers(long cn, String o, int b, int p){
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
	public CheckCard3() {}
	//인자생성자 : 객체 생성과 동시에 초기화한다.
	public CheckCard3(long cardNumber, String owner, int balance, int point) {
		super();
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	public CheckCard3(long cardNumber, String owner, int balance) {
		super();
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = 0;
	}
	public CheckCard3(long cardNumber, String owner) {
		super();
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = 0;
		this.point = 0;
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
		
		/*
		충전은 10000원 단위로만 가능하므로 나눠서 나머지가 0인 경우에만
		실행한다.
		 */
		if(amount%10000==0) {
			this.balance += amount;
			System.out.println(amount+"원이 충전되었습니다.");
		}
		else {
			System.out.println("충전은 10000원 단위로만 가능합니다.");
		}
	}
	
	//결제 : 매개변수로 전달된 금액만큼 잔고에서 차감한다.
	public void payment(int amount) {
		
		/*
		결제할 금액이 잔고와 동일하거나 적어야 한다.
		따라서 잔고가 결제금액보다는 크거나 같아야한다.
		 */
		if(this.balance >= amount) {
			this.balance -= amount;
			System.out.println(amount+"원이 결제되었습니다.");
			//체크카드 사용시 적립금이 발생하므로 해당 메서드에서 호출해야한다.
			savingPoint(amount);
		}
		else {
			System.out.println("잔고 부족으로 결제할 수 없습니다");
		}
	}
	
	//적립,
	public void savingPoint(int amount) {
		/*
		넓은 지역에서 생성한 변수는 좁은지역에서 사용할 수 있다.
		하지만 좁은 지역에서 생성한 변수는 넓은지역에서 사용할 수 없다.
		지역변수는 해당 지역을 벗어나면 메모리에서 소멸된다.
		 */
		double plusPoint = 0;
		
		//결제금액이 10만원을 초과하면 30%를 적립한다.
		if(amount>100000) {
			plusPoint = amount * 0.3;
		}
		else {
			plusPoint = amount * 0.1;
		}
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

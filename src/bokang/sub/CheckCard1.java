package bokang.sub;
/*
체크카드 클래스 Ver.01

시나리오] 체크카드를 클래스로 표현해보자.
	멤버변수 : 카드번호, 소유자, 잔액, 포인트
	멤버메소드 : 충전(입금), 결제, 적립, 현재상태출력
	적립율 : 사용금액의 0.1%	
*/
public class CheckCard1 {
	//멤버변수
	public long cardNumber;
	public String owner;
	public int balance;
	public int point;
	
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

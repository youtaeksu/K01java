package ex14innerclass;
/*
내부클래스(Inner class)
: 클래스 안에 정의된 클래스로 static이 없는 클래스를 말한다.
-외부 클래스의 모든 멤버(정적 혹은 인스턴스형)를 사용할 수 있다.
-정적 멤버를 가질수 없다. 단 상수는 가질 수 있다.
-컴파일시 외부클래스명$내부클래스명.class 파일이 생성된다.
-이벤트 기반의 프로그래밍에서 많이 사용된다.
 */
class Unit {
	//멤버변수
	private String name;
	private int healthPoint;
	//인스턴스형 멤버변수 : 사용시 반드시 new를 통해 객체를 생성해야한다.
	Marine marine;
	Medic medic;
	
	//생성자
	public Unit(String name, int healthPoint) {
		//멤버변수 초기화
		this.name = name;
		this.healthPoint = healthPoint;
		//인스턴스형 멤버변수 객체생성
		marine = new Marine();
		//만약 Medic객체를 사용하려면 객체를 먼저 생성해야 한다.
		//medic = new Medic();
	}
	//멤버변수 정보 반환
	public String infoStr() { 
		return "유닛정보[이름:"+name+", 체력:"+healthPoint+"]";
	}
	//내부클래스 정의(내부 멤버 클래스)
	class Marine {
		//내부클래스도 일반적인 클래스와 동일하게 멤버를 정의할 수 있다.
		int attakckPower;
		public void attack() { 
			/*
			내부클래스에서는 외부클래스의 모든 멤버에 접근할 수 있다.
			외부클래스가 더 넓은 지역이므로 가능하다.
			 */
			System.out.println(infoStr()+"\n마린이 공격한다."); 
		}
	}
	class Medic { 
		int healPower;
		public void heal() {
			System.out.println(infoStr()+"\n메딕이 치료한다.");
		}
	}
}
public class E01InnerClassMain {

	public static void main(String[] args) {

		//외부클래스의 객체를 먼저 생성한다.
		Unit unit = new Unit("커맨트센터", 1000);
		System.out.println(unit.infoStr());
		/*
		외부클래스가 아닌 다른 클래스에서는 내부멤버클래스가 보이지 않으므로
		직접 인스턴스를 생성할 수 없다
		 */
		//Marine m = new Marine(); //에러발생
		
		/*
		외부클래스의 인스턴스를 먼저 생성한 후 내부클래스의 인스턴스를 생성해야한다.
		Marine은 Unit 클래스의 생성자에서 이미 객체가 생성되었으므로 아래와같이
		즉시 객체를 생성할 수 있다.
		 */
		Unit.Marine marine = new Unit("마린", 50).marine;
		marine.attack();
		
		/*
		Medic의 경우 Unit의 생성자에서 객체가 생성되지 않았으므로 
		아래와 같이 new를 통해 생성해야 한다. 이때에도 Unit객체를 통해 생성해야
		하므로 new를 두번 사용해서 객체를 생성한다.
		 */
		Unit.Medic medic = new Unit("메딕", 30).new Medic();
		medic.heal();
	}
}

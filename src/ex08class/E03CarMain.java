package ex08class;

//자동차를 추상화한 클래스
class Car {
	
	//멤버상수
	public static final String AUTO = "자동";
	public static final String MANUAL = "수동";
		
		
	//멤버변수
	String carGear = AUTO;//미션 : String형, '자동'으로 초기화.
	String carModel;//모델명 : String형
	int carYear;//연식 : int형
	Human owner;//소유주 : Human타입의 객체형 멤버변수;
	
	//멤버메소드
	void drive() {
		/*
		owner는 객체이므로 이름을 출력하기 위해서는 "참조변수.name"과 같이
		기술해야 한다.
		 */
		System.out.println(owner.name +"이(가) "+ carModel +"을 운전한다.");
	}
	
	
	/*
	초기화메서드1 : 매개변수가 없는 형태로 항상 고정된 값으로만
		객체를 초기화 할 수 있는 메서드. 따라서 확장성이 전혀
		없는 형태의 메서드이다.
	 */
	void initialize() {
		carModel = "람보르기니";
		carYear = 2017;
		owner = new Human();
		owner.name = "캡틴로져스";
		owner.age = 30;
		owner.energy = 10;
	}
	/*
	위와 동일한 이름의 메서드로 오버로딩에 의해 정의된 초기화 메서드이다.
	초기화를 진행하는 역활은 동일하나, 매개변수를 통해 다양한 형태의 객체를
	초기화 할 수 있다.
	 */
	void initialize(String model, int year, String name, int age, int energy) {
		carModel = model;
		carYear = year;
		owner = new Human();
		owner.name = name;
		owner.age = age;
		owner.energy = energy;
	}
	//객체의 현재상태를 출력하는 메서드
	void showCarInfo() {
		System.out.println("[차량정보]");
		System.out.printf("모델명:%s\n", carModel);
		System.out.printf("연식:%d\n", carYear);
		System.out.printf("기어:%s\n", carGear);
		//소유주를 표현하는 owner객체의 showState()를 호출해서 정보를 출력한다.
		owner.showState();
	}
}//end of Car class


public class E03CarMain {

	public static void main(String[] args) {

		Car car1 = new Car();
		System.out.println("[초기화메소드 호출전]");
		//아직까지 Human타입의 owner객체는 메모리에 생성되지 않았다.
		System.out.println("car1.owner="+ car1.owner);
		//car1.drive(); => 에러발생
		/*
		실행시 예외가 발생한다. 자동차 소유주를 표현하는 Human객체가 생성되지
		않은 상태에서 출력을 시도하여 런타임 에러가 발생한 것이다.
		 */
		
		System.out.println("[초기화메소드 호출후]");
		//초기화 메서드 호출을 통해서 Human()객체가 생성되고 초기화까지 진행된다.
		car1.initialize();
		/*
		해당 초기화 메서드는 항상 고정된 값으로만 초기화 되기 때문에 확장성이
		없다. 따라서 실무에서는 이와같은 형태로는 정의하지 않는다.
		 */
		car1.drive();//정상호출됨
		car1.showCarInfo();//정상호출됨
		
		
		/*
		자동차 2 객체 생성 : 객체생성 후 멤버변수에 직접 접근하여 초기화한다.
		
		만약 2개 이상의 객체를 생성해야 한다면 아래의 초기화 코드가 중복사용
		되야하므로 코드의 낭비가 심하다. 따라서 이 방법도 실무에서는 사용하지 않는다.
		단지 멤버변수에 접근하는 방법 정도로만 생각하면 된다.
		 */
		Car car2 = new Car();
		car2.carGear = Car.MANUAL;
		car2.carModel = "밴틀리";
		car2.carYear = 2018;
		
		car2.owner = new Human();
		car2.owner.name = "토니스타크";
		car2.owner.age = 52;
		car2.owner.energy = 8;
		
		System.out.println("자동자정보와 소유자정보 같이보기");
		car2.showCarInfo();
		
		/*
		자동차3 객체 생성 :매개변수가 있는 초기화 메서드를 사용하여 객체를
			초기화 한다. 이 경우 매개변수를 통해 다양한 값을 전당할 수 있으므로
			여려형태의 객체를 생성할 수 있다.
			또한 객체 초기화를 위한 중복되는 코드를 줄일 수 있으므로 효율적이다.
		 */
		Car car3 = new Car();
		car3.initialize("스포츠카", 2012, "성유겸", 8, 10);//초기화
		car3.showCarInfo();
	}
}

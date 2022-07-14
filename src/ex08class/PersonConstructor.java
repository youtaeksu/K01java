package ex08class;
/*
생성자(Constructor)
-클래스를 객체화(인스턴스화)할때 자동으로 호출되는 메서드
-자동으로 호출되며 개발자가 임의로 호출할 수 없다.
-반환값이 없다. 즉 특정 연산 후 값을 반환할 수 없다.
	따라서 coid를 쓰면 에러가 발생한다.
-그 외는 
 */
public class PersonConstructor {

	String name;
	int age;
	String addr;
	
	/*
	디플트 생성자 : 해당 클래스에 생성자를 정의하지 않으면 아래와 같이 
	매개변수, 실행부가 없는 생성자가 컴파일러에 의해 자동으로 삽입된다.
	이를 디폴트 생성자라고 한다.
	지금까지 우리가 new 클래스명() 과 같이 사용했던 문장이 바로 디폴트 생성자를
	호출하는 것이었다.
	 */
	//public PersonConstructor() {}
	
	//※만약 아래와 같이 개발자가 생성자를 정의하면 디폴트생성자는 삽입되지 않는다.
	//생성자1 : 매개변수가 없는 형태로 정의
	public PersonConstructor() {
		name = "이름없음";
		age = 0;
		addr = "미상";
		System.out.println("나는 생성자1 입니다");
	}
	//인자생성자2
	public PersonConstructor(String name) {
		/*
		해당 this는 멤버변수와 매개변수를 구분하기 위한 용도로 사용되는데
		클래스 자신, 즉 멤버를 가리킨다.
		따라서 좌측항은 멤버변수 우측항은 매개변수를 가리키게 된다.
		 */
		this.name = name;
		age = 1;
		addr = "출처불명";
		System.out.println("나는 인자생성자2 입니다");
	}
	//인자생성자3
	public PersonConstructor(String name, int age) {
		/*
		this()는 생성자에서 다른 생성자를 호출할때 사용한다.
		단, 생성자 내에서만 사용할 수 있고, 일반 멤버메서드에서는 사용할 수 없다.
		즉, 아래는 매개변수가 3개인 생성자를 호출하는 문장이 된다.
		 */
		System.out.println("나는 인자생성자3 입니다");
	}
	//인자생성자4
	public PersonConstructor(String _name, int age, String addr) {
		//매개변수와 멤버변수명이 다르면 this를 사용하지 않아도 된다.
		name = _name;
		//둘이 동일한 경우에는 this를 쓰도록 권장하고 있다.
		this.age = age;
		this.addr = addr;
		System.out.println("나는 인자생성자4 입니다");
	}
	//초기화를 담당하는 멤버메서드
	void initialize(String name, int age, String addr) {
		
		//해당 코드는 생성자 내에서만 사용할 수 있다.
		//this(name, age, "미상"); => 에러발생 
		/*
		생성자는 객체 생성시 딱 한번만 호출되고 개발자가 임의로 호출할 수 없다
		멤머메서드는 개발자가 원할때 몇번이고 호출이 가능하므로 생성자와는
		특성이 다르다. 따라서 멤버메서드에서는 생성자를 호출할 수 없다.
		 */
		
		//멤버변수 구분을 위한 this는 멤머메서드에서도 사용할 수 있다.
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	//상태 확인용 멤버메서드
	void showPersonInfo() {
		System.out.printf("%s 님의 정보\n", this.name);
		System.out.printf("나이:%d\n", age);
		System.out.printf("주소:%s\n", addr);
	}
}


package ex13interface;
/*
추상클래스
-상속을 목적으로 제작되므로 객체생성을 허용하지 않는다.
-추상클래스는 대부분 추상메서드를 포함하고 있으므로, 이를 상속받는
	클래스는 반드시 추상메서드를 오버라이딩 해야한다.
-클래스의 상속관계에서 설계도와 같은 역활을 한다.
-객체생성은 할 수 없으나 그외 참조변수, 상속 등의 모든 기능을
	사용할 수 있다.

추상메서드
-오버라이딩의 목적으로 제작된다.
-메서드의 실행부가 없으므로 중괄호 {} 대신에 ; 을 붙여 마무리한다.
 */

//추상클래스1 : 추상메서드를 포함하지 않은 클래스
abstract class AbsClass1 {
	
	//int형으로 표현할 수 있는 최대값을 반환하는 Wrapper클래스의 상수
	public static final int MAX_INT = Integer.MAX_VALUE;
		
	//일반적인 멤버메서드
	void instanceMethod() {}
	//정적 멤버메서드
	static void staticMethod() {}
}
class AbsClassChild1 extends AbsClass1 {
	/*
	추상메서드를 포함하지 않은 추상클래스를 상속하면 오버라이딩은
	강제사항이 아닌 선택사항이다. 즉 필요한 경우에만 오버라이딩 하면 된다.
	아래 오버라이딩 한 메서드는 지워도 에러가 발생하지 않는다. 
	 */
	@Override
	void instanceMethod() {
		System.out.println("선택적 오버라이딩");
	}
}
/*
추상클래스2 : 추상메서드를 포함한 클래스
	추상메서드를 멤버로 포함한 클래스는  반드시 abstract로 선언해야한다.
	그렇지 않으면 에러가 발생한다.
 */
abstract class AbsClass2 {
	//추상메서드는 실행부가 없으므로 {}를 쓰지않는다.
	abstract void absMethod(int number);
}
/*
위 클래스를 상속하면 부모가 가진 추상메서드를 그대로 상속받게 되므로
해당 클래스도 abstract로 선언해야 한다. 단, 이경우 해당 클래스로도 객체를
생성할 수 없게된다. 만약 객체를 생성해야 한다면 추상메서드를 자식쪽에서
오버라이딩 하면 된다.
 */
class AbsClassChild2 extends AbsClass2 {
	/*
	오버라이딩은 부모쪽의 메서드를 가리고 새로운 기능으로 재정의
	하는것이므로 해당 자식쪽 클래스는 추상메서드를 포함하지 않은
	상태가 된다.
	만약 오버라이딩 하지 않으면 에러가 발생한다. 
	 */
	@Override
	void absMethod(int number) {
		System.out.println("필수 오버라이딩");
	}
	void newMethod() {
		System.out.println("확장한 메소드"); 
	}
}

public class E01AbstractMain {

	public static void main(String[] args) {
		
		//추상클래스는 객체를 생성할 수 없다.
//		AbsClass1 absClass1 = new AbsClass1();
		
		//추상클래스를 상속한 하위클래스는 객체생성을 할 수 있다.
		AbsClassChild1 AbsClassChild1 = new AbsClassChild1();
		
		//추상클래스는 객체(인스턴스)생성은 할수없지만, 참조변수로는 사용할 수 있다.
		AbsClass2 absClass2 = new AbsClassChild2();
		absClass2.absMethod(100);
		//부모타입으로 자식객체에 접근하려면 다운캐스팅 해야한다.
		((AbsClassChild2)absClass2).newMethod();
		
		/*
		추상클래스내에 선언된 정적 멤버메서드는 오버라이딩의 대상이 아니므로
		static의 기본규칙을 따른다. 즉 클래스명으로 접근하면 된다.
		 */
		AbsClass1.staticMethod();
		AbsClassChild1.staticMethod();
		System.out.println("int형의최대값:"+AbsClass1.MAX_INT);
	}
}

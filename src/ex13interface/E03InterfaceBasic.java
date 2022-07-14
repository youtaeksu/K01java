package ex13interface;

/*
인터페이스(interface)
-클래스가 객체의 설계도라면 인터페이스는 클래스의 설계도라 할수있다.
-자바는 단일 상속을 원칙으로 하지만 인터페이스를 통해 다중상속을 할수있다.
-추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 하위클래스에서는
	반드시 추상메서드를 오버라이딩 해야한다.
-멤버로는 추상메서드와 상수로만 구성된다.
	메서드 : public abstract
	상수: public static final
-인터페이스는 생성자가 없다
 */
interface MyInterface1 {
	
	//생성자는 사용할 수 없다.
	//public MyInterface1() {}
	
	//멤버상수 : 인터페이스에 선언되는 변수는 무조건 상수로 선언된다.
	//			따라서 반드시 대문자로 기술해야 한다.
	public static final int MAX_INT = Integer.MAX_VALUE;
	double MAX_DBL = Double.MAX_VALUE;//public static final은 생략하는게 좋다.
	
	//멤버메서드 : 무조건 추상메서드로 선언된다.
	public abstract void absFunc1();
	void absFunc2();//public abstract는 생략하는게 좋다.
}
interface MyInterface2 {
	void absFunc2();	
}
class SimpleClass {
	int simple = 1;
	void mySimple() {
		System.out.println("simple="+ simple);
	}
}
/*
인터페이스는 콤마를 이용해서 여러개를 동시에 '구현' 할 수 있다.
또한 '상속'과 '구현'을 동시에 사용할수도 있다.
 */
class MyClass extends SimpleClass implements MyInterface1, MyInterface2 {
	/*
	인터페이스에 동일한 이름의 추상메서드가 존재하는 경우 하나만 오버라이딩
	하면 된다.
	 */
	@Override
	public void absFunc1() {
		System.out.println("absFunc1() 호출됨");
	}
	@Override
	public void absFunc2() {
		System.out.println("absFunc2() 호출됨");
	}
}	
public class E03InterfaceBasic {

	public static void main(String[] args) {

		//구현한 인터페이스를 통해 참조변수를 생성할 수 있다.
		MyInterface1 my1 = new MyClass();
		my1.absFunc1();
		my1.absFunc2();
		//자식쪽 멤버에 접근하기 위해 다운캐스팅 후 호출한다.
		((SimpleClass)my1).mySimple();
		
		//MyClass의 부모이므로 아래는 모두 참조 가능하다.
		MyInterface2 my2 = new MyClass();
		SimpleClass simpleClass = new MyClass();
	}

}

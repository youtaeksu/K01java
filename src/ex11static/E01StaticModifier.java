package ex11static;
/*
static variable(정적변수)
-멤버변수 앞에 static 키워드를 붙이면 정적변수가 된다.
-정적변수는 JVM(자바가상머신)에 의해 프로그램이 시작되는 시점에 초기화된다.
-main()메서드가 실행되기전에 이미 초기화되므로 main()메서드 실행시
	별도의 선언없이 변수를 사용할 수 있다.
접근방법
	-클래스내부 : 변수명으로 접근가능(일반적인 멤버변수와 동일)
	-클래스외부
		1.참조변수를 통해 접근(권장사항아님)
		2.클래스명을 통해 접근(권장사항)
-메서드 앞에 static을 붙이면 정적메서드가 된다. 정적변수와 모든 특성이 동일하다.
 */
class MyStatic {
	/*
	멤버변수 : 인스턴트형 멤버변수는 반드시 클래스의 객체를 생성한
		후 참조변수를 통해 접근해야 한다.
	 */
	int instanceVar;
	/*
	정적멤버변수 : 객체를 생성할 필요없이 클래스명으로 바로 접근할
		수 있다. 프로그램 시작시 이미 메서드 영역에서 로딩된다.
	 */
	static int staticVar;
	/*
	인스턴스형 멤버메서드 : 인스턴스형 메서드에서는 모든 멤버를
		사용할 수 있다. 인스턴스형, 정적변수 둘다 접근 가능하다.
	 */
	void instanceMethod() {
		System.out.println("instanceVar="+ instanceVar);
		System.out.println("staticVar="+ staticVar);
		staticMethod();
	}
	/*
	정적멤버메서드 : 정적 메서드 안에서는 인스턴스형 멤버를 사용할
		수 없다. 정적 멤버만 접근할 수 있다.
		(*main 메소드에서는 static으로 선언된 메서드만 호출할
		수 있었음을 기억하자.)
	 */
	static void staticMethod() {
//		System.out.println("instanceVar="+ instanceVar);//에러발생
		System.out.println("staticVar="+ staticVar);
//		instanceMethod();//에러발생
	}
}
public class E01StaticModifier {

	public static void main(String[] args) {

		/*
		일반적인 멤버변수에 접근하는 방법 : Mystatic클래스의 객체를
			생선한 후 참조변수를 통해 접근한디
		 */
		MyStatic myStatic = new MyStatic();
		myStatic.instanceVar = 100;
		System.out.println("myStatic.instanceVar="+ myStatic.instanceVar);
			
		/*
		static(정적) 멤버변수 접근 방법 : 클래스명을 통해 직접 접근
			한다. 객체를 생성하지 않고 바로 접근할 수 있다.
		 */
		MyStatic.staticVar = 200;
		System.out.println("MyStatic.staticVar="+ MyStatic.staticVar);
		
		/*
		정벅변수도 일반적인 멤버변수처럼 참조변수를 통해 접근할 수
		있지만, 이는Java에서 건장하지 않는다.
		(※ 참조변수를 통해 접근할거면, 굳이 정적변수를 사용할 이유가
		없다.)
		 */
		myStatic.staticVar = 300;
		System.out.println("myStatic.staticVar="+ myStatic.staticVar);
		
		///////////////////////////////////////////////////////
		
		MyStatic ms1 = new MyStatic();
		MyStatic ms2 = new MyStatic();
		
		/*
		인스턴스형 변수는 각각의 객체내에 존재하므로 아래 2개의 값은
		다르게 출력된다.
		 */
		ms1.instanceVar = 100;
		ms2.instanceVar = 1000;
		System.out.println("ms1.instanceVar="+ ms1.instanceVar);//100
		System.out.println("ms2.instanceVar="+ ms2.instanceVar);//1000
		
		/*
		하지만 정적 변수는 메서드 영역에 딱 하나만 생성되므로 어떤
		객체로 접근하든 동일한 메모리가 된다. 따라서 값을 공유하게
		되므로 출력결과는 동일하다.
		 */
		ms1.staticVar = 800;
		ms2.staticVar = 900;
		System.out.println("ms1.staticVar="+ ms1.staticVar);//900
		System.out.println("ms2.staticVar="+ ms2.staticVar);//900
		
		/*
		정적 멤버메서드의 접근방법은 정적변수의 접근방법과 동일하다.
		 */
		myStatic.instanceMethod();
		myStatic.staticMethod();//권장사항이 아니므로 클래스명을 사용하는것이 좋다.
	
//		MyStatic.instanceMethod(); //에러발생. 참조변수를 통해서만 접근할 수 있다.
		MyStatic.staticMethod();
	}
}

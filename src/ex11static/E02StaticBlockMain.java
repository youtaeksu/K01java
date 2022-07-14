package ex11static;

/*
static 블럭
	: 동일 클래스내 main() 메서드보다 먼저 실행되는 블럭으로
	main메서드의 실행코드가 없어도 먼저 실행된다.
	또한 생성자 메서드보다도 static블럭이 먼저 실행된다.
 */
public class E02StaticBlockMain {

	//인스턴스형 멤버
	int instanceVar;
	void instanceMethod() {}
	
	//정적 멤버
	static int staticVar;
	static void staticMethod() {
		int localVar;//해당 메서드 내에서만 쓸수있는 지역변수
		System.out.println("정적메소드");
	}
	
	//static 블럭 정의 
	static {
		//블럭내에서 정적멤버에 접근 가능
		staticVar = 1000;
		
		/*
		블럭내에서만 사용할 수 있는 변수로써, 블럭내에서는 일반적인 변수를
		생성할 수 있다.
		 */
		int localVar;
		localVar = 1000;
		System.out.println("localVar="+ localVar);//사용가능
		
		//static블럭내에서는 인스턴스형 멤버는 접근할 수 없다.
//		System.out.println("instanceVar="+ instanceVar);
//		instanceMethod();
		
		//정적멤버는 접근할 수 있다.
		System.out.println("staticVar="+ staticVar);
		staticMethod();
		
		System.out.println("===static block 끝===");
	}
	
	//생성자 메서드 정의
	public E02StaticBlockMain() {
		//생성자에서는 정적멤버에 접근 가능(일반적인 멤버변수와 동일함)
		staticVar = -1;
		System.out.println("===StaticBlock의 생성자===");
	}
	
	public static void main(String[] args) {
		
		//메인메서드 실행전에 static블럭이 먼저 실행된다.
		System.out.println("==메인메소드==");
		
		/*
		static블럭 내에서 선언된 변수는 지역변수이므로 main메서드에서는
		사용할 수 없다. 해당 지역에서만 사용할 수 있다.
		 */
//		System.out.println("localVar="+ localVar);
		
		//객체생성시 생성자가 호출된다.
		new E02StaticBlockMain();
	}
}

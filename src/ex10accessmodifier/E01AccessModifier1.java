package ex10accessmodifier;

/*
class를 정의할때는 반드시 public 이나 default(생략형)만 사용해야 한다.
private은 사용할 수 없으므로 에러가 발생한다.
 */
//private class PrivateClass1 {
//	void myFunc() {
//		System.out.println("나는 정의할 수 없는 클래스");
//	}
//}


/*
접근지정자를 생략했으므로 default 클래스로 지정된다.
이 경우 동일 패키지에서만 접근할 수 있다.
 */
class DefaultClass1 {
	void myFunc() {
		System.out.println("DefaultClass클래스의 myFunc()메소드 호출");
	}
}
/*
public 클래스는 해당 java파일을 대표하는 클래스로 파일명과 동일해야 하고
다른 패키지에서도 접근할 수 있다. public 클래스는 하나의 자바파일에 단 하나만
정의할 수 있다.
따라서 java에서는 하나의 자바파일에 하나의 클래스를 정의하는것을 권장한다.
 */
public class E01AccessModifier1 {

	//멤버변수 : 세가지의 접근지정자를 통해 선언
	private int privateVar;
	int defaultVar;
	public int publicVar;
	
	//멤버메서드 역시 세가지 접근지정자를 통해 선언
	/*
	동일 클래스 내에서는 private 멤버라 할지라도 접근이 가능하다.
	즉 동일 클래스 내에서는 접근지정자의 영향을 받지 않는다.
	 */
	
	private void privateMethod() {
		privateVar = 100;//사용가능
		System.out.println("privateMethod() 메소드 호출");
	}
	void defaultMethod() {
		privateVar = 200;//사용가능
		System.out.println("defaultMethod() 메소드 호출");
	}
	public void publicMethod() {	
		privateVar = 300;//사용가능
		System.out.println("publicMethod() 메소드 호출");
		privateMethod();//사용가능
	}
}

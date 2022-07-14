package ex10accessmodifier.sub;
/*
E01AccessModifier1 클래스와 선언된 패키지만 다르고 
모든 내용(멤버변수, 멤버메서드)이 동일하다.
 */
class DefaultClass2 {
	void myFunc() {
		System.out.println("DefaultClass클래스의 myFunc()메소드 호출");
	}

}
public class E01AccessModifier2 {

	private int privateVar;
	int defaultVar;
	public int publicVar;
	
	private void privateMethod() {
		privateVar = 400;
		System.out.println("privateMethod() 메소드 호출");
	}
	void defaultMethod() {
		privateVar = 500;
		System.out.println("defaultMethod() 메소드 호출");
	}
	public void publicMethod() {
		privateVar = 600;
		System.out.println("publicMethod() 메소드 호출");
		privateMethod();
	}
}

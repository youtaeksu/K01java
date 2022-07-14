package ex12Inheritance;

//부모클래스
public class DeParent {
	//멤버변수 : 정보은닉을 위해 private으로 정의
	private String name;
	private int age;
	//생성자 메서드
	public DeParent() {}
	public DeParent(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//getter메서드 : private 멤버를 클래스 외부로 반환할때 사용한다.
	public String getName() {
		return name;
	}
	/*
	멤버메서드 : 4가지 접근지정자를 통해 정의했음. 차후 자식 클래스에서
		접근지정자에 따라 접근가능여부를 확인할 것임.
	 */
	private void eat() {
		System.out.println("부모님이 드신다");
	}
	String sleep() {
		System.out.println("부모님이 주무신다");
		return null;
	}
	protected void walk() {
		System.out.println("부모님이 산책하신다");
	}
	public void excecise() {
		System.out.println("부모님이 운동하신다");
	}
	//정보출력용 메서드 : 단순히 멤버변수를 출력한다.
	public void printParent( ) {
		System.out.printf("성함:%s, 연세:%d", name, age);
	}
	//정적메서드 
	public static void staticMethod() {
		System.out.println("부모님의 정적메소드");
	}
}

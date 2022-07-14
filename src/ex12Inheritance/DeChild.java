package ex12Inheritance;

//자식클래스 : DeParent클래스의 기능에서 확장한다.
public class DeChild extends DeParent{

	//자식에서 확장한 멤버변수
	String stNumber;
	
	//생성자 메서드 : super를 통해 부모객체 먼저 생성
	public DeChild(String name, int age, String stNumber) {
		super(name, age);
		this.stNumber = stNumber;
	}
	
	//자식클래스에 확장한 메서드
	public void study() {
		//private멤버이므로 직접 사용할 수 없다.
		//System.out.println(Name() +"이(가) 공부한다.");
		
		//getter를 통해 접근해야 사용할 수 있다.
		System.out.println(getName() +"이(가) 공부한다.");
	}
	/*
	오버라이딩 아님
	: 부모클래스에서 private멤버로 선언하였으므로
	자식쪽에서는 보이지 않아 오버라이딩의 대상이 될수 없다.
	해당 함수는 자식쪽에서 새롭게 확장한 메서드라 봐야한다. 
	 */
	private void eat() {
		System.out.println("학생이 먹는다.");
	}
	/*
	메서드 오버라이딩의 조건
	-부모클래스에서 선언될때와 비교해서 접근범위가 동일하거나
	그 보다 넓으면 가능하다.
	-부모에서 default로 선언하면 자식에서는 default 혹은
	그보다 넓은 public으로 선언하면 오버라이딩이 가능하다.
	 */
	
	//오버라이딩 정의
	@Override
	public String sleep() { 
		System.out.println("학생이 잔다");
		return null;
	}
	/*
	메서드의 형태가 부모쪽과는 다르므로 오버라이딩이 될수없다.
	즉 이 경우는 오버로딩되어 확장한 메서드가 된다.
	 */
	public int walk(int age) {
		System.out.println("나이가 "+ age +"살인 학생이 산책한다.");
		return 0;
	}
	
	//오버라이딩 정의
	@Override
	public void excecise() {
		System.out.println("학생이 운동한다.");
	}
	
	//오버라이딩 정의
	@Override
	public void printParent() {
		/*
		super의 두가지 사용방법
		- super() : 부모클래스의 생성자를 호출한다.
		- super.멤버 : 부모의 멤버메서드 혹은 변수를 접근할때
			사용한다.
		 */
		super.printParent();
		System.out.printf(", 학번:%s\n", stNumber);
	}
	/*
	static(정적) 메서드는 오버라이딩의 대상이 될수없다.
	클래스 외부(메서드영역)에 로딩되므로 오버라이딩 되지않고
	호출할때 각 클래스명을 통해 호출해야한다.
	 */
	public static void staticMethod() {
		System.out.println("학생의 정적메소드");
	}
}

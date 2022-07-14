package ex08class;
/*
추상화(abstraction)
	: 현실세계의 사물을 클래스로 형상화 하는것을 추상화라고 한다.
	Person클래스는 "사람"의 일반적인 사항을 클래스로 추상화 하고 있다.
 */
//클래스 선언시 class 키워드를 사용한다. 첫글자는 반드시 대문자로 기술해야한다.
class Person {
	/*
	멤버변수 : 클래스에서 주로 속성(데이터)를 표현한다.
	 */
	String name = "정우성";
	int age = 47;
	String gender = "남자";
	String job = "영화배우";
	
	/*
	멤버메서드 : 클래스에서 객체의 동작(행위)를 표현한다. 클래스 외부에서
		호출할때는 객체의 참조변수를 통해서 호출한다.
		멤버변수는 멤버메서드 내에서 즉시 사용 가능하다.
	 */
	void eat() {
		/*
		넓은지역(클래스)에서 생성된 멤버변수는 좁은지역(멤버메서드)에서 
		사용할 수 있으므로 별도의 전달없이 아래와 같이 출력할 수 있다.
		 */
		System.out.printf("%s가(이) 식사를 한다\n", name);
	}
	void sleep() {
		/*
		%d : 정수를 표현하는 서식문자
		%s : 문자열을 표현
		 */
		System.out.printf("나이가 %d인 %s가(이) 잠자고 있다\n", age, name);
	}
}

public class E01PersonMain {

	public static void main(String[] args) {
		/*
		Person클래스를 통해 객체(인스턴스)를 생성한다. 생성시 할당된
		주소값을 반환하고, 좌측항에 있는 참조변수가 그 값을 할당받게 된다.
		 */
		Person person = new Person();
		
		//객체의 참조변수를 통해 멤버메서드를 호출할 수 있다.
		person.eat();
		person.sleep();
		
		//객체 생성 후 참조변수에 저장하지 않고 즉시 멤버메서드를 호출할 수 있다.
		new Person().eat();
		new Person().sleep();
	}
}

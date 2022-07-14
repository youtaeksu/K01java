package ex12Inheritance;

public class E07RideAndLoad02 {

	public static void main(String[] args) {

		//자식의 참조변수로 자식객체를 참조하는 일반적인 형식
		//err을 사용하면 콘솔에 빨간색으로 출력된다.
		System.err.println("Child형 참조변수로 Child객체 참조");
		DeChild child = new DeChild("율곡이이", 49, "00학번");
		
		/*
		오버라이딩 처리된 메서드이므로 참조변수와 상관없이
		항상 자식쪽 메서드가 호출된다.
		 */
		child.excecise();
		child.sleep();
		child.printParent();
		
		child.study();//자식에서 확장(부모에는 없음)
		child.walk();//오버로딩 - 부모쪽에 정의된 메서드
		child.walk(25);//오버로딩 - 자식쪽에 정의된 메서드
		
		/*
		정적메서드는 클래스명을 통해 호출한다. static의 기본규칙을
		따르므로 오버라이딩의 대상이 될수없다.
		 */
		DeChild.staticMethod();
		
		///////////////////////////////////////////////////
		
		/*
		부모타입의 참조변수를 통해 자식객체를 참조할 수 있다.
		상속관계가 있으므로 가능하다.
		 */
		System.err.println("Parent형 참조변수로 Child객체 참조");
		DeParent parent = new DeChild("퇴계이황", 35, "99학번");
		
		/*
		오버라이딩 처리된 메서드이므로 참조변수에 상관없이
		자식쪽 메서드가 호출된다.
		자식객체가 메모리에 생성될때 부모쪽의 메석드가 가려지기 
		때문에 참조변수의 영향을 전혀 받지 않는다.
		 */
		parent.excecise();
		parent.sleep();
		parent.printParent();
		
		/*
		부모클래스의 참조변수로 자식객체에 접근하면 부모클래스의 영역까지만
		접근할 수 있으므로 자식영역에 정의된 메서드는 호출할 수 없다.
		 */
//		parent.study(); //에러발생 (underfined method : 정의되지않음)
		parent.walk();
//		parent.walk(20); //에러발생
		
		//정적메서드는 오버라이딩 되지 않고, 클래스명으로 호출할 수 있다.
		DeParent.staticMethod();
	}
}

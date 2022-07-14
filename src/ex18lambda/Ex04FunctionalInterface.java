package ex18lambda;
/*
함수형 인터페이스
	: 람다식을 구현하기 위해서는 먼저 인터페이스를 만들고 람다식으로 구현할
	추상메서드를 선언한다. 이를 람다식을 만들기 위한 함수형 인터페이스라고 한다.
	※함수형 인터페이스에는 오직 하나의 추상메소드만 선언할 수 있다.
@FunctionalInterface
	: 함수형 인터페이스의 조건을 갖추었는지에 대한 검사를 컴파일러에게
	요청하는 역활을 한다.
 */
@FunctionalInterface
interface IKosmo4 {
	void studyLambda(String str);
	//함수형 인터페이스에는 하나의 추상메서드만 생성할 수 있다.
	//void studyLambda(String str);//에러발생됨
}

public class Ex04FunctionalInterface {

	/*
	앞서 정의한 람다식의 참조변수는 IKosmo4 타입으므로 아래와같이 매개변수로
	전달받은 후 추상메서드인 studyLambda()를 통해 호출할 수 있다.
	 */
	static void execute(IKosmo4 ko, String s) {
		/*
		main에서 선언한 람다식의 참조값을 받은 매개변수 ko
		IKosmo4 인터페이스에 정의된 추상메서드 => studyLambda(String str)
		 */
		ko.studyLambda(s);
	}
	
	public static void main(String[] args) {
		/*
		IKosmo4 인터페이스를 구현하여 람다식을 생성한다.
		추상메서드를 통해 매개변수의 타입을 유추할수 있어 아래와같이 생략되었다.
		 */
		IKosmo4 kosmo = (str) ->
		System.out.println("IKosmo4를 구현받아 정의한 람다입니다."+str);
		
		/*
		앞에서 정의한 람다식을 메서드의 인수로 전달한다.
		이때 람다식 자체가 전달되는것이 아니라 참조값만 전달된다.
		통해 우리는 람다식의 기능을 사용할 수 있다.
		*/
		execute(kosmo, "\n람다를 매개변수로 전달합니다.");
	}

}
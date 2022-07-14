package ex05method;

/*
Method(메서드, 함수)
	: 객체지향 프로그램에서 행동 또는 동작을 의미한다.
	즉 어떤 하나의 업무를 처리하는 모듈(부속품)이라 정의할 수 있다.
	
규칙
	-메서드는 반드시 class안에 정의해야한다.
	-메서드안에 또 다른 메서드를 정의할 수 없다.
	-반환타입이 없다면 반드시 void를 명시해야한다.
	-이름의 규칙은 변수명과 동일하다. ( 예 : addCalculate())

java에서의 NamingRule(이름규칙)
	-클래스명 : SimpleFunc => 대문자로 시작하는 Camel casd
	-메서드 혹은 변수명 : simpleFunc() 혹은 simpleFunc
			=> 소문자로 시작하는 변형된 Camel Case
	-상수명 : SIMPLE_FUNC => 전체를 대문자로 작성하고 연결단어는 _(언더바)로 표현
	-패키지명 : simple.func => 전체를 소문자로 작성하고 연결단어는.(닷)으로 표현
 
메서드형태1] 매개변수도 없고 반환값도 없는 경우
	: 둘 다 없는 형태의 메서드는 주로 메뉴를 출력하거나 하는
	단순 출력 기능 정도로 사용된다.
 */
public class E02MethodType01 {

	//반환타입, 매개변수 둘다 없는 형태의 메서드 정의
	static void noParamNoReturn() {
		System.out.println("==메뉴를 선택하세욤==");
		System.out.println("1.열기, 2.계속하기, 3.종료");
		System.out.println("=====================");
	}
	/*
	필요에 따라 실행부가 없는 메서드를 정의하는 경우가 있다.
	(차후 추상클래스 에서 설명 예정)
	 */
	static void noParamNoReturn2() {	
	}
	/*
	동일한 이름의 메서드를 정의하였으나 매개변수의 갯수를 통해 호출할 대상을
	구분할 수 있으므로 다른 함수라 생각하면 된다.
	이와 같은 문법을 "메서드 오버로딩"이라고 한다
	 */
	static void noParamNoReturn2(int a) {
	
	}
	static void noParamNoReturn3() {
		
		int returnValue = 89;
		System.out.println("[Return문 이전]");
		
		//return; //에러발생
		
		/*
		위와 같이 메서드 중간에 return을 기술하면 함수가 즉시 종료되므로
		그 아래 코드는 실행되지 않는 쓰레기코드가 된다.
		따라서 return을 사용할때는 반드시 조건문과 함께 써야한다. 단, 메서드의
		마지막 라인에 있다면 조건문은 없어도 된다.
		 */
		if(returnValue%2==0) {
			System.out.println(returnValue +"는 짝수");
			return;
		}
		
		System.out.println(returnValue +"는 홀수");
		System.out.println("[return문 이후]");
	}
	
	public static void main(String[] args) {
			//메서드 호출시에는 원형을 그대로 사용하면 된다.
			noParamNoReturn();
			noParamNoReturn2();
			noParamNoReturn3();
	}
}



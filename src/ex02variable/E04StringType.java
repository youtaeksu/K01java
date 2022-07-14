package ex02variable;

public class E04StringType {

	public static void main(String[] args) {

		/*
		String 클래스 : 참조형 변수로써 기본자료형이 아닌 클래스이다.
			문자열을 저장할 수 있는 자로형으로 주로 사용된다.
			자바에서는 문자열을 표현할때 " 으로 감싸주면 되고, 연결할때는
			+ 기호를 사용한다.
		 */
		int number;
		number = 99;
		
		/*
		참조형변수와 기본자료형 변수 사이에서는 형변환이 불가능하다.
		서로 사용하는 메모리 공간이 다르기 때문이다.
		-기본자료형 : 스텍(Stack)영역을 사용함
		-참조형(클래스)변수 : 힙(Heap)영역을 사용함
		 */
		//int stringNumber1 = (int)"100"; -> 에러발생
		//String stringNumber2 = (String)100; -> 에러발생
		
		String strNumber = "100";
		System.out.println(strNumber + number);
		
		//String은 클래스이므로 new키워드를 이용해서 객체를 생성한다.
		String newString = new String("new 키워드 사용");
		System.out.println(newString);
		
		//문자열 + 문자열 => 문자열 형태로 연결된다.
		String stringBasic = "클래스지만";
		String plusString = "기본자료형처럼 사용";
		System.out.println(stringBasic + " " + plusString);
		
		/*
		문자열 + 정수 : 우선순위가 없다면 일반적으로 문자로 출력된다.
			단, 산술연산의 결과를 출력하고 싶다면 아래와 같이 소괄호로 
			묶어 우선순위에 대한 변화를 주면된다.
		 */
		int kor=100, eng=99, math=98;
		System.out.println("총점:"+kor+eng+math);
		System.out.println("총점:"+(kor+eng+math));
				
	}

}

package ex07string;

public class E01StringBasic {
	
	public static void main(String[] args) {
		
		/*
		기본자료형의 경우 비교연산자 ==을 통해 값에 대한 비교를 한다.
		 */
		int num1=10, num2=20;
		String numResult = (num1==num2) ? "데이터가같다" : "데이터가다르다";
		System.out.println("비교결과:"+ numResult);
		
		/*
		String클래스의 객체 생성 방법1
			: new를 이용한다. new를 통해 문자열 객체를 생성하면 동일한
			문자열이라도 항상 새로운 메모리가 할당된다.
		 */
		String str1 = new String("Hello JAVA");
		String str2 = new String("Hello JAVA");
		
		/*
		str1, str2는 String객체의 참조값을 가지고 있으므로 아래의 비교는
		단순한 참조값(주소값)에 대한 비교를 하게된다. 2개의 객체는 따로
		생성되므로 참조주소는 다르다는 결과가 출력된다.
		 */
		if(str1==str2) {
			System.out.println("str1과 str2는 참조주소 같음");
		}
		else {
			System.out.println("str1과 str2는 참조주소 다름");//여기출력됨
		}
		
		/*
		equals() 메서드
			: Object클래스로부터 상속받은 메서드로 실제 저장된 문자열을
			비교하도록 만들어진 메서드이다. 즉 아래는 객체에 저장된 실제
			문자열에 대한 비교가 이루어진다. 
		 */
		if(str1.equals(str2)) {
			System.out.println("두 문자열은 동일하다");
		}
		else {
			System.out.println("두 문자열은 다르다");
		}
		
		/*
		String 클래스의 객체 생성 방법2
			: "(더블쿼테이션)을 사용한다. 이 경우 내용이 동일하다면 같은 
			주소를 사용하게 된다. 즉 새로운 객체를 생성하지 않는다.
			따라서 String객체는 주로 방법2를 이용하는것이 좋다.
		 */
		String str3 = "KOSMO";
		String str4 = "KOSMO";
		
		//내용이 동일하므로 true가 출력됨
		System.out.println("equals()메소드로 문자열비교:"+
				str3.equals(str4));
		
		//하나의 메모리를 공유하므로 같다는 결과가 출력된다.
		if(str3==str4) {
			System.out.println("주소가 같다");
		}
		else {
			System.out.println("주소가 다르다");
		}
		
	System.out.println("The..End..!!");
	
	}
}

package bokang;

import java.util.Scanner;

public class R01if {

	public static void main(String[] args) {

		int num1 = 100;
		int num2 = 200;
		
		/*
		if문 : 조건식이 참일때 블럭을 수행하는 구조를 가지고있다.
			조건식은 true/false를 반환하는 형태로 기술되어야 한다.
		 */
		
		/*
		if문 단독으로 사용하는 경우 : 조건이 true일때 if문의 블럭으로
			진입하여 문장을 실행한다.
		 */
		if(num1<num2) {
			System.out.println("num1이 num2보다 작다.");
		}
	
		//위 문장을 if~else문으로 변경하면...
		if(num1>num2) {
			//조건식이 true일때 해당 문장 실행
			System.out.println("num1이 num2보다 크다.");
		}
		else {
			//조건식이 false일때 else블럭의 문장 실행
			System.out.println("num2가 num1보다 크다.");
		}
		
		/*
		만약 2개 이상의 조건을 사용하고 싶다면 아래와 같이 else구문에는
		조건을 추가할 수 없다. 조건은 항상 if문의 블럭에 추가해야 한다.
		 */
//		if(num1>num2) {
//			System.out.println("num1이 num2보다 크다.");
//		}
//		else (num1<num2) { <== 에러발생됨
//			System.out.println("num2가 num1보다 크다.");
//		}	

		/*
		시나리오] 점수가 90점 이상이면 A학점, 
			80점 이상이면 B학점
			나머지는 F학점을 출력하는 프로그램을 작성하시오.
			
		※ 조건식은 항상 if문 뒤에 들어가야 한다.
		※ 이와같은 점수의 구간을 조건으로 만들때에는 논리연산자를 사용하여
		명확한 구간을 만들어주는게 좋다.
		 */
		int jumsu = 85;
		if(jumsu>=90) {
			System.out.println("A학점");
		}
		else if(jumsu<90 && jumsu>=80) {
			System.out.println("B학점");
		}
		else {
			System.out.println("F학점");
		}
		
		///////////////////////////////////////////////////////////////
		/*
		switch문
			: if문과 같은 조건문이지만 다른점은 if문은 조건식을 사용하지만
			switch문은 산술식, 문자열을 사용해야한다.
		 */
		/*
		시나리오] 월에 해당하는 1~12까의 숫자를 입력받아서 
			어떤 계절인지 판단하는 switch문을 작성하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("월을 입력하세요:");
		int month = scanner.nextInt();
		switch (month) {
		case 3: case 4:
			System.out.println("봄입니다.");
			/*
			switch문에서 break를 만나면 문장을 탈출한다. 하지만 break가
			없다면 문장의 끝까지 실행된다. switch문은 if문과 같은 {} 중괄호
			블럭이 없으므로 break문을 적절히 사용해야 한다.
			 */
			break;
		/*
		if문의 or(||)와 같은 형식으로 기술하고 싶다면 아래와 같이
		여러개의 case문을 묶어줄 수 있다.	
		 */
		case 5: case 6: case 7: case 8: case 9:
			System.out.println("여름입니다.");
			break;
		case 10: case 11:
			System.out.println("가을입니다.");
			break;
		/*
		위에서 정의한 3블럭의 case문으로 가을까지의 계정을 판단하였으므로
		나머지는 별도의 case문이 없어도 겨울로 판단할수 있다.
		따라서 else문과 동일한 역활의 default문을 사용하는것도 좋다. 
		 */
		//case 12: case 1: case 2:
		default:
			System.out.println("겨울입니다.");
			/*
			마지막 부분에는 더이상 실행할 문장이 없으므로 break는
			사용하지 않는것을 궈장한다.
			 */
			//break;
		}
	}
}

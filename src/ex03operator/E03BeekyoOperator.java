package ex03operator;

public class E03BeekyoOperator {

	/*
	비교연산자 : 좌우측항의 값이 크거나, 길거나 한지를
		비교하는 연산자.
	 */
	public static void main(String[] args) {

		int num1=10, num2=20;
		
		/*
		num1이 클때 true를 반환하므로, 조건은 false를 반환한다.
		따라서 else문 블럭이 실행된다.
		 */
		if(num1 > num2) {
			System.out.println("num1이 더 큽니다.");
		}
		else {
			System.out.println("num2가 더 큽니다.");
		}
		
		/*
		num1과 num2가 다를때 true를 반환하므로, 아래는 if문의 블럭이
		실행된다.
		 */
		if(num1!=num2) {
			System.out.println("num1과 num2는 다르다.");
		}
		else {
			System.out.println("num1과 num2는 같다.");
		}
	}

}

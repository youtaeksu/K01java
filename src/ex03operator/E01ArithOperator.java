package ex03operator;

public class E01ArithOperator {

	/*
	산술연산자
		: 사칙연산에 관련된 +, - 등의 연산자가 있다.
		단, 나누기를 할때는 / 는 몫을, % 는 나머지를 구하게 된다.
	 */
	public static void main(String[] args) {

		int num1 = 7;
		int num2 = 3;
		
		System.out.println("덧셈:"+(num1+num2)); //10
		System.out.println("뺄셈:"+(num1-num2)); //4
		System.out.println("곱셈:"+(num1*num2)); //21
		System.out.println("나눗셈(몫):"+(num1/num2)); //2
		System.out.println("나눗셈(나머지):"+(num1%num2)); // 1
		
		int result = 3 * 2 + 5 % 2 - 6 / 3 * 5;
		System.out.println("결과는?"+ result); //-3
	}

}

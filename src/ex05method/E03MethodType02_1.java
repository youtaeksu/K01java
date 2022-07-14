package ex05method;

/*
메서드형태2] 매개변수는 없지만 반환값은 있는 경우
	: 사용자로 부터 입력값을 받은 후 연산을 진행하고, 결괏값을
	반환하는 형태의 기능이 필요할때 사용한다.
	즉 값을 자체적으로 생산한다. 난수 생성 등에 적합하다.
 */
public class E03MethodType02_1 {
	
	//1~10까지의 합을 구하는 수열 메서드
	static int noParamYesReturn() {
		int sum = 0;
		for (int i=1 ; i<=10 ; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		/*
		반환값이 있는 메서드는 주로 print()문 안이나, 변수의 할당을
		위해 코드의 우측에서 호출된다.
		 */
		System.out.println("1~10까지의합:"+ noParamYesReturn());
		
		int sum10 = noParamYesReturn();
		System.out.printf("1에서10까지의합은 %d입니다", sum10);
		
	}

}

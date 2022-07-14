package ex05method;

/*
메서드형태3] 매개변수는 있으나 반환값이 없는 경우
	: 값을 전달받은 후 연산하고 해당 결과를 반환하지 않고
	즉시 출력하는 경우에 주로 사용
 */
import java.util.Scanner;

public class E04MethodType03_1 {
/*
 시나리오] 사용자가 입력한 2개의 시작값과 끝값사이에 있는
 수를 모두 더하여 출력하는 프로그램을 작성하시오.
 	출력결과]
 		시작값 : 5
 		종료값 : 9
 		결과 : 5+6+7+8+9=???
 */
	public static void main(String[] args) {
		
		//스캐너 클래스를 통해 2개의 정수를 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작값:");
		int s = scanner.nextInt();
		System.out.print("종료값:");
		int e = scanner.nextInt();
		//앞에서 입력받은 2개의 정수를 인수(argument)로 전달한다.
		yesParamNoReturn(s, e);
	}
	/*
	main()메서드에서 2개의 정수를 입력받은후 인수로 전달하면,
	해당 함수에서는 매개변수 startNum, endNum이 그 값을 받게된다.
	매개변수는 해당 함수에서 즉시 사용할 수 있다.
	 */
	 static void yesParamNoReturn(int startNum, int endNum) {
		/*
		 1에서 10까지의 합을 구하는 프로그램의 시작과 종료값만 변수로
		 변경하여, 원하는 구간의 합을 구하는 프로그램으로 커스터마이징 함.
		 */
		int sum = 0;
		for(int i=startNum ; i<=endNum ; i++) {
			sum += i;
		}
		System.out.printf("%d~%d까지의합은:%d", startNum, endNum, sum);
	}
	
}

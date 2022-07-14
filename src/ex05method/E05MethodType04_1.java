package ex05method;

import java.util.Scanner;
/*
 메서드형식4] 매개변수도 있고 반환값도 있는 형식으로
 	4가지 형식중 가장 많이 사용되는 형태의 메서드이다.
 */
public class E05MethodType04_1 {
	/*
	시나리오] 인원수를 매개변수로 전달받아 인원수 만큼 나이를
	입력받아 그 나이의 합을 반환하는 메소드를 작성하시오.
	 */
	public static void main(String[] args) {
		//3명의 나이를 입력 받은 후 합을 반환받을 거임.
		int sumOfAge = getTotalAge(5);
		System.out.println("입력받은 나이의 합은?"+sumOfAge);
	}//end of main
	
	static int getTotalAge(int personCnt) {
		
		Scanner scanner = new Scanner(System.in);
		//나이의 합을 저장할 변수
		int sumAge = 0;
		//main메서드에서 전달해준 인수의 값만큼 반복하여 나이를 입력받음.
		for(int i=1 ; i<=personCnt ; i++) {
			System.out.print(i+"번째 사람의 나이:");
			int age = scanner.nextInt();
			//입력받은 나이는 sumAge에 누적해서 더해진다.
			sumAge += age;
		}
		//나이의 합을 호출한 지점으로 반환한다.
		return sumAge;
	}// end of getTotalAge

}//end of class

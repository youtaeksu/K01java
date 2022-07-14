package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02PreDefineException3 {

	public static void main(String[] args) {

		System.out.println("### InputMismatchException ###");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이를 입력하세요:");
			/*
			nextInt()를 통해 정수값을 입력받아야 하는데 문자를 입력하는경우
			발생되는 예외가 발생된다.
			 */
			int intAge = sc.nextInt();
			int ageAfter10 = intAge + 10;
			System.out.println("당신의 10년후 나이는:"+ ageAfter10);
		}
		catch(InputMismatchException e) {
			System.out.println("나이를 문자형태로 입력하면 앙데요.");
			System.out.println("예외메세지:"+ e.getMessage());
			e.printStackTrace();
		}
	}////end of main
}
package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
사용자정의 예외클래스
1.Exception 클래스를 상속한다.
2.생성자에서 예외발생시 출력할 메세지를 super()를 통해 입력한다.
3.예외 발생지점에서 if문으로 감지한 후 예외객체를 생성 및 throw한다.
4.catch문에서 예외객체를 받아 예외처리한다.
 */
class AgeErrorException2 extends Exception {
	public AgeErrorException2() {
		super("나이 입력이 개잘못 되었어요");
	}
}

public class Ex06DeveloperDefine2 {

	public static void main(String[] args) {

		System.out.println("나이를 입력하세요 : ");
		
			int age = readAge();
			System.out.println("당신의 나이는 " + age + " 입니다.");
	}

	public static int readAge() {
		Scanner sc = new Scanner(System.in);
		int inputAge = 0;
		try {
			//나이 입력시 문자를 잘못 입력하는 경우 예외처리를 하고있다.
			//Java에서 미리 정의된 클래스를 사용한다.
			inputAge = sc.nextInt();
		} 
		catch (InputMismatchException e) {
			e.printStackTrace();
			//프로그램 자체 종료
			System.exit(0);
		}
		/*
		개발자 정의 예외객체를 던지면(throw) 해당 지점에서 즉시 try~catch로 묶어
		예외처리한다.
		 */
		try {
			if (inputAge < 0) {
				AgeErrorException2 ex = new AgeErrorException2();
				/*
				throw 하면 반드시 catch해야 한다. 그렇지 않으면 프로그램이 종료된다.
				 */
				throw ex;
			}	
		}
		catch (AgeErrorException2 e) {
			System.out.println(e.getMessage());
		}
		return inputAge;
	}
}

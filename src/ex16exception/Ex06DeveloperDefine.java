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
class AgeErrorException extends Exception {
	public AgeErrorException() {
		super("나이 입력이 개잘못 되었어요");
	}
}

public class Ex06DeveloperDefine {

	public static void main(String[] args) {

		System.out.println("나이를 입력하세요 : ");
		try {
			/*
			아래 메서드에서 AgeErrorException2 예외객체를 throw하면
			여기에서 예외처리한다.
			 */
			int age = readAge();
			System.out.println("당신의 나이는 " + age + " 입니다.");
		} catch (AgeErrorException e) {
			System.out.println("[예외발생]" + e.getMessage());
		}
	}

	public static int readAge() throws AgeErrorException {
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
		만약 나이가 음수로 입력되면 JVM이 감지하지 못하므로 이때는
		if를 통해 감지한 후 개발자정의 예외객체를 생성하여 직접 throw한다.
		 */
		if (inputAge < 0) {
			AgeErrorException ex = new AgeErrorException();
			/*
			throw 하면 반드시 catch해야 한다. 그렇지 않으면 프로그램이 종료된다.
			 */
			throw ex;
		}
		return inputAge;
	}
}

package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
finally절
	: 예외발생과 상관없이 try문으로 진입했을때 반드시 실행해야 할 코드가
	있는경우 기술하는 블럭이다.
	즉 try문으로 진입되지 않는다면 finally절은 실행되지 않는다.
1.	try~catch : 예외를 직접 처리할때
2.	try~catch~finally : 예외를 직접 처리후 실행할 문장이 있을때
3.	try~finally : 예외는 외부로 던지고 예외발생과 상관없이 실행할 문장이 있을때
 */
public class Ex05Finally {

	//런타임 에러가 발생되는 메서드로 예외가 발생하면 예외던지기를 한다.
	static void runtime() throws NumberFormatException {
		//문자열은 정수로 변환할 수 없으므로 예외발생됨.
		Integer.parseInt("백");
	}
	static void tryCatchFinally() {
		Scanner scan = new Scanner(System.in);
		System.out.print("나이를 입력하세요:");
		int age = -1;
		try {
			age = scan.nextInt(); //30살과 입력하면 예외발생
			System.out.println("당신은 5년후 "+ (age+5) +"살 입니다.");
			
			return;//try문에서 return을 만나도 finally절은 실행된다.
		}
		catch(InputMismatchException e) {
			System.out.println("나이는 숫자만 쓰세요");
		}
		finally {
			/*
			try절에서 예외가 발행하더라도 혹은 return을 만나게 되어도
			finally절은 실행된다.
			 */
			System.out.println("항상 실행되는 finally절 입니다.");
			/*
			exit(0)는 프로그램의 실행 자체를 종료하는 명령어이므로 
			finally절은 실행되지 않는다.
			 */
			System.exit(0);
		}
	}
		
	public static void main(String[] args) {
		try {
			runtime();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		tryCatchFinally();
		/*
		finally절에서 exit(0)을 실행하므로 아래문장은 실행되지 않는다.
		 */
		
		System.out.println("메인메소드 끝");
	}

}

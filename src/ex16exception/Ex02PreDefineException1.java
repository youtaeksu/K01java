package ex16exception;

public class Ex02PreDefineException1 {

	public static void main(String[] args) {

		System.out.println("### ArrayIndexOutOfBoundsException ###");
		//크기가 2인 배열을 선언
		int[] intArr = new int[2];
		/*
		예외가 발생할수 있는 지역을 try문으로 먼저 묶어준다.
		예외가 발생되면 JVM(자바가상머신)은 해당 예외에 관련된 객체를 만들어
		프로그램쪽으로 전달한다. 이때 catch절에서 예외객체를 잡아주는것을
		예외처리라고 한다.
		만약 예외객체를 잡아주지 못하면 프로그램은 비정상적인 종료로 이어지게된다.
		 */
		try {
			intArr[0] = 100;
			System.out.println("0번방은:"+ intArr[0]);
			intArr[1] = 200;
			System.out.println("1번방은:"+ intArr[1]);
			intArr[2] = 300;
			//예외가 발생되는 지점
			//자바가상머신이 예외객체를 생성해서 프로그램으로 던진다(throw)
			System.out.println("앗~이방은:"+ intArr[2]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			//JVM이 throw한 예외객체를 catch절에서 잡아서 처리한다.
			//그러면 예외가 발생되어도 프로그램의 실행은 유지된다.
			
			//예외메세지1 : 개발자가 임의로 메세지를 출력한다.
			System.out.println("예외가 발생했어요");
			//예외메세지2 : 간략한 설명을 출력한다.
			System.out.println("예외메세지:"+ e.getMessage());
			//예외메세지3 : 예외에 대한 디테일한 설명이 출력된다.(가장 많이 사용됨)
			e.printStackTrace();
		}
		
		//예외처리를 통해 실행의 흐름이 중단되지 않으므로 아래 문장이 출력된다.
		System.out.println("0번방 재출력:"+ intArr[0]);
		System.out.println("### ArrayIndexOutOfBoundsException발생후 ###");
	
	}////end of main
}

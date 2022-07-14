package ex05method;

import java.util.Scanner;

public class E03MethodType02_2 {

	/*
	Java에서 main()은 항상 public static void로 선언해야 한다.
	또한 static으로 선언된 메서드에서 호출되는 메서드는 무조건 static을 붙여야한다.
	public의 경우 현 상태에서는 있어도 없어도 별다른 차이가 없다.
	 */
	static String getHakjum() {
		
		//사용자로부터 입력값을 받기위해 객체변수 생성
		Scanner scanner = new Scanner(System.in);
		//각 과목의 점수를 정수형태로 입력받음
		System.out.printf("국어점수:");
		int kor = scanner.nextInt();
		System.out.printf("영어점수:");
		int eng = scanner.nextInt();
		System.out.printf("수학점수:");
		int math = scanner.nextInt();
		//평균값을 구함
		double avg = (kor + eng + math) / 3.0;
		String hakjum = "";
		//평균값을 통해 학점의 구간을 정하기 위해 10으로 나눠서 몫을 구함
		int result = (int)avg / 10;
		//case 8인경우 80~89점 사이가 된다. (나머지도 동일함)
		switch (result) {
		case 10: case 9:
			hakjum = "A학점";break;
		case 8: 
			hakjum = "B학점";break;
		case 7:
			hakjum = "C학점";break;
		case 6: 
			hakjum = "D학점";break;
		default:
			hakjum = "F학점";
		}
		/*
		결과값을 반환하면 해당 메서드는 메모리에서 소멸된 후
		호출한 지점으로 값이 반환된다.
		*/
		return hakjum;
	}
	
	public static void main(String[] args) {
		/*
		시나리오] 사용자로부터 국,영,수 점수를 입력받아 평균을 구
		한후 학점을 반환하는 메소드를 정의하시오.
		 */
		System.out.println("너의 학점은 "+ getHakjum() +" 이얌~!");
		
		String h = getHakjum();
		System.out.printf("당신의 학점은 %s 입니다.", h);
		
	}////end of main
	
}////end of class

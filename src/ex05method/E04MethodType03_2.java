package ex05method;

import java.util.Scanner;

/*
연습문제] 사용자로부터 2~9사이의 숫자중 2개를 입력받아
그에 해당하는 구구단을 출력하는 메서드를 작성하시오.
무조건 첫번째 입력받는수가 작아야한다.
입력예]
	첫번째숫자 : 3
	두번째숫자 : 12
	3*1=3 3*2=6........
	........
	...................12*9=108
메서드명 : inputGugudan(int sNum, int eNum)
*/

public class E04MethodType03_2 {

	public static void main(String[] args) {
		
		//1.2개의 숫자를 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작단:");
		int startNum = scanner.nextInt();
		System.out.print("종료단:");
		int endNum = scanner.nextInt();
		
		//2.inputGugudan()을 호출함
		/*
		시작단이 종료단보다 항상 작아야 하지만, 만약 위치가 변경되었다면
		아래와 같이 순서를 변경해서 호출해준다.
		 */
		if(startNum<endNum)
			inputGugudan(startNum, endNum);
		else
		inputGugudan(endNum, startNum);
	}
	//3.구구단을 출력하는 프로그램 작성
	static void inputGugudan(int sNum, int eNum) {
		//2단에서 9단까지 반복하는 for문 작성
		//for(int dan=2 ; dan<=9 ; dan++) {
		//즉, 앞에서 구현한 for문을 아래와 같이 변경하여 커스터마이징 한다.
		for(int dan=sNum ; dan<=eNum ; dan++) {
			//하나의 단이 고정된 상태에서 수는 1~9까지 증가하는 for문 작성
			for(int su=1 ; su<=9 ; su++) {
				System.out.printf("%d*%d=%d ", dan, su, (dan*su));
			}
			System.out.println();
		}
	}
}

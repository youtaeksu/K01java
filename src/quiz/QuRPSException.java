package quiz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/*
가위바위보 게임에 다음 조건에 맞는 예외처리 구문을 추가하시오
숫자대신 문자를 입력할 경우 발생되는 예외를 처리하시오. (가위바위보 입력시, 재시작여부 입력시)
게임과 관련없는 숫자를 입력했을때 사용자정의 예외클래스를 통해 처리하시오.
예외처리 클래스명 : WrongNumberException

 */

class WrongNumberException extends Exception {
	public WrongNumberException() {
		super("[예외발생]숫자를 잘못 입력하셨습니다.");
	}
}
public class QuRPSException {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int gameCount = 0; 
		
		while(true) {
			//1.난수생성
			int com = random.nextInt(10000) % 3 + 1;//1~3사이의 난수
			System.out.println("컴퓨터:"+ com);
			
			//2.사용자입력
			int user = 0;
			System.out.println("가위바위보를 입력하세요.");
			System.out.print("가위(1), 바위(2), 보(3)=>");
			try {
				user = scanner.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				/*
				숫자를 입력받기 위한 nextInt()메서드를 호출한 후 문자를 입력하게 되면
				예외가 발생되고, 엔터키가 버퍼에 남게된다. 따라서 엔터키가 눌러진것처럼
				인식이 되어 무한루프가 발생되게된다. 이때 버퍼에 남은 엔터키를 제거해주면
				무한루프에서 벗어날수 있다.
				 */
				scanner.nextLine();//버퍼를 비운다.
			}
				
				
			//3.승부판단
			//사용자가 정상적으로 입력한 경우
			if(!(user<1 || user>3)) {
				//승부판단 로직1 : if문을 통해 승부를 판단한다.
				if(com==1&&user==1)	System.out.print("사용자:가위,컴퓨터:가위\n비겼습니다.\n");
				if(com==1&&user==2) System.out.print("사용자:바위,컴퓨터:가위\n이겼습니다.\n");
				if(com==1&&user==3) System.out.print("사용자:보,컴퓨터:가위\n졌습니다.\n");
				if(com==2&&user==1) System.out.print("사용자:가위,컴퓨터:바위\n졌습니다.\n");
				if(com==2&&user==2) System.out.print("사용자:바위,컴퓨터:바위\n비겼습니다.\n");
				if(com==2&&user==3) System.out.print("사용자:보,컴퓨터:바위\n이겼습니다.\n");
				if(com==3&&user==1) System.out.print("사용자:가위,컴퓨터:보\n이겼습니다.\n");
				if(com==3&&user==2) System.out.print("사용자:바위,컴퓨터:보\n졌습니다.\n");
				if(com==3&&user==3) System.out.print("사용자:보,컴퓨터:보\n비겼습니다.\n");
				
				gameCount++;//게임카운트 증가		
			}
			else {
				try {
				//System.out.println("가위바위보 할줄 몰라요?? 제대로 내세요 ㅋ");
				WrongNumberException wne = new WrongNumberException();
				throw wne;
			}
			catch (WrongNumberException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
			//4.게임재시작 여부 확인			 
			if(gameCount>=5) {
				//0과 1을 입력하지 않아도 게임은 재시작된다. 
				System.out.print("게임재시작(1), 종료(0):");
				int restart = scanner.nextInt();
				if(restart==0) {
					//게임종료를 위해 while루프 탈출
					break;
				}
				else {
					System.out.println("게임 재시작^^");
					gameCount=0;
				}			
			}
		}
	}
}

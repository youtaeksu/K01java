package ex05method;

import java.util.Scanner;

/*
시나리오] 여러개의 숫자를 입력받은후 최대값을 구하는
메소드를 정의하시오. 단, 숫자의 갯수는 매개변수로 전달받고
숫자의 갯수만큼 Scanner클래스를 통해 입력받는다.
입력받은 숫자중 최대값을 찾아서 반환하도록 정의한다.
 */
public class E05MethodType04_2 {

	public static void main(String[] args) {
		
		//정수 4개중에 최대값 찾기
		int maxValue1 = returnMaxNumber(4);
		System.out.println("최대값1:"+ maxValue1);
		
		//정수 6개중에 최대값 찾기
		//int maxValue2 = returnMaxNumber(6);
		System.out.println("최대값2:"+ returnMaxNumber(6));
	}
	
	//main에서 전달한 인수 4는 매개변수 numberCnt가 받아서 해당 메서드에서 사용한다.
	static int returnMaxNumber(int numberCnt) {
		
		Scanner scanner = new Scanner(System.in);
		//최대값을 저장하기 위한 변수
		int maxVal = 0;
		//매개변수로 전달된 인수만큼 반복하여 정수를 입력받는다.
		for(int i=1 ; i<=numberCnt ; i++) {
			System.out.println("정수를 입력하세요:");
			int inputNum = scanner.nextInt();
			
			if(i==1) {
				/*
				입력받은 정수 중에서 최대값을 찾아야 하므로, 첫번째 입력값을
				기준값으로 설정하기 위해 maxVal에 할당한다.
				 */
				maxVal = inputNum;
			}
			else { 
				//두번째 입력값부터는 기존의 최대값인 maxVal과 비교하여
				//새롭게 입력한 값이 크다면 maxVal을 inputNum(입력값)으로 교체한다.
				if(maxVal<inputNum) {
					maxVal = inputNum;
				}
				//maxVal 이 더 크다면 기존값을 유지하면 되므로 else는 필요없다.
			}
		}
		/*
		즉, 새로운 입력값이 기존값보다 크다면 지속적으로 교체하여
		가장 큰 값을 호출한 지점으로 반환한다.
		 */
		return maxVal;	
	}//end of returnMaxNumber
}

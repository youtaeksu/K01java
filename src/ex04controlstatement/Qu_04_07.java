package ex04controlstatement;
/*
문제2) 1~100까지의 숫자중 3의배수 이거나 7의배수인 
숫자의 합을 구하는 프로그램을 작성하시오. 
단, 3과 7의 공배수인 경우 합에서 제외해야 한다. 
출력의결과는 누적되는 모든 수를 콘솔에 print한다.
파일명 : Qu_04_07.java
실행결과]
3+6+7+~~~~~~=????
 */
public class Qu_04_07 {

	public static void main(String[] args) {
		int sum = 0;
		//100번 반복
		for(int i=1 ; i<=100 ; i++) {
			//3 혹은 7의 배수
			if(i%3==0 || i%7==0) {
				//3과 7의 공통배수는 제외
				if(i%(3*7)!=0) {
					//조건에 맞는 정수를 누적해서 더한다.
					sum += i;
					//모든 수를 콘솔에 출력한다.
					System.out.print(i);
					//출력결과 i의 마지막 값이 99
					if(i!=99) System.out.print("+");
					//(i<99)
				}
			}
		}
		//정답도 출력한다.
		System.out.print("="+ sum);
	}
}

package ex04controlstatement;
/*
문제3) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
파일명 : Qu_04_08.java
실행결과]
* * * * *
* * * *
* * *
* *
*
 */
public class Qu_04_08 {

	public static void main(String[] args) {
		
		/*
		i와 j의 크기를 통해 반복횟수를 결정한다. 
		 */
		for(int i=1 ; i<=5 ; i++) {
			for(int j=1 ; j<=5 ; j++) {
				if(i<=j) {
					/*
					i가 1이면 => j는 1~5(5번반복)
					i가 2면 => j는 2~5(4번반복)
					i가 3이면 => j는 3~5(3번반복)
					 */
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		
		System.out.println("==========");
		
		/*
		Row(행의갯수)가 정해져 있으므로 이를 통한 일반식을 생성
		: ROW가 상수로 고정되고 변수 x가 증가함에 따라 점점
		감소하는 y를 다음의 일반식을 통해 표현할 수 있다.
		
		ROW(행) - x + 1
			x가1일때 : 5 - 1 + 1 = 5
			...
			x가3일때 : 5 - 3 + 1 = 3
			...
			x가5일때 : 5 - 5 + 1 = 1
		 */
		final int ROW = 5;
		for(int x=1 ; x<=ROW ; x++) {
			for(int y=1 ; y<=(ROW-x+1) ; y++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}      



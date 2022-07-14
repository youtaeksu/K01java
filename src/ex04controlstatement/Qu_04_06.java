package ex04controlstatement;
/*
문제1) 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
파일명 : Qu_04_06.java
실행결과]
*
* *
* * *
* * * *
* * * * *
 */
public class Qu_04_06 {

	public static void main(String[] args) {
		
		//5행 반복
		int i = 1;
		while(i<=5) {
			//5열 반복. 행인 i만큼 j를 반복하면 된다.
			int j = 1;
			while(j<=i) {
				System.out.print("* ");
				j++;
			}
			i++;
			System.out.println();
		}
		
		
//		for(int x=1 ; x<=5 ; x++) {
//			for(int y=1 ; y<=5 ; y++) {
//				if(x>=y)
//					System.out.print("* ");
//			}
//			System.out.println();
//		}
	}

}

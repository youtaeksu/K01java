package bokang;

public class R03for {

	public static void main(String[] args) {
		
		/*
		for문 : 반복의 횟수가 명확할때 사용하는 반복문
			ex) 수열문제, 구구단, 배열이나 컬렉션을 다룰때
			형식]
				-일반for문
				for(초깃값 ; 조건식 ; 증감식){
					실행문장;
				}
				-확장for문(foreach문)
				for(저장된 객체의 타입 참조변수	: 배열 혹은 컬렉션 객체){
					실행문장;
				}
		 */
		//시나리오] 1~10까지의 합을 구하는 프로그램을 작성하시오. 
		int hap = 0;
		for(int i=1 ; i<=10 ; i++) {
			hap += i;
		}
		System.out.println("결과:"+ hap);
		
		/////////////////////////////////////////////////////////////////
		//시나리오] 구구단을 출력하는 프로그램을 작성하시오.
		//2단~9단까지 반복 출력
		for(int dan=2 ; dan<=9 ; dan++) {
			//숫자가 1~9까지 반복 출력
			for(int su=1 ; su<=9 ; su++) {
				System.out.printf("%d*%d=%2d ", dan, su, (dan*su)); //2d는 정렬
			}
			System.out.println();//줄바꿈
		}
		
		/*
		연습문제] 두개의 주사위를 던졌을때 눈의 합이 6이되는 경우를
			모두 출력하는 프로그램을 while문으로 작성하시오
			실행결과]
				1+5=6
				2+4=6
				.....
				5+1=6
		 */
		for(int x=1 ; x<=6 ; x++) {
			for(int y=1 ; y<=6 ; y++) {
				if(x+y==6) {
					System.out.printf("%d+%d=%d\n", x, y, (x+y));
				}
			}
		}
		
		/*
		연습문제] 방정식 2x+4y=12를 만족하는 모든 x,y값을 구하시오.
		단, x,y 의 범위는 0~10사이의 정수이고 while문을 통해 구현하시오.
		실행결과]
			x=0, y=3
			x=2, y=2
			.....
		 */
		//본인 스스로 한번 해보기.
		
		/*
		연습문제) 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의
		결과를 계산하는 프로그램을 작성하시오.
		실행결과:220
		 */
		int total = 0;
		//큰 블럭으로 10번 반복
		for(int n=1 ; n<=10 ; n++) {
			//개별적으로 n만큼 반복한다.
			for(int m=1 ; m<=n ; m++) {
				total += m;
			}
		}
		System.out.println("결과="+ total);
		
		/*
		문제1) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
		힌트) 탑을 쌓는다는 가정하에 for(i=1~5){
										for(j=i)
		*
		* *
		* * *
		* * * *
		* * * * *
		 */
		
		for(int x=1 ; x<=5 ; x++) {
			for(int y=1 ; y<=5 ; y++) {
				if(x>=y)
					System.out.print("* ");
			}
			System.out.println();
		}
		
		/*
		문제2) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
			힌트) 초기값 5로 잡고 -- 로 하는 방식
		* * * * *
		* * * *
		* * *
		* *
		*
		 */
		System.out.println("=========================================");
		
		for(int t=1 ; t<=5 ; t++) {
			for(int s=1 ; s<=5 ; s++) {
				if(t<=s)
					System.out.print("* ");
			}
			System.out.println();
		}
		
	}
}


package bokang;

import java.util.Scanner;

//굉장히 중요,,클래스에서 하나의 기능을 담당함,,
//메서드 안에 기능을 만들때가 어려움..
public class R04method {

	//매개변수와 반환값이 없는 메서드
	public static void guguPrint() {
		for(int dan=2 ; dan<=9 ; dan++) {
			for(int su=1 ; su<=dan ; su++) {
				System.out.print(dan +"*"+ su +"="+ (dan*su) +" ");
			}
			System.out.println();
		}
	}
	//매개변수는 있지만 반환값이 없는 메서드
	public static void guguRangeShow(int n1, int n2) {
		for(int i=n1 ; i<=n2 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
				System.out.println(i +"*"+ j +"="+ (i*j)+" ");
			}
			System.out.println();
		}
	}
	/*
	위 2개의 메서드는 반환값이 없으므로 return문이 필요없다.
	주로 메서드 내에서 연산결과를 즉시 출력한다.
	메서드의 실행이 종료되면 메모리에서 삭제되고 호출한 지점으로 돌아간다.
	 */

	
	public static void main(String[] args) {
		/*
		시나리오] 다음과 같은 구구단을 출력하는 메소드를 작성하시오.
			메소드명 : void guguPrint()
			주의] main메소드에서 호출하므로 정의하는 메소드는 
			반드시 static으로 선언해야 한다.
			※매개변수도 없고, 반환타입도 없는 경우
			2x1=2 2x2=4
			3x1=3 3x2=6  3x3=9
			4x1=4 4x2=8  4x3=12 4x4=16
			5x1=5 5x2=10 5x3=15 5x4=20 5x5=25
			6x1=6 6x2=12 6x3=18 6x4=24 6x5=30 6x6=36
			7x1=7 7x2=14 7x3=21 7x4=28 7x5=35 7x6=42 7x7=49
			8x1=8 8x2=16 8x3=24 8x4=32 8x5=40 8x6=48 8x7=56 8x8=64
			9x1=9 9x2=18 9x3=27 9x4=36 9x5=45 9x6=54 9x7=63 9x8=72 9x9=81			
		 */
		System.out.println("매개변수X, 반환값X");
		guguPrint();//함수(위치는 상관없음.. 클래스 안에만 있으면됨)
		
		/*
		연습문제]매개변수로 2개의 정수를 전달하여 해당 범위의 
			구구단을 출력하는 메소드를 작성하시오.
			만약 2, 5가 전달된다면 2단, 3단, 4단, 5단만 출력된다.
			메소드명 : guguRangeShow(int n1, int n2)
			※매개변수는 있고, 반환타입은 없는 메소드
		 */
		System.out.println("매개변수O, 반환값X");
		guguRangeShow(2, 5);//반환값이 없었기 때문에 return문장이 필요없었음.
		
		/*
		시나리오] sungjukResult() 메소드를 호출하면 국어,영어,수학
		점수를 입력받은후 평균값을 반환하도록 구현하시오.
		※매개변수X, 반환값O
		 */
		System.out.println("매개변수X, 반환값O");
		/*
		반환값이 있는 메서드는 주로 print()문 내부나, 반환값을 저장할
		좌측항의 변수가 있는것이 대부분이다.
		 */
		System.out.println("평균값은:"+sungjukResult());
		
		/*
		시나리오] 정수 하나를 매개변수로 전달하면 1부터 해당 매개변수
		까지의 합을 구하여 결과값을 반환하는 메소드를 작성하시오.
		메소드명 : numberPlus(int endNum) 
		※매개변수O, 반환값O
		 */
		System.out.println("매개변수O, 반환값O");
		int tot = numberPlus(100);
		System.out.println("1부터 100까지의 합은"+ tot);
	
	}
	/*
	매개변수는 없지만 반환값이 있는 메서드
	이런 경우 연산후 어떤 겨과가 나올지를 예상하여 반환타입을 결정해야한다.
	단순히 정수끼리의 연산이라면 int형이 되고, 해당 문제처럼 평균값을 구하는 문제는
	나눗셈의 결과가 나와야 하므로 double형으로 선언하는것이 안전하다.
	 */
	public static double sungjukResult() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("국어점수입력:");
		int kor = scanner.nextInt();
		System.out.println("영어점수입력:");
		int eng = scanner.nextInt();
		System.out.println("수학점수입력:");
		int math = scanner.nextInt();
		
		//평균을 구할때 3으로 나누면 int형이 되므로 3.0으로 나눠준다.
		double avg = (kor+eng+math) / 3.0;
		//값을 반환할때는 return을 사용한다.
		return avg;
	}
	
	public static int numberPlus(int num) {//num은 숫자
		int sum = 0;
		for(int i=1 ; i<=num ; i++) {
			sum += i;
		}
		return sum;
		
	}
	
	
}


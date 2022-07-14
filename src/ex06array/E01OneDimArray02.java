package ex06array;

import java.util.Random;

public class E01OneDimArray02 {

	public static void main(String[] args) {

		/*
		난수 생성 방법1
			Math.random()은 0~1사이의 실수를 랜덤하게 반환하는 메서드로
			정수형태의 난수를 생성할때는 100을 곱해주면 된다.
		 */
		double rndNumber = Math.random();
		System.out.println("생성된난수[실수]:"+ rndNumber);
		// (int)(실수 * 정수) => (int)(double형의경과) => 강제형변환을 통해 int형의 결과
		int intnumber = (int)(Math.random()*100);
		System.out.println("생성된난수[정수]:"+intnumber);
		
		/*
		난수 생성 방법2
			: Random 클래스를 사용한다. 사용법은 scanner와 동일하게 nextInt()메서드를
			사용하면 정수형 난수를 생성할 수 있다.
		 */
		Random random = new Random();
		System.out.println("생성된난수:"+ random.nextInt());//음수, 양수의 정수가 생성됨
		System.out.println("==============================");
		
		/*
		로또번호처럼 1~45사이의 난수를 생성하는 방법
		1. 0.xxxx형태의 난수를 생성한 후 정수로 변경하기 위해 100을 곱한다.
		2. 45로 %연산하여 나머지를 구한다. 모든 정수는 45로 나누면 나머지가
			0~44까지만 나오게 된다.
		3. 0은 구간에 포함되면 안되므로 2번의 결과에 1을 더한다.
			결과적으로 1~45사이의 난수를 생성할 수 있다.
		4. 마지막에 정수의 결과를 얻기위해 int로 강제 형변환 한다.
		 */
		System.out.println("1~45사이의 난수생성:"+
				((int)((Math.random()*100) % 45)+1) );
		
		System.out.println("===============================");
		
		System.out.println("크기가 6인 배열에 난수 입력");
		int[] lottoNum = new int[6];
		//배열의 크기만큼 반복해서 난수생성
		for(int i=0 ; i<lottoNum.length ; i++) {
			//증가하는 i값을 인덱스로 사용해서 초기화
			lottoNum[i] = (int)((Math.random()*100) % 45) +1;
		}
		//배열 전체 출력
		for(int i=0 ; i<lottoNum.length ; i++) {
			System.out.printf("%d ", lottoNum[i]);
		}
		
	}

}

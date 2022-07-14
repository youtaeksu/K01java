package ex02variable;
/*
문제2] 파일명 : Qu02Average.java
국어,영어,수학 점수를 99, 80, 96점으로 입력하고 
평균점수를 구해서 출력하는 프로그램을 작성하시오.
 */
public class Qu02Average {

	public static void main(String[] args) {

		int kor=99, eng=80, math=96;
		double avg = (kor+eng+math) / 3.0;
		int avg2 = (kor+eng+math) / 3;
		System.out.println("평균점수:"+ avg);
		//System.out.printf("평균점수:%.0f\n", avg);	
		System.out.println("평균점수:"+ avg2);
	}

}

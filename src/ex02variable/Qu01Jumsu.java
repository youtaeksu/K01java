package ex02variable;
/*
문제1] 파일명 : Qu01Jumsu.java
1.국어, 영어, 수학점수 및 과목의 총점을 저장할수 있는 변수를 선언하시오.
2.국어 89점, 영어 99점, 수학 78점을 대입한다.
3.국영수 총합을 구해서 총점을 저장할 변수에 대입한다.
4.총합점수를 출력한다.
 */
public class Qu01Jumsu {

	public static void main(String[] args) {
		
		int ko=89, en=99, mat=78;
		int total = ko + en + mat;
		System.out.println("국어:"+ ko +", 영어:"+ en +", 수학:"+ mat);
		System.out.printf("국어:%d, 영어:%d, 수학:%d%n", ko, en, mat);
		System.out.println("총점:"+total);
		System.out.printf("총점:%d", total);
		
	}

}

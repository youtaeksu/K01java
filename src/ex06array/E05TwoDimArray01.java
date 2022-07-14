package ex06array;

public class E05TwoDimArray01 {

	public static void main(String[] args) {

		/*
		아래와 같이 2차원배열을 초기화하면 세로(행)3, 가로(열)4인 배열이
		생성된다. 초기화할 요소가 없는 부분은 null로 채워진다
		※null값 : 아무것도 없는 값을 읻컫는다. 즉 빈값을 말한다.
		스페이스와 같은 공백문자 혹은 0과는 다르다는 것에 주의하자.
		 */
		int[][] arr = {
				{1,2},
				{3,4,5},
				{6,7,8,9}
		};
		
		
		//1차원배열을 선언 후 0번 원소 초기화
		int[] arr2 = new int[5];
		arr2[0] = 1;
		System.out.println("arr2 배열명 출력:"+ arr2);//배열명은 주소값을 출력
		System.out.println("arr2[0] 원소 출력:"+ arr2[0]);//배열의 원소를 출력
		
		/*
		2차원 배열에서 배열명.length로 세로크기 즉 행의 크기를 알수 있다.
		 */
		System.out.println("배열의 세로크기:"+ arr.length);
		System.out.println("배열명이 가진값 출력(arr):"+ arr);//배열의 참조값 출력
			
		//각 행의 크기를 출력하기 위해 반복한다.
		for(int i=0 ; i<arr.length ; i++) {
			//2차원배열에서 행의 크기를 알고싶을때는 "배열명[인덱스]"로 기술한다.
			System.out.printf("%d행의크기:%d\n", i, arr[i].length);
			//각 행의 참조값이 출력된다.
			System.out.printf("%d행 출력:%s\n", i, arr[i]);
		}
			
		//특정 원소를 접근할때는 아래와 같이 사용한다.
		System.out.println("배열 출력하기");
		System.out.println("arr[0][1]="+arr[0][1]);//정상출력
		System.out.println("arr[0][3]="+arr[0][3]);//예외발생
		/*
		ArrayIndexOutOfBoundsException 예외가 발생한다.
		즉, 배열의 index를 초과했다는 의미이다.
		 */
	}
}

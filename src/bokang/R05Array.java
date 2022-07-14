package bokang;

import java.util.Scanner;

public class R05Array {

	public static void main(String[] args) {

		/*
		시나리오] 정수 10개를 저장할 수 있는 배열을 생성한 후 반목문을
		통해 1부터 순차적인 값을 입력하시오.
		 */
		//크기가 10인 배열 생성
		int[] arr = new int[10];
		//배열은 인덱스 0부터 시작이므로 반복문의 초깃값은 항상 0을 사용한다.
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = i+1;
		}
		//확장for문을 통해 출력
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("\n\n================================\n");
		
		/*
		시나리오] 정수 5개를 저장할 수 있는 배열을 생성한 후 숫자를 입력받아 저장한다.
			단, 숫자가 짝수일때만 저장할 수 있도록 프로그램을 작성하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		//배열의 인덱스로 사용할 변수
		int index = 0;
		int[] arr2 = new int[5];
		//몇번만에 입력이 완료될지 모르므로 무한루프를 사용한다.
		while(true) {
			System.out.println("숫자를 입력하세요:");
			int inputNum = scanner.nextInt();
			//입력받은 숫자가 짝수일때만 배열에 삽입한다.
			if(inputNum%2==0) {
				//짝수가 배열에 삽입되면 index를 +1 증가시킨다.
				arr2[index++] = inputNum;
			}
			//4번 인덱스에 삽입후 증가하므로 5일때 루프를 탈출한다.
			if(index==5) break;
		}
		//정상적으로 입력되었는지 확인한다.
		for(int a : arr2) {
			System.out.print(a+" ");
		}
	}
}

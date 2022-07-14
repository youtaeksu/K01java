package ex06array;

/*
배열 : 순차적인 메모리의 공간이 할당되는 형태로써
	하나가 아니라 여려개의 변수가 필요한 경우 사용한다.
-자바에서는 배열을 개체를 통해 생성한다.
-생성된 배열은 힙(heap) 영역에 저장되고, 할당된 메모리의 주소값을 반환한다.
-따라서 배열명(배열변수)는 주소값(참조값)을 할당받게 된다.
-우리는 해당 주소를 통해 배열에 접근하게된다.
 */
public class E01OneDimArray01 {

	public static void main(String[] args) {
		
		//정수형의 크기가 3인 배열을 생성
		int[] numArr = new int[3];
		//인덱스0번부터 2번까지 접근하여 배열 초기화
		numArr[0] = 10;//배열의 인덱스는 항상 0부터 시작한다.
		numArr[1] = 20;
		numArr[2] = 30;
		//배열의 인덱스를 통한 접근으로 값 출력
		System.out.println("numArr 0번방의 값:"+ numArr[0]);
		System.out.println("numArr 1번방의 값:"+ numArr[1]);
		System.out.println("numArr 2번방의 값:"+ numArr[2]);
		//정수형 배열이 heap영역에 생성된 후 반환된 주소값이 출력된다.
		System.out.println("배열명(numArr)="+ numArr);
		System.out.println("==============================");
		
		/*
		배열의 선언 및 초기화
			: 배열은 여러개의 변수를 사용하기 위해 선언하므로 접근을
			위해 일반적으로 반복문(for)을 사용한다.
		배열명.length
			: 해당 배열의 크기를 반환한다. 배열의 크기가 변경되는 경우
			유연하게 사용할 수 있다.
		 */
		int[] arrNumber = new int[40];
		//배열의 크기가 변경되어도 해당 for문은 수정할 필요가 없다.
		for(int i=0 ; i<arrNumber.length ; i++) {
			//0번방에 10을 삽입한 후 1씩 증가시키면서 배열 전체를 초기화한다.
			arrNumber[i] = i+10;
		}
		//배열의 크기를 하드코딩으로 작성하였으므로
		//배열의 크기가  변경되면 같이 변경해줘야한다.
		for(int i=0 ; i<40 ; i++) {
			//배열의 각 요소를 출력한다.
			System.out.println(i+"번방의값="+ arrNumber[i]);
		}
		System.out.println("=========================");
		
		
		/*
		객체배열 : 기본자료형을 저장하는 배열이 아닌 객체의 참조값을
			저장할 목적으로 생성한 배열을 말한다. 사용법은 동일하다.
		 */
		//크기가 3인 String형의 배열 생성
		String[] strArr = new String[3];
		//인덱스를 통해 접근후 각 요소를 초기화
		strArr[0] = "java";
		strArr[1] = "jsp";
		strArr[2] = "spring";
		//배열의 크기만큼 반복하면서 각 요소 출력
		for(int j=0 ; j<strArr.length ; j++) {
			System.out.println(strArr[j]);
		}
		System.out.println("==========================");
		
		
		//가장 기본적인 초기화 방식
		System.out.println("배열의 선언과 초기화");
		System.out.println("방법1 : 배열의 선언 이후 초기화");
		int[] initArr = new int[1];//크기가 1인 배열을 선언한 후 
		initArr[0] = 100;//인덱스로 접근하여 초기화
		System.out.println("initArr[0]="+ initArr[0]);
		
		/*
		배열의 선언과 동시에 초기화 하는 경우 자바 컴파일러는 초기값의
		갯수를 통해 배열의 크기를 결정할 수 있다. 따라서 이런 경우 크기는
		생략하도록 약속되어있다.
		 */
		System.out.println("방법2 : 선언과 동시에 초기화1");
		//int[] initArr2 = new int[3] {1, 20, 300};//에러발생
		int[] initArraay2 = new int[] {1, 20, 300};
		
		/*
		배열 원소의 갯수를 통해 배열을 생성한 후 초기화까지 동시에 진행한다.
		이 경우 new를 생략할 수 있다.
		 */
		System.out.println("방법3 : 초기값만으로 선언");
		int[] initArr3 = {11, 13, 17, 19, 23};//요소의 갯수를 통해 크기 5로 지정됨.
		int arrSum= 0;
		for(int x=0 ; x<initArr3.length ; x++) {
			arrSum += initArr3[x];
		}
		System.out.println("배열요소의합은="+ arrSum);
	}
}

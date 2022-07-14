package ex06array;

public class E02ArrayAndMethod {

	public static void main(String[] args) {
		
		//배열을 선언과 동시에 초기화. 원소의 갯수를 통해 크기가 결정됨.
		int[] arr = {1, 2, 3, 4, 5};
		//배열변수 선언(아직 참조할 배열이 없음)
		int[] ref;
		System.out.println("초기화 직후 출력");
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i] +" "); //1,2,3,4,5 출력
		}
		System.out.println();
		
		/*
		배열명을 인수로 전달하는것은 배열의 참조값(주소값)을 전달하는 것임.
		정수의 경우는 해당값이 그대로 전달됨.
		즉, 배열 자체가 전달되는것이 아님에 유의할것.
		 */
		ref = addAllArray(arr, 7);
		/*
		addAllArray() 메서드에서 반환한 값은 처음에 전달했던 배열의
		주소값이므로, 결과적으로 ref도 동일한 배열을 참조하게 된다.
		 */
		System.out.println("메소드 호출후 출력");
		for(int i=0 ; i<ref.length ; i++) {
			System.out.print(ref[i]+" "); // 8,9,10,11,12 출력됨
		}
		System.out.println();
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" "); //8,9,10,11,12 출력됨
		}
		//동일한 배열을 참조하므로 출력되는 값도 동일하다.
	}
	
	/*
	매개변수로 전달된 배열의 참조값을 ar이 받게되므로 결국 해당 메서드에서도
	동일한 배열을 참조하게 된다. 즉, main메서드에서 생성한 배열과 동일한
	배열을 참조하게 되는것이다.
	 */
	static int[] addAllArray(int[] ar, int addVal) {
		for(int i=0 ; i<ar.length ; i++) {
			ar[i] += addVal;
			/*
			ar[i] = ar[i] + addVal;
			위 복합대입 연산자를 풀어서 쓰면 이와같이 된다. 즉 배열의 i번째
			원소에 addVal을 더한 후 다시 대입하므로 결과적으로 7씩 증가되는
			연산이 수행된다.
			 */
		}
		
		//참조값을 그대로 반환한다.
		return ar;
	}
}

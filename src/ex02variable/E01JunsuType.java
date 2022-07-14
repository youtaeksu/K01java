package ex02variable;

public class E01JunsuType {

	public static void main(String[] args) {
		/*
		정수자료형
		-byte, short, int, long 타입(형)이 있다.
		-각 자료형의 표현범위는 교안을 참조한다.(단 외울필요는 없음)
		-일반적으로 CPU(중앙처리장치)는 정수형 연산을 할때 int형을 가장 빠르게 처리한다.
		-즉, 정수형 변수를 쓸때는 거의 대부분 int형을 사용한다.
		 */
		int int1 = 100; //int형 변수 int1을 선언한 후 100으로 초기화(할당)한다.
		int int2 = 200;
		int result1 = int1 + int2; //100+200=>300 결과값이 result1에 할당된다.
		System.out.println("int1 + int2 = "+ result1); //300이 출력됨
		
		/*
		/ 연산자는 두개의 숫자를 나눠서 몫을 구하는 연산자이므로
		100 / 200 의 결과는 0이 나온다. 
		자바에서는 정수와 정수를 연산하면 정수의 결과가 나온다.
		 */
		result1 = int1 / int2;
		System.out.println("int1 / int2 = "+ result1); //0이 출력됨
		
		/*
		-동일한 타입의 변수를 2개이상 선언할 경우 ,(컴마)를 사용할 수 있다.
		-int형보다 작은 자료형을 연산하면 CPU는 int형으로 변환하여 연산한다.
		-CPU가 int형의 연산에 최적화 되어있기 때문이다.
		-byte, short형은 게임케릭터의 움직임이나 음원정보등을 표현할때 주로 
		사용된다.
		 */
		byte byte1 = 50, byte2 = 55;
		int result2 = byte1 + byte2;//byte + byte = int형의 결과 출력
		System.out.println("byte1 + byte2 = "+ result2);
		
		short short1 = 60, short2 = 70;
		int result3 = short1 + short2;//short + short = int형의 결과 출력
		System.out.println("short1 + short2 = "+ result3);
		
		/*
		-동일자료형 끼리의 연산은 동일자료형이 되는것이 기본원칙이다.
		-하지만 큰 자료형과 작은 자료형을 연산하면 큰 자료형으로 자동형변환된다.
		이유는 데이터의 손실이 있을수 있기 때문이다.
		-단, byte형과 short형은 예외적인 상황으로 생각하면 된다. int에 최적화된
		CPU의 특성 때문이다.
		 */
		long long1 = 1000, long2 = 2000;
		long result4 = int1 + long1;//int형 + long형 => long형의 결과
		System.out.println("int1 + long1 = "+ result4);
		
		//long끼리의 연산은 기본규칙을 따른다.
		result4 = long1 + long2;
		System.out.println("long1 + long2 = "+ result4);
		
		/*
		자바컴파일러는 정수형 상수를 기본적으로 int형으로 간주하기 때문에
		아래 정수를 메무리에 올리는 순간 에러가 발생한다.
		이때는 접미사(l or L)을 붙여서 int형 자료가 아닌 long형 자료임을
		알려줘야한다. 이와같이 대입을 위해 입력되는 숫자도 자료형을 기반으로
		메모리에 저장되고, 이를 "리터럴(literal)'이라고 한다.
		 */
		//long long3 = 2200000000;
		long long4 = 2200000000L;
		long long5 = 2200000000l;
		
		System.out.println("long4="+ long4);
		
	}

}
package ex18lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*
Java에서 제공하는 기본 함수형 인터페이스는 아래 4가지 정도가 있다.
차이점이라면 매개변수의 유무와 리턴값 정도이다.

Predicate : 매개변수O, 리턴값 Boolean 
Supplier : 매개변수X, 리턴값O
Consumer : 매개변수O, 리턴값X
Function : 매개변수 와 리턴값 둘다 있음
 */
public class Ex06Define1Predicate {

	public static void main(String[] args) {
		/*
		Predicate
		-사전적의미 : ~에 근거를 두다.
		-매개변수와 boolean 리턴값이 있는 textXX()계열의 추상메서드가 정의되어있다.
		-파라미터를 조사해 true 혹은 false를 반환한다.
		
		interface Predicate<T> {
			boolean test(T t);
		}
		 */
		Human p1 = new Human("케이윌", "남", 80);
		Human p2 = new Human("에일리", "여", 77);
		/*
		인터페이스에 정의된 test() 추상메서드를 오버라이딩하여 아래와 같은
		람다식을 정의한다. 매개변수로 Human객체를 전달하고, 성별을 판단하여
		남자인 경우 true를 여자인 경우 false를 반환하게 될것이다.
		 */
		Predicate<Human> pre = (Human h) -> {
			//Human객체의 getter()를 통해 멤버변수값을 가져온 후 "남"인지 판단한다.
			return h.getGender().equals("남");
		};
		System.out.println("p.test(p1) => "+pre.test(p1)); //true
		System.out.println("p.test(p2) => "+pre.test(p2)); //false
		
		Human p3 = new Human("임재범", "남", 97);
		Human p4 = new Human("아이유", "여", 99);
		
		/*
		인자로 주어진 객체를 List컬렉션으로 반환해준다. 단 해당 컬렉션은 값을
		변경할 수 없고 참조만 가능하다.
		 */
		List<Human> list1 = Arrays.asList(p1, p2, p3, p4);
		
		/*
		남자인지 판단하는 람다식은 추상메서드를 통해 매개변수의 타입을 유추할수
		있어 String이 생략되었다.
		a -> a.getGender().equals("남")
		
		위와같이 생략할 수 있으나 가독성이 떨어지므로 매개변수의 타입정도는
		아래와 같이 기술하는것이 좋다.
		(Human h) -> h.getGender().equals("여")
		
		해당 람다식은 둘다 남 혹은 여를 판단하여 boolean값을 반환한다.
		 */
		double maleAvg = avg(a -> a.getGender().equals("남"), list1);
		System.out.println("남자 평균:"+ maleAvg);
		
		double femaleAvg = avg((Human h) -> h.getGender().equals("여"), list1);
		System.out.println("여자 평균:"+ femaleAvg);
	}
	/*
	매개변수로 성별을 판단하는 람다식과 List컬렉션을 전달한다.
	 */
	public static double avg(Predicate<Human> ph, List<Human> li) {
		int pCount = 0;
		int tCount = 0;
		//컬렉션에 저장된 Human객체의 갯수만큼 반복
		for(Human h : li) {
			//람다식을 통해 각 Human객체의 성별을 판단한다.
			if(ph.test(h)==true) {
				//각 성별을 판단한 후 +1 한다.
				pCount++;
				//Human클래스의 score 멤버변수값을 반환하는 getter()를 통해 점수를 합산한다.
				tCount += h.getScore();
			}
		}
		//평균값을 구해서 반환한다. 
		return (double)tCount / pCount;
	}////end of avg
}

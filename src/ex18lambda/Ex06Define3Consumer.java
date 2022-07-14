package ex18lambda;

import java.util.function.Consumer;

public class Ex06Define3Consumer {

	public static void main(String[] args) {
		
		/*
		Consumer<T>
			: 소비자라는 뜻을 가지고 있어 매개변수는 있으나 반환값이 없는
			accept() 추상메서드가 정의되어 있다.
			즉 매개변수를 소비하는 형태라 보면 되고, 리턴값이 없으므로 단순한
			출력결과만 보여준다.
			
			 interface Consumer<T> {
			 	void accept(T t);
			}
		 */
		//String타입의 매개변수를 단순히 출력하는 기능의 람다식
		Consumer<String> c1 = (String s) -> {
			System.out.println(s +" 는(은) 가수입니다.");
		};
		c1.accept("케이윌");
				
		//매개변수 타입을 생략한 형태의 람다식
		Consumer<String> c2 = t -> {
			System.out.println(t +" 는(은) 과일입니다.");
		};
		c2.accept("Strawberry");	
	}
}

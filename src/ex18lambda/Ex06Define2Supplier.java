package ex18lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Ex06Define2Supplier {

	public static void main(String[] args) {
		
		/*
		Supplier<T>
			: 공급자란 의미를 가지고 있다.
			매개변수는 없으나 리턴값은 있는 getXX() 추상메서드가 정의되어있다.
			주로 호출후 생선한 데이터를 반환한다.
			
		interface Supplier<T> {
			T get();
		}
		 */
		//0~99까지의 난수를 생성한 후 반환해주는 람다식 정의
		Supplier<Integer> sup = () -> {
			Random random = new Random();
			return random.nextInt(100);
		};		
		//추상메서드인 get()을 호출
		int rNum = sup.get();  
		System.out.println("생성된난수="+ rNum);		
		
		//람다식 sup를 통해 난수 10개를 생성한다.
		List<Integer> list = makeRandomNum(sup, 10);
		System.out.println("### print문으로 출력1");
		//리스트 자체를 반복문 없이 출력할 수 있다.
		System.out.println(list);
		
		System.out.println("### foreach문으로 출력2");
		for(Integer i : list) {
			System.out.printf("%d ", i);
		}
		System.out.println();
				
		System.out.println("### 이터레이터로 출력3");
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() +" ");
		}
	}
	/*
	0~99사이의 난수를 생성하는 람다식과 정수를 인수로 받아 인수의 갯수만큼
	난수를 생성한 후 List컬렉션에 저장 후 반환한다.
	 */
	public static List<Integer> makeRandomNum(Supplier<Integer> s, 
			int cnt){		
		List<Integer> li = new ArrayList<Integer>();
		for(int i=1 ; i<=cnt ; i++) {
			li.add(s.get());
		}
		
		return li;
	}
}


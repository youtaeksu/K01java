package bokang;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class R09CollectionLotto {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		//로또번호는 중복된 숫자가 있으면 안되므로 Set계열의 컬렉션을 생성한다. 
		HashSet<Integer> setLotto1 = new HashSet<Integer>();
		//중복되지 않는 난수를 생성하기 위해 무한루프 내에서 반복한다.
		while(true) {
			//1~45사이의 난수를 생성해서 Set에 추가한다. 이때 중복된 숫자는 저장되지 않는다.
			setLotto1.add(random.nextInt(45)+1);
			//숫자 6개가 저장되었다면 루프를 탈출한다.
			if(setLotto1.size()==6) break;
		}
		//Set컬렉션은 정렬은 되지 않으므로 List컬렉션으로 변환한다.
		ArrayList<Integer> listLotto1= new ArrayList<Integer>(setLotto1);
		//sort()메서드를 통해 오름차순 정렬한다.
		listLotto1.sort(Comparator.naturalOrder());
		//listLotto1.sort(Comparator.reverseOrder());//내림차순정렬
		//로또번호를 출력한다.
		System.out.println(listLotto1);
		
		/////////////////////////////////////////////////////////////////
		/*
		TreeSet<E> 컬렉션은 중복은 허용하지 않지만 Tree라는 자료구조를 기반으로 하므로
		정렬은 허용한다. Integer클래스와 같은 기본클래스는 별도의 오버라이딩 없이도
		오름차순 정렬된 상태로 저장된다.
		 */
		TreeSet<Integer> setLotto2 = new TreeSet<Integer>();
		while(true) {
			setLotto2.add(random.nextInt(45)+1);
			if(setLotto2.size()==6) break;
		}
		System.out.println(setLotto2);
	}
}

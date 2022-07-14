package ex17collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Ex07AsList {

	//List컬렉션을 매개변수로 받은 후 전체를 출력
	public static void listPrint(String title, List<String> list) {
		System.out.println("# "+ title);
		//출력할 내용이 String이므로 별도의 오버라이딩 없이 내용을 출력할 수 있다.
		//만약 우리가 정의한 클래스라면 toString을 오버라이딩 해야한다.
		for(Object ob : list) {
			System.out.print(ob +" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		//String 객체배열 생성 및 초기화
		String[] strArr = new String[] {"마린", "파이어뱃", "메딕", "마린"};
		/*
		Arrays.asList() : 일반적인 배열을 List계열의 컬렉션으로 변경해서 반환한다.
			단, 값을 참조할수만 있고 변경(입력,삭제 등)할 수는 없다.
		 */
		List<String> list = Arrays.asList(strArr);
		listPrint("출력1", list);
		
		//list.add("탱크");//에러발생
		
		//ArrayList<E>의 생성자를 통해 객체를 복사하면 데이터를 변경할 수 있다.
		list = new ArrayList<String>(list);
		boolean isAdd = list.add("탱크");
		System.out.println("add결과:"+ isAdd);
		listPrint("출력2", list);
		
		//이터레이터를 for문을 이용해서 출력한다.
		/*
		for(초깃값(이터레이터객체생성) ; 조건식(hasNext()) ; 증감식(아래next()함수로대체)){
			print(next()메서드)
		}
		*/
		System.out.println("# 출력3");
		for(Iterator<String> itr = list.iterator(); itr.hasNext();) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		/*
		Set<E> 계열의 컬렉션은 중복을 허용하지 않으므로 List에 저장된
		중복값을 아래와 같이 제거할 수 있다.
		//여기서 중복값이 제거된다.
		 */
		HashSet<String> set = new HashSet<String>(list);
		//다시 복사본을 만든 후 출력한다.
		list = new ArrayList<String>(set);
		listPrint("출력4(중복제거)", list);
	}
}

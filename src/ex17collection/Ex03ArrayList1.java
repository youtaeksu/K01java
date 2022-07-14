package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;

/*
ArrayList<E> : List 계열의 컬렉션
-데이터의 중복 저장이 허용된다.
-데이터의 저장 순서를 보장한다.
-데이터 접근시 get() 혹은 iterator()를 이용한다.
-Array 라는 이름처럼 '배열'의 특성을 가지고 있어 index를 통한
	저장 및 접근이 가능하다.
 */
public class Ex03ArrayList1 {

	public static void main(String[] args) {

		/*
		String객체를 저장할 수 있는 List컬렉션 생성
		ArrayList와 LinkedList는 데이터를 저장하는 내부적인 자료구조만 다를뿐
		사용법은 100% 동일하다.
		 */
		ArrayList<String> list = new ArrayList<String>();
		//LinkedList<String> list = new LinkedList<String>();
//		Vector<String> list = new Vector<String>();
		
		/*
		객체저장 : add()
			add(객체) : 순차적으로 저장하면서 인덱스는 0부터 자동으로 부여된다.
			add(인덱스, 객체) : 저장시 데이터를 직접 부여한다. 단, 인덱스를
				건너뛰면 에러가 발생하므로 주의해야 한다.
				해당 인덱스에 객체가 이미 저장되 어있다면 끼워넣기가 된다.
		 */
		list.add("소녀시대");
		list.add("빅뱅");
		list.add("트와이스");
		list.add(3,"워너원");
//		list.add(5,"소방차ㅋㅋ");//에러발생(인덱스를 건너뛸 수 없다.)
		/*
		저장된 객체수(리스트의 크기) : size()
			참조변수.size() : 컬렉션에 저장된 객체의 갯수 즉 크기가 반환된다.
				배열의 length와 동일하다.
		 */
		list.add(list.size(),"오마이걸");
		list.add(list.size(),"방탄소년단");
		System.out.println("중복 저장전 객체수:"+ list.size());//6 출력됨
		
		/*
		중복저장
			: List는 배열의 특성을 가지므로 데이터의 중복저장이 허용된다.
			동일한 데이터라 할지라도 Index로 구분할 수 있기 때문이다.
			add()메서드는 추가에 성공한 경우 true를 반환한다.
		 */
		System.out.println(list.add("트와이스") ? "중복저장됨":"중복저장안됨");
		System.out.println("중복 저장후 객체수:"+ list.size());
		
		/*
		컬렉션 출력시에는 아래 3가지 방법을 사용한다.
		방법1 : 일반for문 사용. 이때는 인덱스를 통해 접근해야
			하므로 get() 메서드를 사용한다.
		 */
		System.out.println("\n[일반for문 사용]");
		for(int i=0 ; i<list.size() ; i++) {
			System.out.print(list.get(i) +" ");
		}
		/*
		방법2 : 확장for문의 경우 인덱스 없이 전체 요소를 반복해주므로
			좀더 간결한 표현으로 사용할 수 있다. 따라서 가장 많이 사용된다.
		 */
		System.out.println("\n[확장for문 사용]");
		for(String obj : list) {
			System.out.print(obj + " ");
		}
		/*
		방법3 : Iterator(반복자) 사용
			1.컬렉션에 저장된 내용을 Iterator객체에게 알려주기 위해 객체를
				생성한다.
			2.hasNext()로 반환한 객체가 있는지 검사하고, next()로 해당 객체를
				반환한다.
			3.모든 객체가 반환되었다면 false를 반환하여 반복문을 탈출한다.
		 */
		System.out.println("\n[반복자(Iterator) 사용]");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() +" ");
		}
		System.out.println("\n=====================\n");
		
		/*
		수정하기(덮어쓰기)
			: 기존의 내용을 변경한다. 기존의 내용은 삭제된다.
			set(인덱스, 객체);
		 */
		//4번인덱스의 객체를 변경한다.
		list.set(4, "오마이걸>덮어쓰기");
		for(Object obj : list) {
			System.out.print(obj +" ");
		}
		System.out.println("\n=====================\n");
		
		/*
		삽입하기(끼워넣기)
			:add(삽입할인덱스, 객체)
			해당 인덱스에 객체를 삽입하고, 기존객체는 자동으로 뒤로 밀려난다.
			즉, 자동으로 인덱싱 된다.
		 */
		list.add(4, "블랙핑크>끼워넣기");
		for(Object obj : list) {
			System.out.print(obj +" ");
		}
		System.out.println("\n=====================\n");
		
		/*
		포함여부확인
			contains(객체) : 찾고자 하는 객체가 있는경우 true를 반환한다.
				단지 존재하는지 여부만 확인할 수 있다.
		 */
		System.out.println(list.contains("빅뱅") ? "빅뱅 있음" : "빅뱅 없음");//있음
		System.out.println(list.contains("블랙핑크") ? 
				"블랙핑크 있음" : "블랙핑크 없음");//없음
		
		/*
		삭제하기
		방법1 : 인덱스로 삭제
			remove(인덱스) : 인덱스를 통해 삭제를 진행한 후 삭제가 완료되면
				해당 객체를 반환한다. 삭제후에는 인덱스가 자동으로 재부여된다.
				삭제 성공시 해당 객체를 반환하므로 어떤 객체를 삭제했는지
				확인할 수 있다.
		 */
		//2번 인덱스 삭제 : 트와이스 삭제됨
		Object obj = list.remove(2);
		System.out.println("삭제된객체:"+ obj);
		
		//indexOf()를 통해 해당 객체의 인덱스를 찾은 후 삭제한다.
		int index = list.indexOf("빅뱅");
		System.out.println("빅뱅의 index="+ index);//찾은인덱스 : 1
		list.remove(index);
		
		
		//방법2 : 인스턴스의 참조값을 통해 삭제한다.
		System.out.println(list.remove("방탄소년단") ? "삭제성공(방탄)":"삭제실패(방탄)");//삭제성공
		list.remove("오마이걸");//객체가 없으므로 삭제 실패
//		System.out.println(list.remove("오마이걸") ? "삭제성공(마이걸)":"삭제실패(마이걸)");
		System.out.println("삭제후 출력");
		for(Object ob : list) {
			System.out.print(ob +" ");
		}
		System.out.println();
		
		/*
		전체삭제
		 */
		list.removeAll(list);//방법2
		list.clear();//방법2
		System.out.println("전체삭제후 객체수:"+ list.size());
	}
}

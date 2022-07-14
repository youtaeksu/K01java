package ex17collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
/*
HashMap<K, V>
	: Map<T> 인터페이스를 구현한 컬렉션 클래스로
-Key, Value의 쌍으로 객체를 저장한다.
-키값은 중복될 수 없다. 만약 중복되면 기존의 데이터를 덮어쓰기한다.
-키값으로 검색하므로 다른 컬렉션에 비해 속도가 빠르다.
 */
public class Ex05HashMapMain {

	public static void main(String[] args) {

		//Map컬렉션 생성. Key와 Value는 모두 String으로 선언한다.
		HashMap<String, String> map = new HashMap<String, String>();
		
		/*
		객체저장
			: 객체저장시 기존에 저장된 동일한 key값이 존재하면 이전에 저장된
			객체가 반환된다. 만약 처음 입력이라면 null값이 반환된다.
		 */
		System.out.println("name이라는 키값으로 저장된 이전의 값:"+
				map.put("name", "홍길동"));
		
		int number = 20;
		//map.put("age", number); //에러발생. value타입은 String이어야 한다.
		map.put("age", String.valueOf(number)); //숫자를 문자열로 변경해서 저장한다.
		map.put("gender", "남자");
		map.put("address", "가산디지털단지");
		System.out.println("저장된 객체수:"+ map.size());//4개
		
		/*
		중복저장
			: 기존에 입력된 Key값 name이 이미 있으므로 "홍길동"이 반환된다.
			그리고 기존의 값은 "최길동"으로 수정된다.
		 */
		System.out.println("name이라는 키값으로 저장된 이전의 값:"+
				map.put("name", "최길동"));//덮어쓰기
		System.out.println("키값으로 중복 저장후 객체수:"+ map.size());//4개
		
		/*
		출력하기
		1.키값을 알고있을때 : get(키값) 으로 출력한다.
		 */
		System.out.println("키값을 알때:"+ map.get("name"));//최길동
		
		/*
		2.키값을 모를때(혹은 키값이 너무 많아서 하나씩 명시하기 힘들때)
		 	: keySet()을 호출하여 키값을 Set컬렉션으로 얻어온다. 해당 반환값을
		 	확장 for문으로 추출하고, 이를 통해 저장된 값을 추출할 수 있다.
		 	※ Map계열의 컬렉션은 처음부터 확장 for문을 사용하는것은
		 	불가능하다. 아래처럼 Key값을 먼저 얻어온 후 사용해야한다. 
		 */
		Set<String> keys = map.keySet();
		System.out.println("[확장for문 적용]");
		for(String key : keys) {
			String value = map.get(key);
			System.out.println(String.format("%s:%s", key, value));
		}
		
		/*
		3.이터레이터 사용
			: 이터레이터를 통해 출력할때도 keySet()을 통해 키값을 먼저
			얻어온 후 반복출력한다.
		 */
		System.out.println("[이터레이터 사용하기]");
		Set<String> keys2 = map.keySet();
		Iterator<String> it = keys2.iterator();
		while(it.hasNext()) {
			String key = it.next();//키값 얻기
			String value = map.get(key);//벨류값 얻기
			System.out.println(String.format("%s:%s", key, value));
		}
		
		/*
		Value만 얻어올때는 values() 메서드를 사용한다.
		 */
		System.out.println("[value값들만 출력하기]");
		//values()메서드의 반환타입은 Collection<T>이다.
		Collection<String> values = map.values();
		for(String value : values) {
			System.out.println(value);
		}
		
		/*
		객체의 존재유무 확인
			: Map컬렉션은 Key와 value가 있으므로 해당 메서드도 2개로 
			나눠져있다.
		 */
		System.out.println(map.containsKey("name") ?
				"name키값있다" : "name키값없다");
		System.out.println(map.containsKey("account") ?
				"account키값있다" : "account키값없다");
		System.out.println(map.containsValue("남자") ?
				"남자 있다" : "남자 없다");
		System.out.println(map.containsValue("여자") ?
				"여자 있다" : "남자 없다");
		
		/*
		객체삭제
			: Key값을 통해 삭제하고, 삭제에 성공하면 해당 value가 반환된다.
		 */
		System.out.println("삭제된객체:"+ map.remove("age"));//20출력
		System.out.println("[age키값을 삭제후 출력]");
		for(String key : keys) {
			System.out.println(String.format("%s:%s", 
					key, map.get(key))); 
			
		/*
		전체삭제
			:removeAll()은 없다.  clear()만 사용할 수 있다.
		 */
		map.clear();
		System.out.println("전체삭제후 객체수:"+ map.size());
		}
	}
}

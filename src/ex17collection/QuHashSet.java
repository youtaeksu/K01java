package ex17collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
문제2] QuHashSet.java 
컬렉션 set에 저장된 객체를 이름으로 검색하자.
해당 정보가 있으면 해당 어벤져스의 정보를 출력하고 없으면
"해당 영웅은 없어요ㅜㅜ" 라는 메시지 출력해야 한다. 
검색 부분은 Iterator를 통해 구현하도록 한다.
set계열의 컬렉션은 기본적으로 중복저장을 허용하지 않는다. 
그러나 아래와 같이 새롭게 정의한 클래스에 대해서는 
equals(), hashCode() 메소드를 적절히 오버라이딩 처리해야 중복을 제거할 수 있다. 
메소드 오버라이딩을 통해 hero4 는 입력되지 않도록 Avengers 클래스를 업데이트 하시오.
 */
class Avengers {
	String name;
	String heroName;
	String weapon;

	public Avengers(String name, String heroName, String weapon) {
		super();
		this.name = name;
		this.heroName = heroName;
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "Avengers [본명=" + name + ", 닉네임=" + heroName + ", "
				+ "능력=" + weapon +"]";
	}
	@Override
	public int hashCode() {
		System.out.println("hashCode() 호출됨");
		
		//방법1 : hash()메서드를 이용한다.
//		int hc1 = Objects.hash(name, heroName, weapon);
//		return hc1;
		
		//방법2 : 각 String객체의 hashCode값을 더해서 반환한다.
		int hc2 = name.hashCode() + heroName.hashCode() + weapon.hashCode();
		return hc2;
	}
	@Override
	public boolean equals(Object obj) {
		Avengers avn = (Avengers)obj;
		//3가지 멤버변수의 값이 모두 동일하면 true를 반환한다.
		if(this.name.equals(avn.name) && this.heroName.equals(avn.heroName)
				&& this.weapon.equals(avn.weapon)) {
			//이때는 set에 저장되지 않는다.
			return true;
			
		}
		else {
			//다른값이 있따면 set에 저장된다.
			return false;
		}
	}
}

public class QuHashSet {

	public static void main(String[] args) {

		HashSet<Avengers> set = new HashSet<Avengers>();

		Avengers hero1 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		Avengers hero2 = new Avengers("스티브로져스", "캡틴아메리카", "비브라늄 방패");
		Avengers hero3 = new Avengers("브루스배너", "헐크", "강한피부&점프");
		Avengers hero4 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
			
		set.add(hero1);
		set.add(hero2);
		set.add(hero3);
		set.add(hero4);		 

		System.out.println("[최초 전체 정보출력]");
		for(Avengers av : set)
		{
			System.out.println(av.toString());			
		}
			
		System.out.println("## 검색 기능 추가 ##");
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scanner.nextLine();
			
		boolean isFind = false;
		Iterator<Avengers> itr = set.iterator();
		while (itr.hasNext()) {
			//어벤져스 객체를 인출한다.
			Avengers av = itr.next();
			//검색할 이름과 일치하는지 확인한다.
			if(searchName.equals(av.name)) {
				//toString()메서드가 오버라이딩 되었으므로 print()로 즉시 출력가능
				System.out.println(av);
				isFind = true;
			}
		}
		if(isFind==false) System.out.println("## 검색된 영웅의 정보가 없습니다.##");
	}
}




//중복 제거용 equals()메소드 호출
//[최초 전체 정보출력]
//Avengers [본명=스티브로져스, 닉네임=캡틴아메리카, 능력=비브라늄 방패]
//Avengers [본명=브루스배너, 닉네임=헐크, 능력=강한피부&점프]
//Avengers [본명=토니스타크, 닉네임=아이언맨, 능력=Mark-48 수트]
//검색할 이름을 입력하세욤:브루스배너
//Avengers [본명=브루스배너, 닉네임=헐크, 능력=강한피부&점프]
//요청하신 정보를 찾았습니다


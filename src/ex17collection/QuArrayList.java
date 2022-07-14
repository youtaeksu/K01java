package ex17collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import common.Student;

/*
문제1) QuArrayList.java 
사용자로부터 이름을 입력받아 그 이름으로 검색해서 
인덱스 위치(indexOf사용)를 알아내서 해당 인덱스로 
그 객체를 삭제하고 삭제된 객체의 정보(이름,나이,학번)를 출력하여라.
 */
public class QuArrayList {

	public static void main(String[] args) {
		
		//ArrayList<Student> list = new ArrayList<Student>();
		LinkedList<Student> list = new LinkedList<Student>();
		
		//저장할 객체 생성
		Student st1 = new Student("가길동", 10, "2018");
		Student st2 = new Student("나길동", 20, "2017");
		Student st3 = new Student("다길동", 30, "2016");
		Student st4 = new Student("마길동", 40, "2015");
		
		//객체 추가(컬렉션에 저장)
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
			
		//1.검색할 이름을 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String delName = scanner.nextLine();
		
		//컬렉션의 인덱스는 0부터 시작하므로 초깃값은 -1로 해줘야 한다.
		int index = -1;
		//2.확장for문으로 컬렉션 전체를 접근
		for(Student st : list) {
			if(delName.equals(st.getName())){
				index = list.indexOf(st);
			}
		}
			
		//3.검색결과 유/무에 따라 
		if(index!=-1) {
			//검색결과 있을때…검색된 데이터 삭제
			Student student = list.remove(index);
			/*
			remove()를 통해 객체를 삭제할때
				인덱스를 통해 삭제하면 삭제된 객체의 참조값이 반환된다.
				객체의 참조값을 통해 삭제하면 boolean값이 반환된다.
			 */
			//toString()메서드가 오버라이딩 되어 있으므로 참조값으로 출력할 수 있다.
			System.out.println("##다음 객체가 삭제되었습니다.##");
			System.out.println(student);
			
		}
		else {
			//검색결과 없을때...검색결과가 없다고 출력
			System.out.println("검색결과가 없습니다.");
		}

		//4.전체정보 출력(이터레이터 사용)
		System.out.println("## 전체 객체를 출력합니다. ##");
		Iterator<Student> itr = list.iterator();
		while(itr.hasNext()) {
			Student st = itr.next();
			System.out.println(st);
			
		}
		
	}
}



//실행결과]
//검색할 이름을 입력하세요:가길동
//오버라이딩 한 equals() 호출됨:가길동
//[검색되었습니다]
//[삭제후 정보출력]
//이름:나길동, 나이:20, 학번:2017
//이름:다길동, 나이:30, 학번:2016
//이름:마길동, 나이:40, 학번:2015


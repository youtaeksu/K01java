package ex17collection;

import java.util.HashSet;

import common.Teacher;

public class Ex04HashSet2 {

	public static void main(String[] args) {
		
		//Teacher객체를 저장할 수 있는 Set Collection 생성
		HashSet<Teacher> hashSet = new HashSet<Teacher>();
		
		//3개의 객체 생성 및 추가
		Teacher t1 = new Teacher("정우성", 40, "국어");
		Teacher t2 = new Teacher("황정민", 42, "영어");
		Teacher t3 = new Teacher("최민식", 44, "수학");
		
		hashSet.add(t1);
		hashSet.add(t2);
		hashSet.add(t3);
		
		/*
		3개의 객체는 모두 다른 값을 가지고 있으므로 입력에 성공한다.
		 */
		System.out.println("hashSet의크기:"+ hashSet.size());//3개
		
		/*
		Teacher클래스 정의시 별도의 오버라이딩을 하지않으면 아래 객체의 경우
		중복거리없이 입력된다. 우리가 직접 정의한 클래스는 JVM이 동일한 객체인지
		판단할 기준이 없으므로, 직접 정의해줘야 한다. 
		 */
		Teacher t3Same = new Teacher("유비", 40, "국어");
		/*
		오버라이딩에 따라 동일한 객체를 판단하는 기준이 달라지게 되므로
		상황에 따라 적절히 정의하면 된다. 해당 프로그램에서는 나이와 과목이 동일하면
		같은 객체로 판단하도록 오버라이딩 되어있다.
		 */
		
		System.out.println("t3Same저장여부:"+ hashSet.add(t3Same));
		System.out.println("hashSet의크기:"+ hashSet.size());
	}
}

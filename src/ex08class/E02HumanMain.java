package ex08class;

/*
해당 예제에서는 Human클래스를 외부파일로 선언하였다.
동일한 패키지에 정의되었다면 컴파일러는 해당 클래스를 찾아 즉시
객체(인스턴스)화 할 수 있다.
만약 다른 패키지에 선언된 클래스라면 반드시 import 선언을 해야한다.
 */
public class E02HumanMain {

	public static void main(String[] args) {

		//1. 객체생성 및 참조변수 선언
		Human human = new Human();
		
		//2. 객체 초기화 : 참조변수를 통해 닷(.)으로 접근한다.
		human.name = "마이클";
		human.age = 28;
		human.energy = 4;
		
		//3. 멤버메서드 호출을 통해 걷다 등의 행위를 구현
		human.showState();//초기상태의 객체 확인
		human.eat();
		human.walking();
		human.thinking();
		human.showState();//멤버메서드 호출 후 객체 확인
		
		//4. 반복문을 통해 에너지를 고갈시켜본다. walk()를 20번 호출한다.
		for(int i=1 ; i<=20 ; i++) {
			human.walking();
		}
		human.showState();
		
		//5.에너지가 최대치를 초과하는지 확인하기 위해 호출한다.
		for(int i=1 ; i<=20 ; i++) {
			human.eat();
		}
		human.showState();
	}
}

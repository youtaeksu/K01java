package ex12Inheritance;
/*
static(정적) 타입의 멤버도 상속이 되고, 하위클래스에서 접근시에는 멤버변수의
이름만으로 접근이 가능하다.
단, 클래스 외부에서 접근할 경우 객체생성없이 클래스명을 통해서도 접근할 수 있다.
즉 static이 가진 기본적인 규칙을 따른다.
 */
class Adder { 
	
	public static int val = 0;
	/*
	static으로 선언된 멤버변수는 실제로는 외부(메서드영역)에 생성되어
	있으므로 클래스명을 통한 접근이 허용된다.
	코드 레벨에서 보면 해당 클래스의 멤버변수이므로 변수명만으로 접근하는것도
	가능하다. 
	즉, 문법적으로는 둘 다 허용된다.
	 */
	public void add(int num) {
		val += num;
		Adder.val += num;
	}
}
//부모의 멤버변수가 public이므로 접근의 제하니 없어 아래 코드는 모두 실행가능하다.
class AdderFriend extends Adder{
	
	public void friendAdd(int num) {
		val += num;//변수명만으로 접근
		Adder.val += num;//클래스명으로 접근
	}
	public void showVal() {
		System.out.println("val="+ val);
		System.out.println("val="+ Adder.val);
	}
}

public class E03StaticInheritance {

	public static void main(String[] args) {

		/*
		멤버변수 val은 static이므로 프로그램 시작시 딱 하나만
		생성되어 메서드 영역에 로딩된다. 따라서 아래에서의 모든
		연산은 하나의 변수 즉 val에만 더해지므로 결과는 20이
		출력된다.
		 */
		Adder ad = new Adder();
		AdderFriend adFriend = new AdderFriend();
		
		ad.add(1);				//1+1=2
		adFriend.friendAdd(3);	//2+3+3=8
		Adder.val += 5;			//8+5=13
		AdderFriend.val += 7;	//13+7=20
		
		adFriend.showVal();
	}
}

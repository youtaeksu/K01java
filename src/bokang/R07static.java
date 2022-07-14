package bokang;

import java.util.Scanner;

/*
static으로 선언된 변수/메서드는 컴파일러에 의해 프로그램이 실행될 때 
이미 초기화되어 메서드 영역에 로딩된다.
메서드 영역에 로딩된 static(정적) 메서드/변수는 객체생성없이 클래스명만으로
접근이 가능하다.
즉, new연산자를 통해 새로운 객체를 계속 생성하지 않고, 하나의 객체를
프로그램 전체에서 공유해서 사용한다.
 */
public class R07static {

	private String name;
	public R07static() {
		System.out.println("나는 기본생성자");
	}
	public R07static(String name) {
		this.name = name;
		System.out.println("나는 인자생성자");
	}
	public void showName() {
		System.out.println("내 이름은 "+name+" 입니다");
	}
	/*
	메인 메서드는 프로그램 시작과 동시에 메서드영역에 로딩된다.
	즉 사용할 준비가 이미 끝나므로 메인 메서드 내에서는 어떤 클래스든지
	객체를 생성할 수 있다.
	 */
	public static void main(String[] args) {
		
		//객체생성 후 초기화하지 않으므로 출력시 null이 나온다.
		System.out.println("# 첫번째 객체 생성");
		R07static static1 = new R07static();
		static1.showName();
		
		//객체생성과 동시에 초기화하여 멤버메서드를 호출한다.
		System.out.println("# 두번째 객체 생성");
		new R07static("홍길동").showName();
		
		
		System.out.println("# 입력받기1");
		System.out.print("정수를 입력하세요:");
		int iNum = AddClass.scanner.nextInt();
		System.out.println("입력한 정수는:"+iNum);
		
		System.out.println("# 입력받기2");
		new AddClass().inputNum();
	}
}
class AddClass {
	/*
	해당 클래스의 멤버변수인 scanner도 프로그램 시작과 동시에 초기화되어
	메서드영역에 로딩된다. 따라서 addClass클래스명으로 즉시 접근하여
	가져다 쓸 수 있다.
	 */
	public static Scanner scanner = new Scanner(System.in);
	
	public void inputNum() {
		System.out.println("정수를 입력하세요:");
		int num = scanner.nextInt();
		System.out.println("입력한 정수는:"+ num);
	}
}
package ex18lambda;

/*
익명클래스 정의를 통한 오버라이딩
 */

interface IKosmo2 {
	void studyLambda(String str);
}

//익명클래스를 통해 구현하므로 구현(implements)의 과정이 필요없다.

public class Ex02AnonymousClass {

	public static void main(String[] args) {
		
		/*
		IKosmo2 인터페이스를 구현한 익명클래스 정의
		extends 혹은 implements 키워드는 없지만 중괄호 부분은 자식의 영역이 된다.
		즉 익명클래스는 눈에 보이지 않는 상속(구현)이 되어있다.
		*/
		IKosmo2 kosmo = new IKosmo2() {
			/*
			상속의 절차를 익명클래스로 대체하므로 코드가 좀 더 간결해진다.
			 */
			@Override
			public void studyLambda(String str) {
				System.out.println(str +"을 공부하기 위해 익명클래스를 만들어요.");
			}
		};
		kosmo.studyLambda("람다식");
	}
}

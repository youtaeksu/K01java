package ex18lambda;

/*
인터페이스와 클래스를 활용한 일반적인 오버라이딩
 */

//인터페이스 정의
interface IKosmo1 {
	/*
	인터페이스에 정의한 모든 메서드는 public abstract가 자동으로 추가되어
	추상메서드가 된다. 추상메서드는 구현부가 없으므로 기능이 없다. 따라서
	오버라이딩의 목적으로 생성된다.
	 */
	void studyLambda(String str);
}
/*
추상메서드를 포함한 인터페이스를 구현하면 하위 클래스에서는 반드시
오버라이딩 해야한다. 추상메서드를 포함한 클래스는 반드시 avstract로
선언하거나, 그렇지 않으면 오버라이딩을 통해 부모 인터페이스의 추상메서드를 
가려야 한다.
 */

class KosmoStudent1 implements IKosmo1 {
	@Override
	public void studyLambda(String str) {
		System.out.println(str +"을(를) 공부합니다");
	}
}
public class Ex01NormalClass {

	public static void main(String[] args) {
		/*
		단지 메서드 하나는 정의해서 사용하고 싶은데 인터페이스, 상속,
		오버라이딩, 객체생성까지의 과정을 거쳐야 하므로 너무 복잡하다.
		 */
		IKosmo1 kosmo = new KosmoStudent1();
		kosmo.studyLambda("람다식");
	}
}

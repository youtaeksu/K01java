package ex09package;

/*
동일한 이름의 클래스를 사용할 경우 둘다 임포트 할수 없으므로
하나만 임포트한다. 둘 다 임포트 할 경우 객체생성시 구분할 수 없으므로
에러가 발생한다.
 */
import ex09package.kosmo.perimeter.Circle;

public class E02CircleMain {

	public static void main(String[] args) {

		//넓이 계산을 위한 클래스는 풀경로를 통해 객체생성
		ex09package.kosmo.area.Circle circle1 = 
				new ex09package.kosmo.area.Circle(6.5);
		System.out.println("반지름이 6.5인 원의넓이:"
				+ circle1.getArea());
		
		//둘레 계산을 위한 클래스는 임포트 후 객체 생성
		Circle circle2 = new Circle(4.5);
		System.out.println("반지름이 4.5인 원의둘레:"
				+ circle2.getPerimeter());
	}
}

package ex09package.kosmo.perimeter;
/*
원의 둘레를 계산하기 위한 클래스로 perimeter패키지에
정의한다.
 */
public class Circle {
	//반지름과 원주율을 정의
	double rad;
	final double PI;
	/*
	멤버상수는 생성자에서는 초기화 할 수 있다.
	따라서 위와같이 초기값없이 정의할 수 있다.
	 */
	public Circle(double rad){
		this.rad = rad;
		PI = 3.14159;
	}
	//둘레 계산 후 결과 반환
	public double getPerimeter(){
		return 2 * PI * rad;
	}
}

package ex09package.kosmo.area;

public class Circle {
	//멤버변수로 반지름과 원주율 선언
	double rad;
	final double PI;	
	public Circle(double rad){
		this.rad = rad;
		PI = 3.14159;
	}
	//넓이 계산 후 결과 반환
	public double getArea(){
		return PI * rad * rad;
	}
}
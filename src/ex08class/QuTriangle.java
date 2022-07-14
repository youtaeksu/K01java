package ex08class;
/*
문제2) 파일명 : QuTriangle.java (난이도:중)
밑변과 높이 정보를 저장할 수 있는 Triangle클래스를 정의해보자. init메소드를 통해
 밑변과 높이를 초기화한다.
그리고 밑변과 높이를 변경시킬수 있는 메소드와 삼각형의 넓이를 계산해서 반환하는
 메소드도 함께 정의해보자.
 */
class Triangle {
	
	//멤버변수(및변, 높이)
	int bottom;
	int height;
	
	public void init(int bottom, int height) {
		//멤버변수와 매개변수의 이름이 동일할때 this를 통해 구분할수 있다.
		this.bottom = bottom;
		this.height = height;
	}
	//삼각형의 넓이 계산
	public double getArea() {
		//공식 : 밑변 * 높이 * 0.5;
		return bottom * height * 0.5;
	}
	//밑변과 높이를 변경
	public void setBottom(int bot) {
		//this는 멤버변수를 가리킨다.
		this.bottom = bot;
	}
	public void setHeight(int hei) {
		//멤버변수와 매개변수의 이름이 다르므로 this를 생략해도 된다.
		height = hei;
	}
} 
public class QuTriangle {
		
	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.init(10, 17); //밑변10, 높이17로 초기화
		System.out.println("삼각형의 넓이 : " + t.getArea());
		t.setBottom(50);//밑변 50으로 변경
		t.setHeight(14);//높이 14로 변경
		System.out.println("삼각형의 넓이 : " + t.getArea());
	}
}



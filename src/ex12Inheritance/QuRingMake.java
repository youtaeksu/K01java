package ex12Inheritance;
/*
문제4) QuRingMake.java
다음 Point클래스를 이용하여 다음 문제를 해결하시오.
 해당 문제는 상속(Inheritance)을 통해 구현하는것이 아니라 
 구성(Composition)관계를 이용하여 해결한다. 
 Point 클래스를 기반으로 원을 의미하는 Circle클래스를 정의하자. 
 그리고 Circle클래스를 기반으로 Ring클래스를 정의하자.
 
 문제설명]
그래프 상에 원을 표현하기 위해선 중심점과 반지름이 필요하다. 
링을 표현하기 위해선 원 2개가 필요하다.
 */
//점을 표현한 클래스
class Point {
	//2개의 좌표를 통해 
	int xDot, yDot;
	public Point(int x, int y) {
		xDot=x;
		yDot=y;
	}
	public void showPointInfo() {
		 System.out.println("[x좌표:"+xDot+", y좌표"+yDot+"]");
	}
}
//Point클래스를 기반으로 원(Circle) 클래스 표현하기
class Circle{	
	//멤버변수
	int radian;//반지름
	Point center;

	//생성자(초기화를 위해 인수 3개가 필요함)
	public Circle(int radian, int x, int y) {
		//반지름 초기화
		this.radian = radian;
		//Point객체 생성 및 초기화
		center = new Point(x, y);
	}
	
	//멤버변수 정보 출력
	public void showCircleInfo() {
		//포인트 정보를 먼저 출력
		center.showPointInfo();
		//반지름 정보 출력
		System.out.println("반지름:"+ radian);
	}
}
//원 2개를 겹쳐서 링을 표현하는 클래스
class Ring{
	//멤버변수
	Circle innerCircle;//안쪽의 원
	Circle outerCircle;//바깥쪽의 원
	
	//생성자(초기화를 위해 6개의 인수가 필요함)
	public Ring(int inX, int inY, int inRad, int outX, int outY, int outRad) {
		//2개의 원 객체 생성
		innerCircle = new Circle(inRad, inX, inY);
		outerCircle = new Circle(outRad, outX, outY);
	}
	
	//정보출력
	public void showRingInfo() {
		System.out.println("안쪽원의정보:");
		innerCircle.showCircleInfo();
		System.out.println("바깥쪽원의 정보:");
		outerCircle.showCircleInfo();
	}
}
class QuRingMake {
	public static void main(String[] args) {
		Ring c = new Ring(1,1,3,2,2,9);
		c.showRingInfo();
	}
}
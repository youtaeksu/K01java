package ex12Inheritance;
/*
문제3) QuRectangleMain.java
정사각형을 의미하는 Square클래스와 직사각형을 의미하는
Rectangle클래스를 정의하고자 한다.그런데 정사각형은 
직사각형의 일종이므로, 다음의 형태로 클래스의 상속관계를 구성하고자 한다. 
아래의 소스를 참조하여 구현하시오. 

 */

//직사각형을 표현한 클래스
class Rectangle
{
	int width;//가로길이
	int height;//세로길이
	//멤버변수 2개를 초기화할수 있는 생성자 정의
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public void showAreaInfo() {
		System.out.println("직사각형 면적:"+ (width*height));
	}
}
//정사각형을 표현한 클래스(정사각형은 직사각형의 일종)
class Square extends Rectangle
{
	//매개변수가 1개인 생성자
	public Square(int w) {
		/*
		정사각형은 직사각형의 일종이다. 우리가 만약 사각형을 그린다면
		대부분은 직사각형일 것이고 그 중 하나가 정사각형일것이다.
		정사각형은 가로, 세로 길이가 동일하므로 하나의 값으로 두개의
		멤버변수를 초기화 할 수 있다. 따라서 자식클래스에 멤버변수의
		확장은 필요하지 않다.
		 */
		super(w, w);
	}
	@Override
	public void showAreaInfo() {
		System.out.println("정사각형 면적:"+ (width*height));
	}
}
class QuRectangleMain {
	public static void main(String[] args) {
	       	Rectangle rec = new Rectangle(4, 3);
	       	rec.showAreaInfo();//단독적으로 실행하므로 반환값이 없는 메서드

     		Square sqr = new Square(7);
	       	sqr.showAreaInfo();
 	}
}




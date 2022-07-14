package ex17collection;

class Orange {
	int sugar;
	public Orange(int sugar) {
		this.sugar=sugar;
	}
	public void showInfo() {
		System.out.println("오렌지의 당도는 "+ sugar +" 입니다");
	}
}
//오렌지 전용박스 : Orange객체만 저장할 수 있는 클래스
class OrangeBox {
	Orange item;
	//저장하다(setter)
	public void store(Orange item) {
		this.item=item;
	}
	//꺼내다(getter)
	public Orange pullOut() {
		return item;
	}
}
//과일상자 : Object기반으로 모든 객체(과일)를 저장할 수 있는 클래스
class FruitBox {
	//해당 멤버변수는 모든 객체를 참조할수있다.
	Object item;
	public FruitBox(Object item) {
		this.item = item;
	}
	public void store(Object item) {
		this.item=item;
	}
	public Object pullOut() {
		return item;
	}
}

public class Ex01GenericBasic {

	public static void main(String[] args) {

		/*
		orangeBox를 생성한 후 Orange객체를 저장한다.
		그리고 Orange를 꺼낸 후 정보를 출력한다.
		 */
		OrangeBox oBox1 = new OrangeBox();
		Orange orange1 = new Orange(10);
		oBox1.store(orange1);
		orange1 = oBox1.pullOut();
		orange1.showInfo();
		/*
		상자1은 오렌지 전용박스이므로 다른과일(즉 객체)를 저장할 수 없다.
		컴파일 에러가 발생하므로 실행자체가 불가능하다.
		=> 즉 자료형에는 안전하지만, 구현에는 불편함이 있다.
		다른 객체를 저장하기 위해 또 다른 Box클래스를 생성해야 한다.
		 */
		//해당 문자열은 String객체이므로 기술 자체가 불가능하여 컴파일에러가 발생된다.
		//oBox1.store("당도가 20인 오렌지");
		Orange orange2 = oBox1.pullOut();
		orange2.showInfo();
		
		/*
		Object 기반으로 생성된 FruitBox는 구현에는 편리하나 코드레벨에서 에러가
		발생하지 않으므로 오류를 찾아내기가 훨씬 더 어렵다.
		 */
		FruitBox fBox1 = new FruitBox(new Orange(20));
		Orange orange3 = (Orange)fBox1.pullOut();
		orange3.showInfo();
		
		/*
		해당 객체는 String이므로 저장시에는 문제가 없으나, 꺼내서 사용할때
		형변환에 예외가 발생하게 된다. 즉 런타임 에러가 발생되어 발견이 
		어렵다는 단점이 있다.
		 */
		FruitBox fBox2 = new FruitBox("당도가 30인 오렌지");
		Orange orange4 = (Orange)fBox2.pullOut(); //<= 런타임 에러 발생
		orange4.showInfo();
	}
}

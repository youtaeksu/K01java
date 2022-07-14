package ex12Inheritance;
/*
instanceof 연산자
	: 인스턴스 변수가 어떤 타입의 변수인지를 판단하는 연산자로
	형변환(즉 상속관계가 있으면)이 가능하면 true, 아니면 false를 반환한다.
	-객체간의 형변환이 되려면 반드시 두 클래스간에 상속관계가
	있어야 한다.
	-부모클래스의 참조변수로 자식객체를 참조할 수 있으므로 매개변수로
	전달된 인수가 기존에 어떤 타입이었는지 확인할때 사용한다.
 */
class Box {
	public void boxWrap() {
		System.out.println("Box로 포장합니다");
	}
}
class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("PaperBox로 포장합니다");
	}
}
class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("GoldPaperBox로 포장합니다");
	}
}
public class E09InstanceOf {
	
	/*
	만약 부모타입의 매개변수로 자식 매개변수를 받을 수 없다면
	아래와 같이 각각의 타입에 따른 모든 메서드를 정의해야 할것이다.
	만약 상속관계가 더 깊어진다면 메서드는 점점 더 늘어나게 될것이다.
	따라서 부모로 자식을 참조할 수 있는것은 우리에게 편리함을 가져다준다.
	 */
//	static void wrap(Box b) {}
//	static void wrapBox(PaperBox b) {}
//	static void wrapBox(GoldPaperBox b) {}
	
	/*
	-여기서 instanceof연산자를 통해 형변환 가능여부를 판단하는 이유는
	전달된 매개변수를 최상위 클래스인 Box타입으로 받고있기 때문이다.
	-Box타입으로 인수를 받게되면 자동으로 형변환(업캐스팅) 되므로
	자식클래스의 멤버메서드를 호출할 수 없게된다.
	-이때 자식의 멤버메서드를 호출하기 위해서 강제형변환(다운캐스팅)이
	필요하다.
	-따라서 전달된 인수의 각각의 타입으로 형변환이 가능한지 판단한 후
	다운캐스팅을 진행하고 각 클래스의 멤버메서드를 호출할 수 있게된다. 
	 */
	static void wrapBox(Box b) {
		if(b instanceof GoldPaperBox) {
			((GoldPaperBox) b).goldWrap();
		}
		else if(b instanceof PaperBox) {
			((PaperBox) b).paperWrap();
		}
		else if(b instanceof Box) {
			b.boxWrap();
		}
	}
	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		//각 타입의 인수를 부모타입인 Box로 한꺼번에 받을 수 있다.
		//상속관계 있으므로 가능하다.
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		
		//String 객체와는 상속관계가 없으므로 호출불가능
		String str = new String("나는누구?");
//		//wrapBox(str); //에러발생
	}
}

package bokang;

import java.util.ArrayList;

/*
시나리오] 햄버거, 사이드메뉴, 음료수를 클래스로 추상화하여 주문후 계산할수 있는
프로그램을 상속을 통해 구현하시오. 

데이터 class
-부모 interface
	인터페이스명 : IFoods
	추상메서드 : getPrice()
-자식 class :  
	클래스명 : Hamburger, SideMenu, Drink
	 	멤버변수 : 이름, 가격
	 	멤버메서드
	 		toString() => 정보출력
	 		getPrice() => 가격반환(오버라이딩)
	
주문 class
	NormalOrder(부모) : 개별주문. 각 제품을 List에 저장한 후 가격을 합산하여 출력한다. 
	SetMenuOrder(자식) : 세트주문. List에 저장된 가격을 합산한 후 500원 할인하여 계산한다. 
*/

/*
인터페이스에
	변수를 선언하면 => public static final이 무조건 추가된다. 
		객체생성없이 즉시 사용할수 있는 인터페이스형 상수가 된다.
	메서드를 선언하면 => public abstract가 무조건 추가된다.
		추상메서드가 된다. 추상메서드는 구현부(실행부)가 없는 메서드이다.
따라서 인터페이스는 상속의 기준을 만들고, 오버라이딩의 목적으로 생성된다.
 */
interface IFoods {
	//세트할인가격
	int SALE_PRICE = 500;
	//오버라이딩을 목적으로 생성한 추상메서드
	int getPrice();
}
//햄버거 클래스
class Hamburger implements IFoods {
	//멤버변수
	private String name;
	private int price;
	//생성자
	public Hamburger(String name, int price) {
		this.name = name;
		this.price = price;
	}
	/*
	print() 메서드에서 자동으로 호출되는 toString()메서드를 오버라이딩 하면
	별도의메서드없이 객체자체를 출력할 수 있다. 그러므로 필수사항은 아니지만
	오버라이딩 하는것이 좋다.
	*/
	@Override
	public String toString() {
		return "햄버거:"+name+",가격:"+price;
	}
	//오버라이딩하여 해당 객체의 가격(price)을 반환한다.
	@Override
	public int getPrice() {
		return this.price;
	}
}
//사이드메뉴 클래스
class SideMenu implements IFoods {
	//멤버변수
	private String name;
	private int price;
	//생성자
	public SideMenu(String name, int price) {
		this.name = name;
		this.price = price;
	}
	/*
	print() 메서드에서 자동으로 호출되는 toString()메서드를 오버라이딩 하면
	별도의메서드없이 객체자체를 출력할 수 있다. 그러므로 필수사항은 아니지만
	오버라이딩 하는것이 좋다.
	*/
	@Override
	public String toString() {
		return "사이드메뉴:"+name+",가격:"+price;
	}
	//오버라이딩하여 해당 객체의 가격(price)을 반환한다.
	@Override
	public int getPrice() {
		return this.price;
	}
}
//음료수 클래스
class Drink implements IFoods {
	//멤버변수
	private String name;
	private int price;
	//생성자
	public Drink(String name, int price) {
		this.name = name;
		this.price = price;
	}
	/*
	print() 메서드에서 자동으로 호출되는 toString()메서드를 오버라이딩 하면
	별도의메서드없이 객체자체를 출력할 수 있다. 그러므로 필수사항은 아니지만
	오버라이딩 하는것이 좋다.
	*/
	@Override
	public String toString() {
		return "음료수:"+name+",가격:"+price;
	}
	//오버라이딩하여 해당 객체의 가격(price)을 반환한다.
	@Override
	public int getPrice() {
		return this.price;
	}
}
//일반주문 클래스
class NormalOrder{
	//멤버변수
	/*
	우리가 주문할 햄버거, 음료수는 모두 IFood를 구현(implements)했으므로
	부모타입인 IFood를 통해 자식 객체를 참조할 수 있다. 따라서 해당 컬렉션에는
	모든 자식타입의 객체를 저장할 수 있다.
	 */
	ArrayList<IFoods> orderList = new ArrayList<IFoods>();
	//주문금액 : 객체생성 시 무조건 0으로 초기화되어야 한다.
	int totalPayMoney = 0;
	public NormalOrder(ArrayList<IFoods> orderList) {
		this.orderList = orderList;
	}
	//장바구니에 담긴 제품들의 가격의 합계를 구해 반환
	public int payment() {
		/*
		개선된for문 사용시 항상 객체가 저장된 배열변수나 컬렉션변수를 우측에 먼저 기술한다.
		컬렉션에 저장된 객체타입을 좌측항에 기술한 후 저장된 갯수만큼 순차적으로 꺼낸 후
		참조값을 반환한다.
		 */
		for(IFoods food : orderList) {
			/*
			객체의 참조값을 즉시 print()하면 toString()메서드가 자동으로 호출되어
			오버라이딩된 내용을 출력한다. 만약 오버라이딩 하지 않으면 객체의 참조값이 
			출력된다.
			 */
			System.out.println(food);
			/*
			IFoods 로 부터 오버라이딩한  메서드를 통해 항상 해당 객체의 가격을
			반환한다. 즉 햄버거객체는 햄버거의 가격을 반환할 것이다.
			 */
			totalPayMoney += food.getPrice();
		}
		return totalPayMoney;
	}
}
//세트메뉴주문
class SetMenuOrder extends NormalOrder {
	public SetMenuOrder(ArrayList<IFoods> orderList) {
		super(orderList);
	}
	/*
	개별주문인 NormalOrder클래스를 상속하여 세트메뉴계산 부분을 확장한다.
	기본 가격에 할인된 가격을 적용하기 위해 인터페이스형 상수로 선언한 SALE_PRICE를
	차감해서 반환한다.
	 */
	@Override
	public int payment() {
		return super.payment() - IFoods.SALE_PRICE;
	}
}
public class R08Inheritance {
	public static void main(String[] args) {
		
		//메뉴생성
		Hamburger hamburger1 = new Hamburger("새우버거", 3000);
		Hamburger hamburger2 = new Hamburger("치킨버거", 4000);
		Hamburger hamburger3 = new Hamburger("치즈버거", 5000);
		
		SideMenu sideMenu1 = new SideMenu("감자튀김", 1500);
		SideMenu sideMenu2 = new SideMenu("양념감자", 2000);
		SideMenu sideMenu3 = new SideMenu("치즈스틱", 2500);
		
		Drink drink1 = new Drink("콜라", 1000);
		Drink drink2 = new Drink("사이다", 1000);
		Drink drink3 = new Drink("환타", 1000);
		
		//키오스크에서 본인이 우너하는 메뉴를 추가한다.
		ArrayList<IFoods> cart = new ArrayList<IFoods>();
		cart.add(hamburger1);
		cart.add(sideMenu1);
		cart.add(drink1);
		
		//일반 개별 주문(할인이 적용되지 않는다.)
		NormalOrder order1 = new NormalOrder(cart);
		System.out.println("결제금액:"+ order1.payment());
		
		System.out.println("---------------------------");
		
		//세트 주문(할인가 500원이 차감된다.)
		SetMenuOrder order2 = new SetMenuOrder(cart);
		System.out.println("결제금액:"+ order2.payment());
	}
}












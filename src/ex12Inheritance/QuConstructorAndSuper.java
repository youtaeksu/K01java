package ex12Inheritance;
/*
문제1) 파일명 :  QuConstructorAndSuper.java
상속관계에 놓여있는 클래스의 생성자 정의 및 호출방식을
기본으로 다음 클래스의 적절한 생성자를 삽입해보자. 
그리고 이의 확인을 위한 main 메소드도 적절히 정의해보자.
 */
class Car 
{
	int gasoline;
	public Car(int gas) {
		this.gasoline = gas;
	}
}
class HybridCar extends Car 
{
    int electric;
    public HybridCar(int ga, int el) {
    	//부모클래스로 gasoline전달
    	super(ga);
    	//해당 클래스의 멤버변수 초기화
    	this.electric = el;
    }
}
class HybridWaterCar extends HybridCar
{
	int water;
    
	//객체 생성문장을 통해 3개의 매개변수를 가진 생성자 메서드
	public HybridWaterCar(int g, int e, int w) {
		//2개의 매개변수는 부모생성자로 전달한다.
		super(g, e);
		//water(물)은 해당 클래스의 멤버변수를 초기화한다.
		this.water = w;
    }
 
    public void showNowGauge() 
    {
        System.out.println("남은가솔린:"+gasoline);
        System.out.println("남은전기량:"+electric);
        System.out.println("남은워터량:"+water);
   	}
}
/*
클래스가 상속구조를 가지고 있더라도, 클래스 개별적으로 객체를
생성하고 멤버변수를 초기화 할 수 있는 구조로 생성해야 한다.
 */
public class QuConstructorAndSuper {

	public static void main(String[] args) {
		HybridWaterCar hcar = new HybridWaterCar(10,20,30);
		hcar.showNowGauge();
	}
}



//남은가솔린:10
//남은전기량:20
//남은워터량:30

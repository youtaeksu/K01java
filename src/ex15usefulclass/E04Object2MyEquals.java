package ex15usefulclass;

/*
equals()메서드
-자바에서 인스턴스의 내용 비굘르 위해 비교연산자(==)를 사용하는것은
	단순히 참조값에 대한 비교이므로, 실제 내용에 대한 비교는 이뤄지지
	않는다.
-인스턴스간의 내용비교를 위해서는 equals() 메서드를 각 클래스에
	맞게 오버라이딩하여 사용해야한다.
-String과 같은 기본클래스는 별도의 오버라이딩 없이도 내용비교가 
	가능하다.
 */
class IntNumber {
	int num;
	public IntNumber(int num) {
		this.num = num;
	}
	/*
	equals() 메서드가 어떻게 인스턴스간의 내용을 비교하는지
	설명하가 위한 코드를 기술함.
	 */
	//비교를 위해 IntNumber타입의 객체를 매개변수로 받은 후
	public boolean myEquals(IntNumber numObj) {
		//현재 객체와 멤버변수의 값을 비교한다.
		if(this.num==numObj.num) {
			//동일하면 true를 반환한다.
			return true;
		}
		else {
			//틀리면 false를 반환한다.
			return false;
		}
	}
}
public class E04Object2MyEquals {

	public static void main(String[] args) {
		
		//String과 같은 기본클래스는 별도의 오버라이딩 없이 내용비교가 가능하다.
		String str1 = new String("우린KOSMO");
		String str2 = "우린KOSMO";
		if(str1.equals(str2)) {
			System.out.println("같은 문자열 입니다.");//결과출력
		}
		else {
			System.out.println("다른 문자열 입니다.");
		}
		
		//개발자가 직접 정의한 클래스의 객체생성
		IntNumber num1 = new IntNumber(10);
		IntNumber num2 = new IntNumber(20);
		IntNumber num3 = new IntNumber(10);
		
		//우리가 직접 정의한 myEquals메서드를 통해 객체간의 내용비교를 한다.
		if(num1.myEquals(num2)) {
			System.out.println("num1과 num2는 동일한 정수");
		}
		else {
			System.out.println("num1과 num2는 다른 정수");//결과출력
		}
		/*
		객체간의 비교를 할때에는 단순히 참조변에 대한 비교가 아닌
		실제 내용에 대한 비교를 통해 판단해야 한다.
		 */
		if(num1.myEquals(num3)) {
			System.out.println("num1과 num3는 동일한 정수");//결과출력
		}
		else {
			System.out.println("num1과 num3는 다른 정수");
		}
	}
}

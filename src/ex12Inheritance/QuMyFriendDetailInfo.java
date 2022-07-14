package ex12Inheritance;
/*
다음 상속관계에 있는 두 클래스의 적절한 생성자를 정의해보자.
main 함수에서는 MyFriendDetailInfo 클래스를 통해서 
객체를 생성해야 하고 생성된 정보를 확인할 수 있도록 해보자.
 */

//친구의 정보를 저장할 기본클래스
class MyFriendInfo{
	private String name;
	int age;
	
	/*
	멤버변수와 매개변수를 구분할 목적으로 this를 사용한다.
	이름이 같지 않더라도 명시적인 코드 작성을 위해 this를 사용하는것을
	권장한다.
	 */
	public MyFriendInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showMyFriendInfo() {
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
	}
}
//친구의 기본정보 외 상세정보를 저장할 클래스
class MyFriendDetailInfo extends MyFriendInfo
{
	private String addr;
	private String phone;
	/*
	자식클래스는 부모클래스의 객체를 먼저 생성해야할 책임이 있으므로
	항상 부모클래스의 멤버변수를 초기화하기 위한 인수까지 전달받아야 한다.
	그리고 해당 인수를 super()를 통해 부모생성자로 전달한다.
	 */
	public MyFriendDetailInfo(String name, int age, String addr, String phone) {  
		super(name, age);
		this.addr = addr;
		this.phone = phone;
	}
	public void showMyFriendDetailInfo(){
		showMyFriendInfo();
		System.out.println("주소: "+ addr);
		System.out.println("전화: "+ phone);
	}
}
class QuMyFriendDetailInfo {
	
	public static void main(String[] args) {
		//이름, 나이, 주소, 전화번호를 인자로 객체를 생성…
		MyFriendDetailInfo myFriend = 
				new MyFriendDetailInfo("유비", 55, "촉", "010-1111-2222");
			
		//정보Print
		myFriend.showMyFriendDetailInfo();
	}
}






package ex12Inheritance;

import java.util.Scanner;
/*
친구를 표현한 최상위 클래스로 해당 프로그램에서는 Friend클래스로
객체생성은 하지 않는다. 기본정보를 저장하고 상속할 목적으로 정의된
클래스이다.
이런 클래스를 VO(value Object)라고 부른다. 즉 값만 가진 객체라는 뜻이다.
 */
class Friend {
	//멤버변수 : 기본정보 3가지
	String name; //이름
	String phone; //전화번호
	String addr; //주소
	//인자생성자 
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	//멤버변수 전체 정보를 출력할 목적의 멤버메서드
	public void showAllData() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호"+ phone);
		System.out.println("주소:"+ addr);
	}
	/*
	간략 정보를 출력하는 용도의 멤버메서드로 실행부가 없는 상태로 정의한다.
	해당 프로그램에서는 오버라이딩의 목적으로만 사용하기 위해 정의한다.
	 */
	public void showBasicInfo() {}
}
//고등학교 친구 정보를 저장할 클래스
class HighFriend extends Friend {
	
	//자식에서 확장한 멤버변수
	String nickname; //별명
	
	//인자생성자
	public HighFriend(String name, String phone, String addr,
			String nickname) {
		//자식객체는 부모객체를 초기화 할 인수까지 모두 받아 super를 통해 전달한다.
		super(name, phone, addr);
		this.nickname = nickname;
	}
	/*
	고딩친구의 전체정보를 출력하기 위해 부모에서 정의된 메서드를 super를 통해
	호출하고, 자식에서 확장한 변수를 별도의 print문을 통해 출력한다.
	 */
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+ nickname);
	}
	/*
	자식에서 오버라이딩 하여 재정의한 메서드로 고딩친구의 간략한
	정보를 출력한다.
	 */
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("별명:"+ nickname);
		System.out.println("전번:"+ phone);
	}
}
//대학교 친구 정보를 저장하기 위한 클래스
class UnivFriend extends Friend {
	
	//확장한 멤버변수 : 전공과목
	String major;
	
	//생성자와 멤버메서드 모두 High클래스와 동일하다.
	public UnivFriend(String name, String phone, String addr,
			String major) {
		super(name, phone, addr);
		this.major = major;
	}
	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공:"+ major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
	}
}


/*
해당 프로그램에서 기능을 담당하는 클래스를 핸들러클래스 혹은
매니저클래스라고 한다.
 */
class FriendInfoHandler {
	
	//멤버변수
	//친구의 정보(객체의 참조값)를 저장할 Friend타입(부모)의 객체배열
	/*
	부모타입으로 객체배열을 생성하면 그 하위 자식타입의 모든 객체를 
	저장할 수 있으므로 편리하다. 여기서는 High객체와 Univ객체를 저장할 것이다.
	 */
	private Friend[] myFriends;
	/*
	객체배열의 인덱스로 사용할 변수로 초깃값은 0으로 설정된다.
	한명의 정보를 추가한 후 ++을 통해 1증가한다. 차후 해당 변수를 통해
	현재 몇명의 정보가 저장되었는지 알수있다.
	 */
	private int numOfFriends;
	
	//생성자
	public FriendInfoHandler(int num) {
		/*
		매개변수 num의 크기로 객체배열을 생성한다. 배열생성시 크기가 정해지면
		null로 초기화된다. 만약 정수타입의 배열이라면 0으로 초기화된다.
		*/
		myFriends = new Friend[num];
		//최초 실행시 저장된 객체가 없으므로 0으로 초기화한다.
		numOfFriends = 0;
	}
	//새로운 친구 연락처 추가(1:고딩친구, 2:대딩친구 정보 입력)
	public void addFriend(int choice) {
		
		//정보입력을 위한 객체생성 및 변수생성
		Scanner scan = new Scanner(System.in);
		String iName,iphone,iAddr,iNickname,iMajor;
		//기본정보 입력(연락처의 공통사항)
		/*
		해당 프로그램에서는 Friend클래스를 통해서는 객체를 생성하지 않는다.
		상속의 목적으로만 만들어졌기 때문이다.
		Friend클래스가 가진 멤버변수를 초기화한다.
		 */
		System.out.printf("이름:");iName = scan.nextLine();
		System.out.printf("전화번호:");iphone = scan.nextLine();
		System.out.printf("주소:");iAddr = scan.nextLine();
		
		/*
		1.공통정보에 이어 추가정보를 입력받는다.
		2.객체배열의 0번 index에 객체를 저장한다.
		3.numOfFrineds를 1 증가 시킨다. 후위증가이므로 배열에 먼저 저장된 후
		증가된다.
		 */
		if(choice==1) {
			//고딩친구인 경우 별명을 추가로 입력한다.
			System.out.println("별명:"); iNickname = scan.nextLine();
			
			//객체생성후 참조변수에 저장한 후 객체배열에 추가한다.
			HighFriend high = new HighFriend(iName, iphone, iAddr, iNickname);
			myFriends[numOfFriends++] = high;
		}
		else if(choice==2) {
			//대딩친구인 경우 전공을 추가로 입력한다.
			System.out.println("전공:"); iMajor = scan.nextLine();
						
			//객체생성과 동시에 객체배열에 추가한다.
			myFriends[numOfFriends++] = new UnivFriend(iName, iphone, iAddr, iMajor);
		}
		/*
		각 객체를 생성 및 초기화한 후 객체배열에 추가하면 Friend타입으로 
		자동형변환(업캐스팅)이 된다. 부모타입의 참조변수로 자식객체를 참조할 수 
		있다는 사실을 통해 이와같은 기능을 구현할 수 있다. 
		 */
		
		System.out.println("친구정보 입력이 완료되었습니다.");
	}////end of addFriend

	/*
	친구의 정보를 출력하기 위한 멤버메서드
	1.친구정보를 추가할때 High 혹은 Univ객체를 배열에 저장한다.
	2.입력시 모든 객체는 Friend로 자동형변환(업캐스팅)되어 저장된다.
	3.정보 출력시 배열에 입력된 객체수만큼 반복하여 각 요소를 통해
		정보(멤버변수에 저장된 값)를 출력한다.
	4.출력을 위한 멤버메서드는 상속관계에서 오버라이딩 처리되어 있으므로
		참조변수의 영향을 받지 않고 항상 자식객체에 오버라이딩 정의한
		멤버메서드가 호출된다.
	5.즉, 저장된 객체는 Friend타입이지만 오버라이딩을 통해 별도의 형변환이
		필요하지 않다. 항상 원하는 정보를 출력할 수 있게 된다.
	 */
	//전체정보 출력용
	public void showAllData() {
		for(int i=0 ; i<numOfFriends ; i++) {
			myFriends[i].showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	//간략정보 출력용
	public void showSimpleData() {
		for(int i=0 ; i<numOfFriends ; i++) {
			myFriends[i].showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다==");
	}
	
	//주소록 검색
	public void searchInfo() {
		//검색한 정보가 존재하는지 확인하기 위한 변수
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		/*
		정보를 검색하기 위해 주로 배열의 크기만큼 반복하는것이 일반적이나
		해당 프로그램에서 아래와 같이 배열.length를 사용하지 않는 이유는
		정보가 없는 인덱스는 모두 null 이기 때문이다. 따라서 정보의 갯수를
		저장하고 있는 numOfFriends를 사용한다.
		 */
//		for(int i=0 ; i<myFriends.length ; i++) {
		//객체배열에 저장된 정보의 갯수만큼 반복해서 검색한다.
		for(int i=0 ; i<numOfFriends ; i++) {
			/*
			배열의 각 인덱스에 저장된 객체의 참조값을 통해 멤버변수를 접근한다.
			검색을 위해 입력한 이름과 비교해서 일치하는 경우에만 정보를 출력한다.
			이때 compareTo() 대신 equals()를 사용해도 된다.
			 */
//			if(searchName.compareTo(myFriends[i].name)==0) {
			if(searchName.equals(myFriends[i].name)) {
				myFriends[i].showAllData();
				System.out.println("***귀하가 요청하는 정보를 찾았습니다.***");
				//정보를 찾은 경우 출력후 아래 변수를 true로 변경한다.
				isFind = true;
			}
		}
		//만약 검색한 정보가 없다면 아래와같이 출력해준다.
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다.***");
	}///end of searchInfo
	//주소록 삭제
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		/*
		배열의 원소 중 삭제된 원소의 인덱스값을 저장할 용도의 변수
		원소를 삭제한 후 빈자리를 채워넣을때 사용한다.
		배열의 인덱스는 0부터 시작이므로 -1로 초기화한다.
		 */
		int deleteIndex = -1;
		
		//삭제할 객체를 찾기위해 저장된 데이터만큼 반복
		for(int i=0 ; i<numOfFriends ; i++) {
			//삭제할 객체가 있는지 검색
			if(deleteName.compareTo(myFriends[i].name)==0) {
				/*
				객체배열에서 삭제는 null로 변경하면 된다. 객체의 참조값이 null이란
				거서은 참조할 객체가 없다는 것이므로 이와같이 처리하면 된다.
				 */
				myFriends[i] = null;
				//삭제된 원소의 index를 저장한다.
				deleteIndex = i;
				//전체카운투를 1 차감한다.
				numOfFriends--;
				//하나의 객체를 삭제했다면 즉시 for문을 탈출한다.
				break;
			}
		}
		
		if(deleteIndex==-1) {
			//검색된 데이터가 없어 삭제되지 않았다면 -1을 유지한다.
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			/*
			객체배열에서 검색된 원소를 삭제한 후 입ㅂ력된 위치의 바로 뒤
			원솔르 앞으로 하나씩 복사한다.
			numOfFriend는 앞에서 1 차감되므로 마지막 원소는 검색이나 출력에서
			무시된다.
			 */
			for(int i=deleteIndex ; i<numOfFriends ; i++) {
				myFriends[i] = myFriends[i+1];
			}
			System.out.println("==데이터("+ deleteIndex +"번)가 삭제되었습니다==");
		}
	}////end of deleteInfo
}
public class E10MyFriendInfoBook 
{
	/*
	매개변수도 없고 반환타입도 없는 메서드
	: 해당 프로그램에서 메뉴를 출력하는 용도로 정의함.
	 */
	public static void menuShow() {
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1.고딩친구입력 ");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보출력 ");
		System.out.println("4.간략정보출력");
		System.out.print("5.검색 ");
		System.out.print("6.삭제 ");
		System.out.println("7.프로그램종료");
		System.out.print("메뉴선택>>>");
	}
	
	/*
	메인 메서드는 해당 프로그램의 시작점(Entry point)이므로 복잡한 로직의
	구성보다는 프로그램의 전반적인 흐름에 대해서만 기술하는것이 좋다.
	따라서 선택한 메뉴에 따라 핸들러 클래스의 메서드만 호출하는 형태로
	구현되어 있다.
	 */
	public static void main(String[] args)
	{
		//사용자 입력을 위한 객체 생성
		Scanner scan = new Scanner(System.in);
		/*
		기능을 담당하는 핸들러(메니저) 클래스의 객체를 생성
		초깃값으로 100명의 정보를 저장할 수 있는 Friend타입의 객체배열을 생성한다. 
		 */
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		/*
		무한루프 조건으로 특정 입력에만 종료할 수 있는 구조를 만들어준다.
		break문은 반복문을 탈출시키는 기능이 있으므로 이와같은 무한루프에서는
		자주 사용된다.
		또한 for(;;) 문을 통해 무한루프를 구현할 수 있으나 반복의 횟수가 정확하지
		않은 경우에는 while문을 주로 사용한다.
		 */
		while(true) {
			
			//메뉴를 출력한다.
			menuShow();
			
			//사용자는 수행할 기능의 메뉴를 선택한다.
			int choice = scan.nextInt();
			
			//선택한 메뉴를 수행할 수 있는 메서드를 switch문을 통해 호출한다.
			switch(choice) {
			case 1: case 2:
				//고딩/대딩 친구 입력
				handler.addFriend(choice);
				break;//break문을 만나면 switch문을 탈출한다.
			case 3:
				//전체정보출력
				handler.showAllData();
				break;
			case 4:
				//간략정보출력
				handler.showSimpleData();
				break;
			case 5:
				//검색
				handler.searchInfo();
				break;
			case 6:
				//삭제
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램종료");
				return;//main의 종료는 프로그램의 종료로 이어진다.
			}////switch 끝
		}////while 끝	
	}////main 끝
}////class 끝




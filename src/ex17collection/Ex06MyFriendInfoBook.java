package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	/*
	기존 객체배열에 저장하던 방식을 List계열의 컬렉션으로 변경한다.
	우리는 배열과 동일한 특징을 가지고 있는 ArrayList<E>로 객체를 생성한다.
	해당 컬렉션에는 Friend타입의 객체를 저장할 것이다. 따라서 상속관계가 있는
	하위 객체들을 모두 저장할 수 있다.
	 */
	private ArrayList<Friend> myFriends;
	
	public FriendInfoHandler(int num) {
		//멤버변수로 선언한 List컬렉션의 객체를 생성한다.
		myFriends = new ArrayList<Friend>();
		
		//List<E>계열의 컬렉션은 인덱스가 존재하긴 하나 자동 인덱싱을 지원하므로
		//인덱스 저장을 위한 변수는 필요없다.
		//numOfFriends = 0;
	}
	public void addFriend(int choice) {
		
		//친구의 공통정보 입력받음
		Scanner scan = new Scanner(System.in);
		String iName,iphone,iAddr,iNickname,iMajor;
		System.out.printf("이름:");iName = scan.nextLine();
		System.out.printf("전화번호:");iphone = scan.nextLine();
		System.out.printf("주소:");iAddr = scan.nextLine();
		
		/*
		List<E> 컬렉션에 객체를 추가할때는 add()메서드를 사용한다.
		추가하면 자동으로 인덱스가 부여되므로 별도의 처리가 필요하지 않다.
		단, 인덱스를 건너뛸수는 없다.
		 */
		if(choice==1) {
			System.out.println("별명:"); iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName, iphone, iAddr, iNickname);
			
			myFriends.add(high);
		}
		else if(choice==2) {
			System.out.println("전공:"); iMajor = scan.nextLine();
			
			myFriends.add(new UnivFriend(iName, iphone, iAddr, iMajor));
		}
		/*
		각 객체를 생성 및 초기화한 후 객체배열에 추가하면 Friend타입으로 
		자동형변환(업캐스팅)이 된다. 부모타입의 참조변수로 자식객체를 참조할 수 
		있다는 사실을 통해 이와같은 기능을 구현할 수 있다. 
		 */
		
		System.out.println("친구정보 입력이 완료되었습니다.");
	}////end of addFriend

	//정보출력1 : 일반for문
	public void showAllData() {
		/*
		컬렉션에 저장된 객체의 갯수만큼 반복한다. size()메서드를 통해
		얻어올 수 있다.
		 */
		for(int i=0 ; i<myFriends.size() ; i++) {
			myFriends.get(i).showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	
	//정보출력2 : 확장for문
	public void showSimpleData() {
		/*
		ArrayList<E>에는 Friend타입의 객체가 저장되어있다.
		따라서 확장 for문을 통해 하나씩 꺼내는 객체는 Friend타입이다.
		showBasicInfo()메서드는 오버라이딩 되었으므로 항상 최하위의 메서드가
		호출되어 고딩친구 혹은 대딩친구의 정보를 출력할 수 있다.
		 */
		for(Friend f : myFriends) {
			f.showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다==");
	}
	//주소록 검색
	public void searchInfo() {
		//검색한 정보가 없는경우 false를 유지한다.
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		//이터레이터를 통해 검색기능 구현하기
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext()) {
			Friend fr = itr.next();
			if(searchName.equals(fr.name)) {
				System.out.println("# 귀하가 요청하는 정보를 찾았습니다 #");
				fr.showAllData();
				//정보를 찾으면 true로 변경한다.
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다.***");
	}///end of searchInfo
	//주소록 삭제
	
	public void deleteInfo() {
		
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext()) {
			Friend fr = itr.next();
			if(deleteName.equals(fr.name)) {
				myFriends.remove(fr);
				System.out.println("# 정보가 삭제되었습니다 #");
				isFind = true;
				break;
			}
		}
		
		if(isFind==false) System.out.println("# 찾는 정보가 없습니다 #");
	}////end of deleteInfo
}
public class Ex06MyFriendInfoBook 
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




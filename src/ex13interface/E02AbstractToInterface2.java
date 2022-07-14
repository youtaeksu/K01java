package ex13interface;

/*
추상클래스를 인터페이스로 변경하기
	abstract class => interface
	메서드인 경우 public abstract 제거
	멤버변수인 경우 public static final 제거
 */
interface PersonalNumberStorageAbs2 {

	void addPersonalInfo(String juminNum, String name);
	String searchPersonalInfo(String juminNum);
}
class PersonalInfoDTO2   {
	private String name;
	private String juminNum;
	//생성자
	public PersonalInfoDTO2(String name, String juminNum) {
		super();
		this.name = name;
		this.juminNum = juminNum;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getJuminNum() { return juminNum; }
	public void setJuminNum(String juminNum) { this.juminNum = juminNum; }
}

/*
클래스가 클래스를 상속할때 => extends
클래스가 인터페이스를 상속할때 => implements
매우 드물지만 인터페이스가 인터페이스를 상속할때 => extends

또한 extends은 "상속"이라 하고, implements는 "구현"이라 표현한다.
 */
class PersonalNumberStorageExt2 implements PersonalNumberStorageAbs2 {
	
	//정보저장용 객체배열과 인덱스 카운트용으로 사용할 멤버변수
	PersonalInfoDTO2[] personalArr;
	int numOfPerInfo;
	//생성자에서 초기화
	public PersonalNumberStorageExt2(int arrSize) {
		personalArr = new PersonalInfoDTO2[arrSize];
		numOfPerInfo = 0;
	}
		
	/*
	상속을 통해 추상메서드를 포함하게 되었으므로 반드시 아래와 같이 오버라이딩
	해야한다. 이는 필수사항이며 하지않을 경우 에러가 발생한다.
	 */
	
	/*
	주민번호와 이름을 매개변수로 받아서 DTO 객체를 생성한 후 객체배열에 저장한다.
	다음 저장을 위해 인덱스로 사용할 변수를 1 증가시킨다.
	 */
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo] = new PersonalInfoDTO2(name, juminNum);
		numOfPerInfo++;
	}
	/*
	주민번호를 매개변수로 받은후 객체배열에 일치하는 정보가 있는지
	검색한 후 결과가 있는경우 해당 객체의 이름을 출력한다.
	 */
	@Override
	public String searchPersonalInfo(String juminNum) {
		/*
		DTO객체의 멤버변수는 private으로 선언되었으므로 외부에서는 접근이
		불가능하여 getter를 통해 접근해야 한다.
		 */
		for(int i=0 ; i<numOfPerInfo ; i++) {
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0)
			{
				return personalArr[i].getName();
			}
		}
		//결과가 없다면 null을 반환한다.
		return null;
	}	
}

public class E02AbstractToInterface2 {

	public static void main(String[] args) {
		
		//정보저장용 객체 생성
		PersonalNumberStorageExt2 storage = new PersonalNumberStorageExt2(10);
		
		//2개의 정보를 추가
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//정보를 검색한다.
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("001024-1090333"));
	}
}

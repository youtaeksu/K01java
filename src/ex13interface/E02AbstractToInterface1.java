package ex13interface;

//프로젝트 전체에서 기준의 역활을 하는 (추상클래스) - 명시적으로 Abs
abstract class PersonalNumberStorageAbs {
	/*
	해당 클래스는 추상 메서드를 포함하고 있으므로 상속받게되면
	하위 클래스에서는 반드시 추상메서드를 오버라이딩 해야 한다.
	 */
	public abstract void addPersonalInfo(String juminNum, String name);
	public abstract String searchPersonalInfo(String juminNum);
}
/*
DTO(Data Transfer Object) : 데이터를 저장하고 전송하기 위한 용도의 객체를 말한다.
	VO(Value Object)라고 표현하기도 한다.
	해당 프로그램에서는 한 사람의 정보를 저장하는 용도로 사용된다.
 */
class PersonalInfoDTO   {
	private String name;
	private String juminNum;
	//생성자
	public PersonalInfoDTO(String name, String juminNum) {
		super();
		this.name = name;
		this.juminNum = juminNum;
	}
	/*
	getter/setter메서드 : DTO객체에서 private으로 선언된 멤버변수의 값을
		설정하거나 반환할때 사용한다.
	 */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getJuminNum() { return juminNum; }
	public void setJuminNum(String juminNum) { this.juminNum = juminNum; }
}

/*
제공된 추상클래스를 상속하여 사람의 정보를 저장하는 기능과 검색의 기능을
구현한다.
 */
class PersonalNumberStorageExt extends PersonalNumberStorageAbs {
	
	//정보저장용 객체배열과 인덱스 카운트용으로 사용할 멤버변수
	PersonalInfoDTO[] personalArr;
	int numOfPerInfo;
	//생성자에서 초기화
	public PersonalNumberStorageExt(int arrSize) {
		personalArr = new PersonalInfoDTO[arrSize];
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
		personalArr[numOfPerInfo] = new PersonalInfoDTO(name, juminNum);
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

public class E02AbstractToInterface1 {

	public static void main(String[] args) {
		
		//정보저장용 객체 생성
		PersonalNumberStorageExt storage = new PersonalNumberStorageExt(10);
		
		//2개의 정보를 추가
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//정보를 검색한다.
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("001024-1090333"));
	}
}

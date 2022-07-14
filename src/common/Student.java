package common;

public class Student extends Person
{
	//자식에서 확장한 멤버변수
	private String stNumber;
	public Student(String name, int age, String stNumber)
	{
		//자식객체 생성전 반드시 부모생성자를 먼저 호출해야함.
		super(name, age);
		this.stNumber = stNumber;
	}
	//부모의 toString()메서드 호출을 통해 정보반환 및 확장된 변수 출력
	@Override
	public String toString()
	{
		return super.toString() +", 학번:"+ stNumber;
	}
}

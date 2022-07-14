package ex07string;

/*
StringBuffer 클래스
	: String 클래스는 기준 문자열에 새로운 문자열을 추가하면 새롭게 생성된
	메모리에 문자열을 저장한다. 기존 메모리가 소멸되고 새로운 메모리가 생성되는
	낭비를 막기위해, 문자열의 변경이 많은 경우라면 StringBuffer클래스를 주로
	사용한다. 해당 클래스는 기존 메모리의 문자열을 변경하는 방식으로 문자열을
	추가한다.
 */
public class E03StringBuilderBuffer {

	public static void main(String[] args) {

		/*
		append() : 문자열의 끝에 새로운 문자열을 연결한다.
		insert() : 지정한 인덱스 위치에 문자열을 삽입한다.
		 */
		StringBuffer strBuf = new StringBuffer("AB");
		strBuf.append(25);//정수 추가
		strBuf.append("Y").append(true);//문자열과 boolean값 연결
		System.out.println("strBuf="+ strBuf);
		/*
		append()메서드는 모든 타입의 자료를 사용할 수 있도록 오버로딩 되어있다.
		 */
		
		strBuf.insert(2, false);//인덱스 2에 false삽입
		strBuf.insert(strBuf.length(), 'Z');//마지막 부분에 문자 삽입
		System.out.println("strBuf="+ strBuf);
		
		
		
		System.out.println("String 과 StringBuffer의 " + "참조값 비교");
		String str1 = "코스모";
		String str2 = "코스모";
		if(str1==str2)
			System.out.println("연결전:주소값동일");//[출력]
		else
			System.out.println("연결전:주소값다름");
		
		str1 = str1 + " 영원하라";
		if(str1==str2)
			System.out.println("연결후:주소값동일");
		else
			System.out.println("연결후:주소값다름");//[출력]
		
		/*
		문자열을 저장할 기본메모리는 16이지만 저장할 문자열이 늘어나면
		알아서 메모리를 확장한다.
		 */
		StringBuffer buf = new StringBuffer();
		System.out.println("buf="+ buf);
		System.out.println("저장된 문자열크기:"+buf.length());
		System.out.println("기본버퍼크기:"+ buf.capacity());
		
		buf.append("KOSMO");
		System.out.println("buf="+ buf);
		System.out.println("저장된 문자열크기:"+buf.length());
		System.out.println("기본버퍼크기:"+ buf.capacity());
		
		buf.append(" 금일은 StringBuffer공부중임")
			.append(" 오늘은 수욜~~~^^");
		System.out.println("buf="+ buf);
		System.out.println("저장된 문자열크기:"+buf.length());
		System.out.println("기본버퍼크기:"+ buf.capacity());
	}
}

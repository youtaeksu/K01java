/*
패키지 선언부 : 현재 작성하는 클래스의 위치를 결정하기 위한 선언으로
	packageMain클래스는 ex09package 패지키에 생성된다.
 */
package ex09package;

/*
임폴트 선언부 : 현재 작성하는 클래스에 다른 클래스를 가져다 쓰기 위한 선언으로
	클래스가 생성된 패키지명과 클래스명을 함께 작성하면 된다.
	만약 해당 패키지하위에 선언된 모든 클래스를 한꺼번에 임포트하고 싶다면
	import java.util.* 와 같이 와일드카드를 사용하면 된다. 
 */
import java.util.Date;
import ex09package.kosmo.util.CommonUtil;
/*
import java.util.*;
import ex09package.kosmo.util.*; => 이와같이 임포트 해도된다.
 */

public class E01PackageMain 
{
	public static void main(String[] args) 
	{
		/*
		하나의 클래스안에서 패키지는 다르나 같은 이름의 클래스를 사용해야 한다면
		방법1 : 클래스명 앞에 패키지명 전체를 기술한다. 보통 클래스의 풀경로라고
			표현한다.
		방법2 : 하나의 클래스는 import하고, 다른 하나는 패키지명 전체를 기술한다.
		 */
		Date utilDate = new Date();
		System.out.println("utilDate="+ utilDate);
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("sqlDate="+ sqlDate);
		
		
		/*
		ex09package 하위에 ex09package.kosmo.util 패키지가 생성되지만
		이 둘은 서로 다른 패키지로 인식한다.
		따라서 isNumber() 메서드를 호출하기 위해 받드시 해당 패키지를
		import 해야한다.
		 */
		String strValue = "987654321";
		boolean isNum = CommonUtil.isNumber(strValue);
		if(isNum==true)
			System.out.println("문자열은 숫자입니다.");
		else
			System.out.println("숫자가 아닙니다.");
				
		System.out.println(ex09package.kosmo.util.CommonUtil.isNumber("백20"));
	}
}

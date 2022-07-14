package ex15usefulclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class E05Date {

	/*
	Calendar클래스를 통해 얻은 객체를 초로 변환하나 후 매개변수로 전달된
	날짜서식으로 변경한 후 반환한다.
	getTime() : 서버의 표준시인 1970-01-01부터 현재까지의 시간을 초 단위로
		반환해준다.
	 */
	public static String myDateFormat(Calendar c, String formatStr) {
		Date date = c.getTime();
		return new SimpleDateFormat(formatStr).format(date);
	}
	public static void main(String[] args) {
		
		//Calendar클래스는 대표적인 싱글톤 객체이므로 new로 생성하지 않는다.
		Calendar calendar = Calendar.getInstance();
		
		//여러가지 서식 사용하기
		/*
		월을 표현하는 Month, 분을 표현하는 minute의 이니셜이 동일하기때문에 
		구분을 위해 월은 대문자, 분은 소문자로 표현한다. 
		 */
		String nowStr1 = myDateFormat(calendar, "yyyy-MM-dd HH:mm:ss");
		System.out.println("현재1:"+ nowStr1);
		String nowStr2 = myDateFormat(calendar, "오늘은 M월의 W번째주, d번째날, F번째 E요일");
		System.out.println("현재2:"+ nowStr2);
		
		/*
		현재 날짜를 기준으로 전/후를 구하기 위해 add() 메서드를 사용한다.
		만약 음수를 주면 과거의 날짜를 구할 수 있다.
		 */
		//첫번째 인수에 사용한 상수에 따라 일, 월, 년을 적용할 수 있다.
		calendar.add(Calendar.DATE, 3);//3일후의 날짜
		calendar.add(Calendar.MONTH, 2);//2달후
		calendar.add(Calendar.YEAR, 1);//1년후
		
		//add()메서드를 앞에서 3번 호출했으므로 결과는 다음과 같다.
		String nowStr3 = myDateFormat(calendar, "yyyy년 MM월 dd일");
		System.out.println("1년2개월3일후:"+ nowStr3);
		
		
		/*
		올해 크리스마스까지 남은 날짜를 계산한다. 여기서는 두가지 서식의 날짜를
		파싱하여 구한 날짜객체를 통해 계산한다.
		 */
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String future = "2022/12/25";
		System.out.println(today+" "+future);
		long result = myDiffDate(today, future);
		System.out.println(today+ "에서 "+ future +"까지 남은날짜:"+ result);
	}
	public static long myDiffDate(String today, String future) {
		long diffDays = 0;
		try {
			//각 날짜 서식을 적용하여 날짜객체(Date)로 변환한다.
			Date formatToday = new SimpleDateFormat("yyyy-MM-dd").parse(today);
			Date formatFuture = new SimpleDateFormat("yyyy/MM/dd").parse(future);
			System.out.println(formatToday+" "+formatFuture);
			
			/*
			getTime()으로 얻어오는 시간은 총 13자리의 정수값인데 1~10까지는 순수한 초이고,
			11~13자리는 밀리세컨즈를 의미한다.
			즉 1000으로 나눠서 뒤의 3자리를 제거하면 순수한 초가 반환된다.
			또한 하루는 24*60*60=86400초 이므로 아래와 같이 남은 날짜를 구할 수 있다.
			 */
			diffDays = (formatFuture.getTime() - formatToday.getTime())
					/ (24*60*60*1000);
		}
		catch (Exception e) {}
		//계산된 남은 날짜를 반환한다.
		return diffDays;
	}
}

package ex09package.kosmo.util;

public class CommonUtil 
{
	/*
	인수로 전달된 문자열을 검사하여 숫자가 아닌 문자가 포함된 경우
	false를 반환하고, 모두 숫자인 경우에만 true를 반환한다.
	 */
	
	public static boolean isNumber(String strValue) {
		
		//전달된 문자열이 빈 문자열이라면 검사할 필요가 없으므로 false를 반환한다.
		if(strValue.length()==0)
			return false;

		//문자열의 길이만큼 반복..
		for(int i=0 ; i<strValue.length(); i++) {
			//각 문자의 아스키코드를 반환한다.
			int acode = strValue.codePointAt(i);
			//만약 문자가 숫자가 아니라면 즉시 false를 반환한다.
			if( !(acode>='0' && acode<='9') ){
				return false;
			}
		}
		//위 조건을 통과하면 숫자이므로 true를 반환한다.
		return true;
	}
}

package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

/*
Java에서 Oracle함수 호출하기

오라클에서 정의한 함수를 실행하기 위한 CallableStatement객체 생성
-Connection 객체의 prepareCall() 메서드 호출을 통해 생성한다.
-형식
	prepareCall("{ ? = call 함수명(인수1, 인수2,....N)}");
-첫번째 물음표는 반환값을 의미한다.
	반환값은 파라미터 설정시 java.sql.Types 클래스의 자료형으로 설정한다.
 */
public class FunctionCall extends IConnectImpl{
	
	//기본생성자를 통한 DB연결
	public FunctionCall() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			/*
			callable 객체생성
				? = call 함수명(?)
				첫번째 파라미터 : 함수 실행후 반환값 저장
				두번째 파라미터 : 함수 호출시 전달할 값
			*/
			csmt = con.prepareCall("{? = call fillAsterik(?)}");
			//반환값의 자료형 설정
			csmt.registerOutParameter(1, Types.VARCHAR);
			//인파라미터 설정
			csmt.setString(2, scanValue("아이디"));
			//함수실행
			csmt.execute();
			System.out.println("함수의반환값:"+ csmt.getString(1));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new FunctionCall().execute();
	}
}

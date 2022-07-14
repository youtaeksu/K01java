package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
상속을 목적으로 생성하는 추상클래스. 오라클 DB연결과 자원반납을
담당한다. 추상클래스는 객체는 생성할 수 없지만 참조변수 선언 상속등의
기능은 사용할 수 있다.
 */
public abstract class ConnectDB {
	
	//상속관계에서 접근이 가능한 protected 접근지정자로 멤버변수 선언
	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;
	
	//생성자1 : 계정 아아디, 패스워드를 매개변수로 받음
	//생성자2 : 고정된 값으로 DB연결
	public ConnectDB(String id, String pw) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					id, pw);
			System.out.println("오라클 DB 연결성공");
		}
		catch (ClassNotFoundException e) {
			System.out.println("DB 연결 실패");
		}
		catch(Exception e) {
			System.out.println("알수 없는 예외발생");
			e.printStackTrace();
		}
	}

	
	public ConnectDB() {
		try {
			//드라이버 로드 및 오라클 DB연결
			Class.forName("oracle.jdbc.OracleDriver");
		    con = DriverManager.getConnection(
		    		"jdbc:oracle:thin:@localhost:1521:xe",
		    		"kosmo", "1234");
		    System.out.println("오라클 DB 연결성공");
		}
        catch (ClassNotFoundException e) {
        	System.out.println("오라클 드라이버 로딩 실패");
        	e.printStackTrace();
        }
		catch (SQLException e) {
        	System.out.println("DB 연결 실패");
        	e.printStackTrace();
     	}
		catch (Exception e) {
			System.out.println("알수 없는 예외발생");
			e.printStackTrace();
	    }
	}
	//자원반납
	public void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("DB자원반납완료");
		}
		catch(SQLException e) {
			System.out.println("자원반납시 오류가 발생하였습니다.");
		}
	}//end of close
	/*
	상속관계에서 오버라이딩을 목적으로 생성한 추상메서드.
	하위 클래스에서 각 업무에 따라 재정의 한다.
	 */
	abstract void execute();
}

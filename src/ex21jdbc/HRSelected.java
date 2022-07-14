package ex21jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HRSelected {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pass = "1234";
			
			Connection con = DriverManager.getConnection(url,id,pass);
			if(con!=null) {
				System.out.println("Oracle 연결성공");
				
				/*
				1. 쿼리문작성
				: 쿼리문을 작성할때 주의할점은 줄바꿈을 할때 앞뒤로 스페이스를 삽입하는것이
				좋다. 그렇지 않으면 문장이 서로 이어지게 되어 SyntaxError가 발생하게된다.
				 */
				String sql = "SELECT * FROM employees WHERE "
						+ " department_id=50 "
						+ " ORDER BY employee_id desc";
				/*
				2.쿼리문 전송을 위해 Statement 인터페이스를 통해 객체를 생성한다.
				 */
				Statement stmt = con.createStatement();
				/*
				3.쿼리문을 전송한 후 실행한 결과를 ResultSet객체를 통해 반환받는다.
				해당 객체는 select쿼리를 실행했을때만 사용한다.
				 */
				ResultSet rs = stmt.executeQuery(sql);
				/*
				4.반환된 결과를 갯수만큼 반복하여 출력한다. next() 메서드는 출력할
				레코드가 남아있는지 확인하고, 더이상 레코드가 남아있지 않다면 false를
				반환한다.
				 */
				while(rs.next()) {
					/*
					5.getXXX() 메소드를 통해 각 컬럼에 접근할 수 있다. 오라클의 자료형은
					숫자, 문자, 날짜 3가지 형태이므로 메서드도 이와 동일한 형태를 가지고있다.
					각 컬럼에 접근할때는 인덱스와 컬럼명 두가지를 사용할 수 있다.
					 */
					String emp_id = rs.getString(1);
					String f_name = rs.getString("first_name");
					String l_name = rs.getString("last_name");//인덱스 3을 써도 동일하다.
					java.sql.Date h_date = rs.getDate("hire_date");
					int sal = rs.getInt("salary");
					System.out.printf("%s %s %s %s %s\n",
							emp_id, f_name, l_name, h_date, sal);
				}
				/*
				6.자원반납(해제) : 모든 작업을 마친후에는 메모리 절약을 위해
				연결했던 자원을 반납한다.
				 */
				rs.close();
				stmt.close();
				con.close();
				
			}
			else {
				System.out.println("Oracle 연결실패");
			}
		}
		catch(Exception e) {
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
		}
	}
}

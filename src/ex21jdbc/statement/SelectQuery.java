package ex21jdbc.statement;

import java.sql.SQLException;

public class SelectQuery extends ConnectDB {

	public SelectQuery() {
		super();
	}
	
	/*
	ResultSet클래스
		:select문 실행시 쿼리의 실행결과가 ResultSet객체에 저장된다.
		결과로 반환된 레코드의 처음부터 마지막까지 next()메서드를 통해 확인후
		반복 인출한다.
		
		컬럼의 자료형이
			number타입 : getInt()
			char/varchar2타입 : getString()
			date타입 : getDate() 메서드를 통해 출력한다.
		해당 메서드의 매개변수는 인덱스(1부터시작) 혹은 컬럼명을 사용할 수 있다.
		오라클 자료형에 상관없이 getString()으로 모두 출력할 수 있다.
	 */
	
	//@override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			/*
			regidate는 date타입으로 선언된 컬럼으로 to_char()함수를 사용하면
			문자형(varchar2)으로 변환해서 select 할 수 있다. 해당 컬럼은 별칭으로
			d1을 사용한다.
			 */
			String query = "SELECT id, pass, name, regidate,"
				+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') d1 "
				+ " FROM member";
			/*
			쿼리실행시 사용하는 메서드
			executeUpdate()
				: 쿼리문이 insert, update, delete와 같이 기존 레코드에 변화가 
				생기는경우 사용한다. 실행후 영향을 받은 행의 갯수를 int형으로 반환한다.
			executeQuery()
				: select 쿼리를 실행할때 호출하는 메서드로 레코드에 영향을 미치지 않고
				조회만 하는 경우 사용한다.
				조회한 레코드를 반환값으로 받아야 하므로 ResultSet객체를 반환타입으로
				사용한다.
			 */
			rs = stmt.executeQuery(query);
		
			while(rs.next()) {
				String id = rs.getString(1);//id컬럼
				String pw = rs.getString("pass");
				String name = rs.getString("name");
				
				/*
				오라클의 date타입을 getDate()로 추출하면 0000-00-00형태로 출력된다.
				또한 자료형이 Date이므로 java.sql패키지의 클래스를 사용해야 한다.
				 */
				java.sql.Date regidate = rs.getDate("regidate");
				/*
				날짜를 getString()으로 추출하면 시간까지 포함해서 출력된다.
				0000-00-00 00:00:00 형식이므로 적당한 크기로 자르고 싶다면 substring()
				메서드를 사용해야 한다.
				 */
				String regidate2 = rs.getString("regidate");
				String regidate3 = rs.getString("regidate").substring(0,13);
				/*
				쿼리문에 별칭을 사용한 경우 별칠을 통해 출력할 수 있다.
				즉 컬럼명, 인덱스, 별칭을 통해 컬럼에 저장된 값을 추출한다.
				 */
				String regidate4 = rs.getString("d1");
				
				System.out.printf("%s %s %s %s %s %s %s\n",
						id, pw, name, regidate,
						regidate2, regidate3, regidate4);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close();//DB 자원반납
		}
	}
	public static void main(String[] args) {
		SelectQuery selectSQL = new SelectQuery();
		selectSQL.execute();
	}
}

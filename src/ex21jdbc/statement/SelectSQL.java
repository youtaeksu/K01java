package ex21jdbc.statement;

import java.sql.SQLException;

import ex21jdbc.connect.IConnectImpl;

public class SelectSQL extends IConnectImpl {
	
	public SelectSQL() {
		super("kosmo","1234");
	}
	
	@Override
	public void execute() {
		try
		{
			/*
			prepared 객체를 통해 인파라미터를 설정하면 문자인 경우 자동으로
			싱글쿼테이션을 추가하게 되므로 || 연산자를 사용해야 한다.
			 */
			while(true)
			{
				String sql = "SELECT * FROM member "
					//+ " WHERE name LIKE '%?%'"; //에러방생 : 부적합한 열 인덱스
					+ " WHERE name LIKE '%'||?||'%'";
				
				psmt = con.prepareStatement(sql);
				psmt.setString(1, scanValue("찾는이름"));
				rs = psmt.executeQuery();
				while(rs.next()) {
					String id = rs.getString(1);
					String pass = rs.getString(2);
					String name = rs.getString(3);
					//날자를 문자형으로 추출하면 시간까지 출력되므로 날짜부분만 잘라서 출력
					String regidate = rs.getString(4).substring(0, 10);
					
					System.out.printf("%s %s %s %s\n",
							id, pass, name, regidate);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new SelectSQL().execute();
	}

}

package ex21jdbc.statement;

import java.sql.SQLException;

//추상클래스를 상속하여 정의
public class UpdateQuery extends ConnectDB{

	//부모클래스의 생성자를 통해 DB연결
	public UpdateQuery(String user, String pass) {
		super(user, pass);
	}
	
	//부모의 추상메서드를 오버라이딩하여 재정의함
	@Override
	public void execute() {
		try {
			//쿼리실행을 위한 Statement객체 생성 및 쿼리문 작성
			stmt = con.createStatement();
			
			String  sql = "UPDATE member"
					 + " SET "
					 + " 	 pass='0412' ,      "
					 + "     name='이순신',   "
					 + "     regidate=sysdate   "
					 + " WHERE id='test' ";
			System.out.println("sql="+ sql);
			
			//쿼리문 실행
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected +"행이 업데이트 됨");
		}
		catch(SQLException e) {
			System.out.println("쿼리오류");
			e.printStackTrace();
		}
		finally {
			/*
			try문으로 진입한 후 예외가 발생하거나 return을 만나더라도
			반드시 실행할 코드가 있는경우 finally절에 기술한다.
			 */
			close();
		}
	}
	public static void main(String[] args) {
		new UpdateQuery("kosmo","1234").execute();
	}
}

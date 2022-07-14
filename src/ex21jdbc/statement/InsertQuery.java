package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
	//멤버변수
	Connection con;//DB연결을 위한 객체
	Statement stmt;//정적쿼리문을 전송 및 실행하기 위한 객체 
   
	//생성자
	public InsertQuery() {
		try {
        //드라이버 로드 및 오라클 DB 연결
        Class.forName("oracle.jdbc.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id = "kosmo";
        String pass = "1234";
        con = DriverManager.getConnection(url,id,pass);
        System.out.println("오라클 DB 연결성공");
    }
    catch(Exception e) {
        System.out.println("연결실패");
    }
}//end of InsertQuery
   
    //DB자원해제
    private void close() {
    	try {
        //연결 확인 후 자원해제
        if(stmt!=null) stmt.close();
        if(con!=null) con.close();
        System.out.println("DB자원반납완료");
    }
    catch(SQLException e) {
        System.out.println("자원반납시 오류가 발생하였습니다.");
    }
}//end of close
   
    //쿼리작성 및 전송, 실행
    private void execute() {
        try {
        //Statement 객체 생성을 위한 메서드 호출
        stmt = con.createStatement();
        //insert 쿼리문 작성
        String sql = "INSERT INTO member VALUES "
              + " ('test2', '2222', '테스터2', SYSDATE) ";
        //쿼리문 전송 및 실행
        int affected = stmt.executeUpdate(sql);
        //insert 문에 대한 결과 출력
        System.out.println(affected + "행이 입력되었습니다.");
        //자원해제
        close();
    }
    catch(SQLException e) {
        System.out.println("쿼리실행에 문제가 발생했습니다");
        e.printStackTrace();
    }
}
   
    public static void main(String[] args) {
    	InsertQuery iSQL = new InsertQuery();
    	iSQL.execute();
    }//end of main
}
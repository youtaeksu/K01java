package ex21jdbc.statement;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class IsMemberProcCall extends IConnectImpl {

	public IsMemberProcCall() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			csmt = con.prepareCall("{ call KosmoMemberAuth(?,?,?) }");
			
			//In파라미터로 아이디와 패스워드 입력받음
			csmt.setString(1, scanValue("회원 아이디"));
			csmt.setString(2, scanValue("회원패스워드"));
			//Out파라미터는 로그인 상태에 따른 정수
			csmt.registerOutParameter(3, Types.NUMERIC);
			csmt.execute();
			
			//Out파라미터는 인덱스3이므로 아래와 같이 얻어온다.
			int outParamResult = csmt.getInt(3);
			switch(outParamResult) {
			case 0:
				System.out.println("회원아이디가 없어요. 회원가입해주삼");
				break;
			case 1:
				System.out.println("패스워드가 일치하지 않아요. 비번찾기하삼");
				break;	
				
			case 2:
				System.out.println("회원님 방가방가^^*");
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
		IsMemberProcCall mapc = new IsMemberProcCall();
		mapc.execute();
	}

}

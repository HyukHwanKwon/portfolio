package action;

import static comm.JdbcUtil.*;
import java.sql.*;

public class MemberLoginService {
	public boolean login(String id, String pw) {
		MemberData memberData = MemberData.getInstance();
		Connection conn = getConnection();
		memberData.setConnection(conn);
		boolean isSuccess = false;
		int login = memberData.login(id, pw);
		
		if(login > 0) {
			commit(conn);
			isSuccess = true;
		} else {
			rollback(conn);
		}
		
		close(conn);
		return isSuccess;
	}
}

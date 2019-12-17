package action;

import java.sql.*;
import beans.MemberInfo;
import static comm.JdbcUtil.*;

public class MemberJoinService {
	public boolean joinMember(MemberInfo memberInfo) {
		MemberData memberData = MemberData.getInstance();
		Connection conn = getConnection();
		memberData.setConnection(conn);
		boolean isSuccess = false;
		int flag = memberData.insertMember(memberInfo);
		
		if (flag > 0) {
			commit(conn);
			isSuccess = true;
		} else {
			rollback(conn);
		}
		
		close(conn);
		return isSuccess;
	}
}

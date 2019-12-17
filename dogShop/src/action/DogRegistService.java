package action;

import static comm.JdbcUtil.*;

import java.sql.*;

import beans.DogInfo;

public class DogRegistService {
	
	public static boolean registDog(DogInfo d) {
		DogData dd = DogData.getInstance();
		Connection conn = getConnection();
		dd.setConnection(conn);
		boolean isSuccess = false;
		int flag = dd.insertDog(d);
		
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

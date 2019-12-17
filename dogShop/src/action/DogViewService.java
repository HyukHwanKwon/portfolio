package action;

import static comm.JdbcUtil.*;

import java.sql.*;
import beans.*;

public class DogViewService {
	public DogInfo getDog(int id) {
		
		DogInfo dogInfo = new DogInfo();
		DogData dogData = DogData.getInstance();
		Connection conn = getConnection();
		dogData.setConnection(conn);
		int updatecount = dogData.updateCount(id);
		dogInfo = dogData.selectDog(id);
		
		if (updatecount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return dogInfo;
	}
}
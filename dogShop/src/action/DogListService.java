package action;

import java.util.ArrayList;
import static comm.JdbcUtil.*;
import java.sql.*;
import beans.*;
import comm.*;

public class DogListService {
	
	public ArrayList<DogInfo> getDogList() {
		DogData dogdata = DogData.getInstance();
		Connection conn = JdbcUtil.getConnection();
		dogdata.setConnection(conn);
		ArrayList<DogInfo> dogList = dogdata.selectDogList();
		close(conn);
		
		return dogList;
	}
}

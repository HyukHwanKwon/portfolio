package manager;

import java.sql.Connection;
import java.util.ArrayList;

import beans.ManagerInfo;
import beans.MemberInfo;
import comm.JdbcUtil;
import static comm.JdbcUtil.*;

public class ManagerService {
	ManagerData managerData;
	Connection con;
	
	public ManagerService() {
		this.managerData = ManagerData.getInstance();
		this.con = JdbcUtil.getConnection();
		this.managerData.setConnection(con);
	} 
	
	public boolean managerLogin(ManagerInfo mi) throws Exception{
		boolean state = managerData.loginManager(mi);
		
		if(state==true) {
			commit(con);
			System.out.println("commit!");
		}else {
			rollback(con);
			System.out.println("rollback!");
		}
		
		
		return state;
	}
	
	public ArrayList<MemberInfo> listMember(MemberInfo mi) throws Exception{
		ArrayList<MemberInfo> list = managerData.ListMember(mi);
		
		if(list != null) {
			commit(con);
			System.out.println("commit!");
		}else {
			rollback(con);
			System.out.println("rollback!");
		}
		
		
		return list;
	}
	public int memberDelete(MemberInfo memberInfo) throws Exception{
		int x= managerData.deleteMember(memberInfo);
		
		if(x>0) {
			commit(con);
			System.out.println("commit!");
		}else {
			rollback(con);
			System.out.println("rollback!");
		}
		
		
		return x;
	}
	
	public void closeConnection() {
		close(con);
	}

}

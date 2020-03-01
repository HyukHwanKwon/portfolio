package member;

import static comm.JdbcUtil.*;
import java.sql.*;
import beans.*;
import comm.JdbcUtil;

public class MemberService {
	MemberData memberData;
	Connection con;
	
	public MemberService() {
		this.memberData = MemberData.getInstance();
		this.con = JdbcUtil.getConnection();
		this.memberData.setConnection(con);
	}
	
	public boolean memberLogin(MemberInfo memberInfo) throws Exception{
		boolean state = memberData.memberLogin(memberInfo);
		
		if(state==false) {
			rollback(con);
			System.out.println("rollback");
		}else {
			commit(con);
			System.out.println("commit");
		}
		return state;
	}
	
	public int memberJoin(MemberInfo memberInfo) throws Exception{
		int x= memberData.memberJoin(memberInfo);
		
		if(x !=1) {
			rollback(con);
			System.out.println("rollback");
		}else {
			commit(con);
			System.out.println("commit");
		}
		return x;
	}
	public int deleteMember(MemberInfo memberInfo) throws Exception{
		int x= memberData.memberDelete(memberInfo);
		
		if(x !=1) {
			rollback(con);
			System.out.println("rollback");
		}else {
			commit(con);
			System.out.println("commit");
		}
		return x;
	}
	public MemberInfo detailMember(MemberInfo memberInfo) throws Exception{
		MemberInfo mi = memberData.memberDetail(memberInfo);
		if(mi == null) {
			rollback(con);
			System.out.println("rollback");
		}else {
			commit(con);
			System.out.println("commit");
		}
		return mi;
	}
	public int updateMember(MemberInfo memberInfo) throws Exception{
		int x = memberData.memberUpdate(memberInfo);
		if(x <=0) {
			rollback(con);
			System.out.println("rollback");
		}else {
			commit(con);
			System.out.println("commit");
		}
		return x;
	}
	
	
	public void closeConnection() {
		close(con);
	}
}

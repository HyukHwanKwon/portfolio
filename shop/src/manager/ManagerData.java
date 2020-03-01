package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static comm.JdbcUtil.*;
import beans.ManagerInfo;
import beans.MemberInfo;

public class ManagerData {
	int x = 0;
	boolean state = false;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	private static ManagerData instance;
	
	public static ManagerData getInstance() {
		if(instance==null) {
			instance= new ManagerData();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public boolean loginManager(ManagerInfo mi) throws Exception{
		
		try {
			sql="select * from manager where manager_id=? and manager_password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, mi.getManagerId());
			ps.setString(2, mi.getManagerPassword());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				state = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		finally {
			close(ps);
			close(rs);
		}
		
		return state;
	}
	
	public ArrayList<MemberInfo> ListMember(MemberInfo mi) throws Exception{
		
		ArrayList<MemberInfo> list = new ArrayList<MemberInfo>();
		try {
			sql="select * from member";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				mi = new MemberInfo();
				mi.setMemberId(rs.getString("m_id"));
				mi.setMemberPassword(rs.getString("m_password"));
				mi.setMemberName(rs.getString("m_name"));
				mi.setMemberPhone(rs.getInt("m_phone"));
				mi.setMemberEmail(rs.getString("m_email"));
				list.add(mi);
 			}
			
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		finally {
			close(ps);
			close(rs);
		}
		
		return list;
	}
	
public int deleteMember(MemberInfo memberInfo) throws Exception{
		int x = 0;
		
		try {
			sql="delete  from member where m_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,memberInfo.getMemberId());
			x=ps.executeUpdate();
			System.out.println(x+">>>>>>>>>>>>>>>>>>");
			
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		finally {
			close(ps);
			close(rs);
		}
		
		return x;
	}
}

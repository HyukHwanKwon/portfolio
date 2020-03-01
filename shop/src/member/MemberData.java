package member;

import java.sql.*;
import beans.*;
import static comm.JdbcUtil.*;

public class MemberData {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	int x;
	private static  MemberData instance;
	
	public static MemberData getInstance() {
		if(instance== null) {
			instance = new MemberData();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public boolean memberLogin(MemberInfo memberInfo) throws Exception{
		boolean state = false;
		
		try {
			sql="select * from member where M_id = ? and M_password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, memberInfo.getMemberId());
			ps.setString(2, memberInfo.getMemberPassword());
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				state=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);

		}
		return state;
		
	}
	
	public int memberJoin(MemberInfo memberInfo)throws Exception{
		int x= 0;
		
		try {
			sql="insert into member values(?,?,?,?,?,0)";
			ps=con.prepareStatement(sql);
			ps.setString(1, memberInfo.getMemberId());
			ps.setString(2, memberInfo.getMemberPassword());
			ps.setString(3, memberInfo.getMemberName());
			ps.setInt(4,memberInfo.getMemberPhone());
			ps.setString(5, memberInfo.getMemberEmail());
			x=ps.executeUpdate();
			if(x>0) {
				x=1;
			}
		}catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();// TODO: handle exception
		}finally {
			close(rs);
			close(ps);
		}
		return x;
	}
	public int memberDelete(MemberInfo memberInfo)throws Exception{
		int x= 0;
		
		try {
			sql="Delete from member where m_id=? AND m_password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, memberInfo.getMemberId());
			ps.setString(2, memberInfo.getMemberPassword());
			x=ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();// TODO: handle exception
		}finally {
			close(ps);
		}
		return x;
	}
	public MemberInfo memberDetail(MemberInfo memberInfo)throws Exception{
		
		try {
			sql="select * from member where m_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, memberInfo.getMemberId());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				memberInfo.setMemberId(rs.getString("m_id"));
				memberInfo.setMemberPassword(rs.getString("m_password"));
				memberInfo.setMemberName(rs.getString("m_name"));
				memberInfo.setMemberPhone(rs.getInt("m_phone"));
				memberInfo.setMemberEmail(rs.getString("m_email"));
				
			}
		
		}catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();// TODO: handle exception
		}finally {
			close(ps);
		}
		return memberInfo;
	}
	public int memberUpdate(MemberInfo memberInfo)throws Exception{
		int x= 0;
		
		try {
			sql="update member set m_password=?,m_name=?,m_phone=?,m_email=? where m_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, memberInfo.getMemberPassword());
			ps.setString(2, memberInfo.getMemberName());
			ps.setInt(3,memberInfo.getMemberPhone());
			ps.setString(4, memberInfo.getMemberEmail());
			ps.setString(5, memberInfo.getMemberId());
			x=ps.executeUpdate();			
			if(x>0) {
				x=1;
			}
		}catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();// TODO: handle exception
		}finally {
			close(rs);
			close(ps);
		}
		return x;
	}
}

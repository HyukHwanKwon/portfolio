package action;

import java.sql.*;
import beans.MemberInfo;
import static comm.JdbcUtil.*;

public class MemberData {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	private static MemberData instance;

	public static MemberData getInstance() {
		if (instance == null) {
			instance = new MemberData();
		}
		
		return instance;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int insertMember(MemberInfo meberInfo) {
		int flag = 0;
		
		try {
			sql = "insert into member values (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, meberInfo.getId());
			ps.setString(2, meberInfo.getPw());
			ps.setString(3, meberInfo.getName());
			ps.setInt(4, meberInfo.getAge());
			ps.setString(5, meberInfo.getGender());
			ps.setString(6, meberInfo.getEmail());
			flag = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return flag;
	}
	
	public int login(String id, String pw) {
		int flag = 0;
		
		try {
			sql = "select * from member where id = ? and pw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				flag = 1;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return flag;
	}
}

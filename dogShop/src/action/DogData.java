package action;

import static comm.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;
import beans.DogInfo;

public class DogData {
	Connection conn;
	private static DogData instance;

	public static DogData getInstance() {
		if (instance == null) {
			instance = new DogData();
		}
		
		return instance;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<DogInfo> selectDogList() {
		ArrayList<DogInfo> dinfo = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			sql = "select * from dog";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			dinfo = new ArrayList<DogInfo>();
			if (rs.next()) {
				do {
					DogInfo d = new DogInfo(rs.getInt("id"), rs.getString("kind"), rs.getInt("price"),
							rs.getString("image"), rs.getString("country"), rs.getInt("height"), rs.getInt("weight"),
							rs.getString("content"), rs.getInt("readcount"));
					dinfo.add(d);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(psmt);
		}
		
		return dinfo;
	}

	public DogInfo selectDog(int id) {
		DogInfo d = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			sql = "select * from dog where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				d = new DogInfo(rs.getInt("id"), rs.getString("kind"), rs.getInt("price"), rs.getString("image"),
						rs.getString("country"), rs.getInt("height"), rs.getInt("weight"), rs.getString("content"),
						rs.getInt("readcount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(psmt);
		}
		
		return d;
	}

	public int updateCount(int id) {
		int update = 0;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			sql = "select readcount from dog where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			rs.next();
			update = rs.getInt("readcount") + 1;
			sql = "update set readcount = ? from dog where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, update);
			psmt.setInt(2, id);
			update = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(psmt);
		}
		
		return update;
	}

	public int insertDog(DogInfo d) {
		PreparedStatement psmt = null;
		String sql = null;
		int flag = 0;
		ResultSet rs = null;
		
		try {
			sql = "insert into dog values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, d.getKind());
			psmt.setInt(2, d.getPrice());
			psmt.setString(3, d.getImage());
			psmt.setString(4, d.getCountry());
			psmt.setInt(5, d.getHeight());
			psmt.setInt(6, d.getWeight());
			psmt.setString(7, d.getContent());
			psmt.setInt(8, 0);
			flag = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(psmt);
		}
		
		return flag;
	}
}
package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.BoardInfo;
import static comm.JdbcUtil.*;

public class BoardData {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int x = 0;
	boolean state = false;
	String sql;

	private static BoardData instance;

	public static BoardData getInstance() {
		if (instance == null) {
			instance = new BoardData();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertBoard(BoardInfo boardInfo) throws Exception {

		try {
			sql = "insert into board values(?,?,?,?,?,null)";
			ps = con.prepareStatement(sql);
			ps.setString(1, boardInfo.getBoardId());
			ps.setString(2, boardInfo.getBoardTitle());
			ps.setString(3, boardInfo.getBoardContent());
			ps.setString(4, boardInfo.getBoardImage());
			ps.setTimestamp(5, boardInfo.getRegDate());
			x = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(ps);
		}

		return x;
	}

	public ArrayList<BoardInfo> boardInfo(BoardInfo bi) throws Exception {
		ArrayList<BoardInfo> list = new ArrayList<BoardInfo>();
		try {
			sql = "select * from board order By board_num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				bi = new BoardInfo();
				bi.setBoardId(rs.getString("board_id"));
				bi.setBoardTitle(rs.getString("board_title"));
				bi.setBoardContent(rs.getString("board_content"));
				bi.setBoardImage(rs.getString("board_image"));
				bi.setRegDate(rs.getTimestamp("reg_date"));
				bi.setBoardNum(rs.getInt("board_num"));
				list.add(bi);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}

		return list;
	}

	public BoardInfo boardDetailInfo(BoardInfo bi) throws Exception {

		try {
			sql = "select * from board where board_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bi.getBoardNum());
			rs = ps.executeQuery();

			if (rs.next()) {
				bi.setBoardId(rs.getString("board_id"));
				bi.setBoardTitle(rs.getString("board_title"));
				bi.setBoardContent(rs.getString("board_content"));
				bi.setBoardImage(rs.getString("board_image"));
				bi.setRegDate(rs.getTimestamp("reg_date"));
				bi.setBoardNum(rs.getInt("board_num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return bi;
	}

	public int updateBoard(BoardInfo boardInfo) throws Exception {

		try {
			sql = "update  board set board_title=?, board_content=?,board_image=? where board_num=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, boardInfo.getBoardTitle());
			ps.setString(2, boardInfo.getBoardContent());
			ps.setString(3, boardInfo.getBoardImage());
			ps.setInt(4, boardInfo.getBoardNum());

			x = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}

		return x;
	}
	
	public int deleteBoard(BoardInfo boardInfo) throws Exception {

		try {
			sql = "delete from board where board_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardInfo.getBoardNum());
			x = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}

		return x;
	}
}

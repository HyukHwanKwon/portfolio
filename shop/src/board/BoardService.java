package board;

import java.sql.Connection;
import java.util.ArrayList;

import beans.BoardInfo;
import comm.JdbcUtil;
import static comm.JdbcUtil.*;

public class BoardService {
	BoardData boardData;
	Connection con;
	int x = 0;
	boolean state = false;
	ArrayList<BoardInfo> list = null;
	

	public BoardService() {
		this.boardData = BoardData.getInstance();
		this.con = JdbcUtil.getConnection();
		this.boardData.setConnection(con);
	}

	public int boardInsert(BoardInfo boardInfo) throws Exception {

		x = boardData.insertBoard(boardInfo);

		if (x > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return x;
	}

	public ArrayList<BoardInfo> boardList(BoardInfo bi) throws Exception {

		list = boardData.boardInfo(bi);

		if (list !=null) {
			commit(con);
		} else {
			rollback(con);
		}
		return list;
	}
	
	public BoardInfo boardDetailList(BoardInfo bi) throws Exception {

		bi = boardData.boardDetailInfo(bi);

		if (bi != null) {
			commit(con);
		} else {
			rollback(con);
		}
		return bi;
	}
	
	public int boardUpdate(BoardInfo boardInfo) throws Exception {

		x = boardData.updateBoard(boardInfo);

		if (x > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return x;
	}
	
	public int boardDelete(BoardInfo boardInfo) throws Exception {

		x = boardData.deleteBoard(boardInfo);

		if (x > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return x;
	}
	
	

	public void closeConnection() {
		close(con);
	}
}

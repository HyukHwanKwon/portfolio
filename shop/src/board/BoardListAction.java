package board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BoardInfo;
import comm.Action;
import comm.ActionForward;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		HttpSession session = request.getSession();
		BoardService boardService = new BoardService();
		BoardInfo bi = new BoardInfo();
		ArrayList<BoardInfo> boardList = boardService.boardList(bi);
		session.setAttribute("boardList",boardList);
		forward = new ActionForward("board/boardList.jsp", false);
		
		boardService.closeConnection();
		return forward;
	}

}

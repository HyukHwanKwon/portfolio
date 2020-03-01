package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BoardInfo;
import comm.Action;
import comm.ActionForward;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		BoardService boardService = new BoardService();
		BoardInfo boardInfo = new BoardInfo();
		HttpSession session = request.getSession();
		String num =request.getParameter("num");
		
		boardInfo.setBoardNum(Integer.parseInt(num));
		boardService.boardDetailList(boardInfo);
		request.setAttribute("num", num);
		session.setAttribute("boardInfo", boardInfo);
		forward = new ActionForward("board/boardDetail.jsp", false);
		
		boardService.closeConnection();
		return forward;
		
	}

}

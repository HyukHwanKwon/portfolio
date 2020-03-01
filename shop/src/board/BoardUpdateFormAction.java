package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardInfo;
import comm.Action;
import comm.ActionForward;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward =null;
		BoardService boardService = new BoardService();
		BoardInfo boardInfo = new BoardInfo();
		String num = request.getParameter("num").toString();
		
		boardInfo.setBoardNum(Integer.parseInt(num));
		boardService.boardDetailList(boardInfo);
		
		request.setAttribute("num", num);
		request.setAttribute("boardInfo",boardInfo);
		
		forward = new ActionForward("board/boardUpdateForm.jsp", false);
		
		
		boardService.closeConnection();
		return forward;
	}

}

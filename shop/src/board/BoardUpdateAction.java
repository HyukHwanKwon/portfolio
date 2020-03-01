package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardInfo;
import comm.Action;
import comm.ActionForward;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward =null;
		BoardService boardService = new BoardService();
		BoardInfo boardInfo = new BoardInfo();
		
		String num =request.getParameter("boardNum");
		String title = request.getParameter("boardTitle");
		String content = request.getParameter("boardContent");
		String image = request.getParameter("boardImage");
		
		boardInfo.setBoardNum(Integer.parseInt(num));
		boardInfo.setBoardTitle(title);
		boardInfo.setBoardContent(content);
		boardInfo.setBoardImage(image);
		
		boardService.boardUpdate(boardInfo);
		
		forward = new ActionForward("main.jsp", false);
		
		boardService.closeConnection();
		return forward;
	}

}

package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class BoardInsertFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		BoardService boardService = new BoardService();
		ActionForward forward = null;
		//session.setAttribute("id",id);
		request.setAttribute("id", id);
		forward=new ActionForward("board/boardRegistForm.jsp",false);
		
		boardService.closeConnection();
		return forward;
	}

}

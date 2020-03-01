package board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardInfo;
import comm.Action;
import comm.ActionForward;

public class BoardDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		BoardService boardService = new BoardService();
		BoardInfo boardInfo = new BoardInfo();
		
		String num = request.getParameter("num");
		boardInfo.setBoardNum(Integer.parseInt(num));
		int x = boardService.boardDelete(boardInfo);
		
		if(x>0) {
			forward = new ActionForward("main.jsp", false);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('x');");
			out.println("history.back();");
			out.println("</script>");
		}
	
		
		boardService.closeConnection();
		return forward;
	}

}

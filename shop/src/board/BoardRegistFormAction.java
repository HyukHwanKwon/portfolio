package board;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import beans.BoardInfo;
import comm.Action;
import comm.ActionForward;

public class BoardRegistFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		BoardService boardService = new BoardService();
		BoardInfo boardInfo = new BoardInfo();
		HttpSession session = request.getSession();
		int x = 0;

		MultipartRequest mult = null;	
		String FileName = null;
		String direct = "/uploadFolder";
		String realDirect = null;
		String enctype = "utf-8";
		int maxSize = 1024 * 1024 * 8;
		ServletContext servlet = request.getServletContext();
		realDirect = servlet.getRealPath(direct);
		String root = request.getSession().getServletContext().getRealPath("/");
	      System.out.print(root);
//		System.out.println(servlet.getRealPath(direct));
		try {
			mult = new MultipartRequest(request, realDirect, maxSize, enctype, new DefaultFileRenamePolicy());//

			String id = session.getAttribute("id").toString();
			String title = mult.getParameter("boardTitle");
			String content = mult.getParameter("boardContent");
			FileName = mult.getFilesystemName("boardImage");
			Timestamp date = new Timestamp(System.currentTimeMillis());

			boardInfo.setBoardId(id);
			boardInfo.setBoardTitle(title);
			boardInfo.setBoardContent(content);
			boardInfo.setBoardImage(FileName);
			boardInfo.setRegDate(date);
			
			System.out.println(servlet.getRealPath(direct));
			
			x = boardService.boardInsert(boardInfo);

			if (x > 0) {
				forward = new ActionForward("main.jsp", false);
				System.out.println("¼º°ø");
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('x');");
				out.println("history.back();");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boardService.closeConnection();
		return forward;
	}
}

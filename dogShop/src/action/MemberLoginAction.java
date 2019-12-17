package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import comm.*;

public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean flag = false;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		flag = memberLoginService.login(id, pw);
		
		ActionForward forward = null;
		
		if (flag) {
			session.setAttribute("id", id);
			forward = new ActionForward("./dogMain.jsp", true);
		} else {
			response.setContentType("text/html; charSet=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패');");
			out.println("location.href='./memberLogin.me';");
			out.println("</script>");
		}
		
		return forward;
	}
}

package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MemberInfo;
import comm.Action;
import comm.ActionForward;

public class MemberLogInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberService ms = new MemberService();
		MemberInfo mi= new MemberInfo();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		mi.setMemberId(id);
		mi.setMemberPassword(password);
		
		boolean state=ms.memberLogin(mi);
		ActionForward forward = null;
		
		if (state != false) {
			session.setAttribute("id", id);
			forward = new ActionForward("main.jsp", false);
		} else {
			response.setContentType("text/html; charSet=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디나 비밀번호를 확인해주세요.');");
			out.println("location.href='/main.jsp';");	
			out.println("</script>");
		}
		ms.closeConnection();
	
		return forward;
	}

}



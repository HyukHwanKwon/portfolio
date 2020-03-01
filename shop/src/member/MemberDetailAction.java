package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MemberInfo;
import comm.Action;
import comm.ActionForward;

public class MemberDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward= null;
		MemberService ms = new MemberService();
		MemberInfo mi = new MemberInfo();
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		mi.setMemberId(id);
		
		MemberInfo mi1=ms.detailMember(mi);
		
		if (mi1.getMemberId()!=null) {
			session.setAttribute("member", mi1);
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

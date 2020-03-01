package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberInfo;
import comm.Action;
import comm.ActionForward;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int joinResult = 0;
		ActionForward forward = null;
		MemberInfo mi = new MemberInfo();
		MemberService ms = new MemberService();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String email = request.getParameter("email");
		
		mi.setMemberId(id);
		mi.setMemberPassword(password);
		mi.setMemberName(name);
		mi.setMemberPhone(phone);
		mi.setMemberEmail(email);
		
		joinResult =ms.memberJoin(mi);
		
		if (joinResult > 0) {
			forward = new ActionForward("memberJoin.mem", true);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('x');");
			out.println("history.back();");
			out.println("</script>");
		}
		ms.closeConnection();
		return forward;
	}

}

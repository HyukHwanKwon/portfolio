package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberInfo;
import comm.Action;
import comm.ActionForward;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int x = 0;
		ActionForward forward = null;
		MemberService ms = new MemberService();
		MemberInfo memberInfo = new MemberInfo();
		
		String id = request.getParameter("m_id");
		String password = request.getParameter("m_pw");
		String name = request.getParameter("m_name");
		int phone = Integer.parseInt(request.getParameter("m_phone"));
		String email = request.getParameter("m_email");
		
		memberInfo.setMemberId(id);
		memberInfo.setMemberPassword(password);
		memberInfo.setMemberName(name);
		memberInfo.setMemberPhone(phone);
		memberInfo.setMemberEmail(email);
		
		x=ms.updateMember(memberInfo);
		
		
		if(x>0) {
			forward = new ActionForward("main.jsp",false);
		}else {
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

package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MemberInfo;
import comm.Action;
import comm.ActionForward;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
		MemberService ms = new MemberService();
		HttpSession session = request.getSession();
		MemberInfo mi = new MemberInfo();
		String password=request.getParameter("password");
		mi.setMemberId((String)session.getAttribute("id"));
		mi.setMemberPassword(password);
		int check = ms.deleteMember(mi);
		
		if(check>0) {
			System.out.println("성공");
			forward = new ActionForward("main.jsp", false);
			session.invalidate();
		}
		else {
			System.out.println("실패");
		}
		ms.closeConnection();
		return forward;
	}

}

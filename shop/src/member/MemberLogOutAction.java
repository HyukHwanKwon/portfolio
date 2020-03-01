package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class MemberLogOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberService ms = new MemberService();
		HttpSession session = request.getSession();
		session.invalidate();
		
		ActionForward forward = new ActionForward("main.jsp", true);
		
		ms.closeConnection();
		return forward;
	}

}

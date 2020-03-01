package manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class ManagerLogOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		HttpSession session = request.getSession();	
		session.invalidate();
		ManagerService ms = new ManagerService();
		forward = new ActionForward("beforeManagerMain.jsp", false);
		
		ms.closeConnection();
		return forward;
	}

}

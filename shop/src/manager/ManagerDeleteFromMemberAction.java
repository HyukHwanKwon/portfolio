package manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberInfo;
import comm.Action;
import comm.ActionForward;

public class ManagerDeleteFromMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int x = 0;
		ActionForward forward= null;
		ManagerService managerService = new ManagerService();
		String id = request.getParameter("id");
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMemberId(id);
		x=managerService.memberDelete(memberInfo);
		
		if(x>0) {
			forward = new ActionForward("managerMain.jsp", false);
		}
		managerService.closeConnection();
		return forward;
	}

}

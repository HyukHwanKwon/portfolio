package manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MemberInfo;
import comm.Action;
import comm.ActionForward;

public class MemberListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		MemberInfo mi = new MemberInfo();
		ManagerService ms = new ManagerService();
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		mi.setMemberId(id);
		ArrayList<MemberInfo> memberList = ms.listMember(mi);
		
		session.setAttribute("memberList", memberList);
		forward = new ActionForward("manager/memberList.jsp", false);
		ms.closeConnection();
		return forward;
	}

}

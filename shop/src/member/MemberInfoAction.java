package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MemberInfo;
import comm.Action;
import comm.ActionForward;

public class MemberInfoAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		MemberService ms = new MemberService();
		MemberInfo memberInfo = new MemberInfo();
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		memberInfo.setMemberId(id);
		memberInfo = ms.detailMember(memberInfo);
		request.setAttribute("member", memberInfo);
		
		forward = new ActionForward("member/info.jsp",false);
		ms.closeConnection();
		return forward;
	}
}

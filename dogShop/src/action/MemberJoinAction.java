package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.MemberInfo;
import comm.*;

public class MemberJoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberInfo memberInfo = new MemberInfo();
		MemberJoinService meberJoinService = new MemberJoinService();
		boolean flag = false;
		
		memberInfo.setId(request.getParameter("id"));
		memberInfo.setPw(request.getParameter("pw"));
		memberInfo.setName(request.getParameter("name"));
		memberInfo.setAge(Integer.parseInt(request.getParameter("age")));
		memberInfo.setGender(request.getParameter("gender"));
		memberInfo.setEmail(request.getParameter("email"));
		
		flag = meberJoinService.joinMember(memberInfo);
		ActionForward forward = null;
		
		if (flag) {
			forward = new ActionForward("memberJoin.me", true);
		} else {
			response.setContentType("text/html; charSet=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('가입실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}
}

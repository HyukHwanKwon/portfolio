package manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ManagerInfo;
import comm.Action;
import comm.ActionForward;

public class ManagerLogInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		boolean state = false;
		ActionForward forward = null;
		ManagerInfo mi = new ManagerInfo();
		ManagerService ms = new ManagerService();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		mi.setManagerId(id);
		mi.setManagerPassword(password);
		state = ms.managerLogin(mi);
		
		if(state == true) {
			session.setAttribute("id", id);
			forward = new ActionForward("manager/managerMain.jsp", false);
		}
		else {
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

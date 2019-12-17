package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import comm.Action;
import comm.ActionForward;

public class DogViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogInfo dogInfo = new DogInfo();
		DogViewService dogViewService = new DogViewService();
		String id = request.getParameter("id");
		dogInfo = dogViewService.getDog(Integer.parseInt(id));
		request.setAttribute("dog", dogInfo);
		Cookie todayImageCookie = new Cookie("today" + id, dogInfo.getImage());
		ActionForward forward = new ActionForward("dogView.jsp", false); // 종결부분일시 false
		
		return forward;
	}
}
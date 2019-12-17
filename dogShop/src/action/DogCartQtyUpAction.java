package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;

public class DogCartQtyUpAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		DogCartQtyUpService dogCartQtyUpService = new DogCartQtyUpService();
		dogCartQtyUpService.upCartQty(request, kind);
		
		ActionForward forward = new ActionForward("dogCartList.dog", false); // 종결부분일시 false
		return forward;
	}
}
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DogInfo;
import comm.Action;
import comm.ActionForward;

public class DogCartAddAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartAddService dogCartAddService = new DogCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		DogInfo dogInfo = dogCartAddService.getCartDog(id);
		dogCartAddService.addCart(request, dogInfo);

		ActionForward forward = new ActionForward("dogCartList.dog", true);
		return forward;
	}
}

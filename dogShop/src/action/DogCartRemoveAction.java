package action;

import javax.servlet.http.*;
import beans.*;
import comm.Action;
import comm.ActionForward;

public class DogCartRemoveAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] kindArray = request.getParameterValues("remove");
		if (kindArray != null) {
			DogCartRemoveService dogCartRemoveService = new DogCartRemoveService();
			dogCartRemoveService.cartRemove(request, kindArray);
		}
		
		ActionForward forward = new ActionForward("dogCartList.dog", true);
		return forward;
	}
}

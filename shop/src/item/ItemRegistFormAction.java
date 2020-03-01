package item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;

public class ItemRegistFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ItemService is = new ItemService();
		ActionForward forward = new ActionForward("item/itemRegistForm.jsp", false);
		
		is.closeConnection();
		return forward;
	}

}

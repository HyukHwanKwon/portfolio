package cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CartListInfo;
import comm.Action;
import comm.ActionForward;

public class CartDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;		
		CartListInfo cli = new CartListInfo();
		CartService cartService = new CartService();
		int num = Integer.parseInt(request.getParameter("num"));
		
		cli.setItemNum(num);
		int result=cartService.CartDelete(cli);
		
		if(result > 0) {
			forward = new ActionForward("main.jsp", false);
		}
		
		cartService.closeConnection();
		return forward;
	}

}

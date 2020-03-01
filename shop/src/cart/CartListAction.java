package cart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartListInfo;
import comm.Action;
import comm.ActionForward;

public class CartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		CartListInfo cli = new CartListInfo();
		CartService cartService = new CartService();
		ArrayList<CartListInfo> List = new ArrayList<CartListInfo>();
		
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		
		cli.setMemberId(id);	
		List=cartService.CartList(cli);

		if (List != null) {
			session.setAttribute("List", List);
			forward = new ActionForward("cart/cartList.jsp", false);
		}
		
		cartService.closeConnection();
		return forward;
	}

}

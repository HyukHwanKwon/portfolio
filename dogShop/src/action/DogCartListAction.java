package action;

import java.util.ArrayList;

import javax.servlet.http.*;
import beans.*;
import comm.Action;
import comm.ActionForward;

public class DogCartListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		int totalMoney = 0;
		int money = 0;

		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice() * cartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
		return forward;
	}
}

package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import comm.Action;
import comm.ActionForward;

public class DogCartSearchAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartSearchService dogCartSearchService = new DogCartSearchService();
		int startMoney;
		int endMoney;
		
		if (request.getParameter("startMoney").equals("=置馬=") && request.getParameter("endMoney").equals("=置壱=")) {
			startMoney = -1;
			endMoney = -1;
		} else if (request.getParameter("startMoney").equals("=置馬=") && !request.getParameter("endMoney").equals("=置壱=")) {
			startMoney = -1;
			endMoney = Integer.parseInt(request.getParameter("endMoney"));
		} else if (!request.getParameter("startMoney").equals("=置馬=") && request.getParameter("endMoney").equals("=置壱=")) {
			endMoney = -1;
			startMoney = Integer.parseInt(request.getParameter("startMoney"));
		} else {
			startMoney = Integer.parseInt(request.getParameter("startMoney"));
			endMoney = Integer.parseInt(request.getParameter("endMoney"));
		}
		
		ArrayList<Cart> cartList = dogCartSearchService.getCartSearchList(request, startMoney, endMoney);
		int totalMoney = 0;
		int money = 0;
			
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice() * cartList.get(i).getQty();
			totalMoney += money;
		}
			
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);
		request.setAttribute("endMoney", endMoney);
		request.setAttribute("totalMoney", totalMoney);
		
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
		return forward;
	}
}

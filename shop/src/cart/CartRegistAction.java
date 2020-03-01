package cart;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CartInfo;
import comm.Action;
import comm.ActionForward;

public class CartRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		String id = request.getParameter("id");
		int itemNum = Integer.parseInt(request.getParameter("num"));
		int result = 0;
		CartService cartService = new CartService();
		CartInfo cartInfo = new CartInfo();

		cartInfo.setMemberId(id);
		cartInfo.setItemNum(itemNum);

		result = cartService.CartInsert(cartInfo);

		if (result > 0) {
			forward = new ActionForward("main.jsp", false);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('x');");
			out.println("history.back();");
			out.println("</script>");
		}

		cartService.closeConnection();

		return forward;
	}

}

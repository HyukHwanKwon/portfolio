package item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemInfo;
import comm.Action;
import comm.ActionForward;

public class ItemModifyDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		ItemService itemService = new ItemService();
		ItemInfo itemInfo = new ItemInfo();
		HttpSession session = request.getSession();
		
		String num = request.getParameter("num");
		
		itemInfo.setItemNum(Integer.parseInt(num));	
		itemService.itemDetail(itemInfo);
		
		request.setAttribute("num", num);
		session.setAttribute("itemInfo", itemInfo);
		
		forward = new ActionForward("item/itemModifyDetail.jsp", false);
		
		
		itemService.closeConnection();
		return forward;
	}

}

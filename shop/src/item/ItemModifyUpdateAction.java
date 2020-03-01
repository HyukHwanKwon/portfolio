package item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemInfo;
import comm.Action;
import comm.ActionForward;

public class ItemModifyUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		ItemService itemService = new ItemService();
		ItemInfo itemInfo = new ItemInfo();
		
		int x= 0;
		
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String content = request.getParameter("content");
		String image =request.getParameter("image");
		
		itemInfo.setItemNum(num);
		itemInfo.setItemName(name);
		itemInfo.setItemPrice(price);
		itemInfo.setItemContent(content);
		itemInfo.setItemImage(image);
		
		x= itemService.itemModifyUpdate(itemInfo);
		
		if(x>0) {
			forward = new ActionForward("manager/managerMain.jsp", false);
		}
		itemService.closeConnection();
		return forward;
	}

}

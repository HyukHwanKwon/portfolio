package item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemInfo;
import comm.Action;
import comm.ActionForward;

public class ItemDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int x = 0;
		ActionForward forward = null;
		ItemService itemService = new ItemService();
		ItemInfo itemInfo = new ItemInfo();
		int num = Integer.parseInt(request.getParameter("num"));
		itemInfo.setItemNum(num);
		x=itemService.itemDelete(itemInfo);
		
		if(x>0) {
			forward = new ActionForward("manager/managerMain.jsp", false);
		}
		itemService.closeConnection();
		return forward;
	}

}

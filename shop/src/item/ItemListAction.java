package item;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemInfo;
import comm.Action;
import comm.ActionForward;

public class ItemListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		ItemService itemService = new ItemService();
		ArrayList<ItemInfo> ii = new ArrayList<ItemInfo>();
		
		ii=itemService.itemList();
		
		request.setAttribute("itemList", ii);
		forward = new ActionForward("item/itemList.jsp", false);
		
		itemService.closeConnection();
		return forward;
	}

}


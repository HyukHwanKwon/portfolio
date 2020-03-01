package item;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import beans.ItemInfo;
import comm.Action;
import comm.ActionForward;

public class ItemRegistAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		ItemService itemService = new ItemService();
		ItemInfo itemInfo = new ItemInfo();
		int x = 0;
		MultipartRequest mult=null;
		String FileName=null;
		String direct="/uploadFolder/";
		String realDirect=null;
		String enctype="utf-8";
		int maxSize=1024*1024*8;
		ServletContext servlet=request.getServletContext();
		realDirect=servlet.getRealPath(direct);
		try {
			mult=new MultipartRequest(request,realDirect,maxSize,enctype,new DefaultFileRenamePolicy());//
			FileName=mult.getFilesystemName("itemImage");
			
			
			int num = (Integer.parseInt(mult.getParameter("itemNum")));
			String name = mult.getParameter("itemName");
			int price= (Integer.parseInt(mult.getParameter("itemPrice")));
			String content = mult.getParameter("itemContent");
			
			itemInfo.setItemNum(num);
			itemInfo.setItemName(name);
			itemInfo.setItemPrice(price);
			itemInfo.setItemContent(content);
			itemInfo.setItemImage(FileName);
			
			x=itemService.itemRegist(itemInfo);
			
			
			if(x>0) {
				forward = new ActionForward("manager/managerMain.jsp", false);
				System.out.println("¼º°ø");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('x');");
				out.println("history.back();");
				out.println("</script>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		itemService.closeConnection();
		return forward;
	}

}

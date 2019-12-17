package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.DogInfo;
import comm.Action;
import comm.ActionForward;

public class DogListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<DogInfo> dogList = new ArrayList<DogInfo>();
		DogListService dogListService = new DogListService();
		dogList = dogListService.getDogList();
		request.setAttribute("dogList", dogList);
		ActionForward forward = new ActionForward("dogList.jsp", false);
		
		return forward;
	}
}



package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import beans.DogInfo;
import comm.Action;
import comm.ActionForward;

public class DogRegistAction implements Action {
	DogRegistService dogRegistService = new DogRegistService();
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		DogInfo dog = new DogInfo(0, multi.getParameter("kind"), 
				Integer.parseInt(multi.getParameter("price")), 
				image, 
				multi.getParameter("country"), 
				Integer.parseInt(multi.getParameter("height")), 
				Integer.parseInt(multi.getParameter("weight")), 
				multi.getParameter("content"), 0);
		boolean isRegistSuccess = DogRegistService.registDog(dog);
		ActionForward forward = null;
		
		if (isRegistSuccess) {
			forward = new ActionForward("dogList.dog", true);
		} else {
			response.setContentType("text/html; charSet=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}
}

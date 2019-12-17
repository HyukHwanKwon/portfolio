package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import beans.*;

public class DogCartQtyDownService {
	public void downCartQty(HttpServletRequest request, String kind) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getKind().equals(kind)) {
				cartList.get(i).setQty(cartList.get(i).getQty() - 1);
			}
		}
	}
}
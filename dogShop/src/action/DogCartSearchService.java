package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import beans.Cart;

public class DogCartSearchService {
	public ArrayList<Cart> getCartSearchList (HttpServletRequest request, int startMoney, int endMoney) {
		HttpSession session = request.getSession();
		ArrayList<Cart> oldCartList = (ArrayList<Cart>) session.getAttribute("cartList");
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		
		if (startMoney == -1 && endMoney == -1) {
			cartList = oldCartList;
		} else if (startMoney == -1) {
			for (int i = 0; i < oldCartList.size(); i++) {
				if (oldCartList.get(i).getPrice() <= endMoney) {
					cartList.add(oldCartList.get(i));
				}
			}
		} else if (endMoney == -1) {
			for (int i = 0; i < oldCartList.size(); i++) {
				if (oldCartList.get(i).getPrice() >= startMoney) {
					cartList.add(oldCartList.get(i));
				}
			}
		} else {
			for (int i = 0; i < oldCartList.size(); i++) {
				if (oldCartList.get(i).getPrice() >= startMoney && oldCartList.get(i).getPrice() <= endMoney) {
					cartList.add(oldCartList.get(i));
				}
			}
		}
		
		return cartList;
	}
}

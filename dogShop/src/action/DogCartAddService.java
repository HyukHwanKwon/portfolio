package action;

import static comm.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.*;
import beans.*;

public class DogCartAddService {
	public DogInfo getCartDog(int id) {
		Connection conn = getConnection();
		DogData dogData = DogData.getInstance();
		dogData.setConnection(conn);
		DogInfo dogInfo = dogData.selectDog(id);
		close(conn);
		return dogInfo;
	}

	public void addCart(HttpServletRequest request, DogInfo dogInfo) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		if (cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}

		boolean isNewCart = true;

		for (int i = 0; i < cartList.size(); i++) {
			if (dogInfo.getKind().equals(cartList.get(i).getKind())) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty());
				break;
			}
		}

		if (isNewCart) {
			Cart cart = new Cart();
			cart.setImage(dogInfo.getImage());
			cart.setKind(dogInfo.getKind());
			cart.setPrice(dogInfo.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}

	}
}

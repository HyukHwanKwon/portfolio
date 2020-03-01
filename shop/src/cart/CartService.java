package cart;

import java.sql.Connection;
import java.util.ArrayList;

import beans.BoardInfo;
import beans.CartInfo;
import beans.CartListInfo;
import comm.JdbcUtil;

import static comm.JdbcUtil.*;

public class CartService {
	CartData cartData;
	Connection con;
	int x = 0;
	boolean state = false;
	ArrayList<BoardInfo> list = null;
	
	public CartService() {
		this.cartData = CartData.getInstance();
		this.con = JdbcUtil.getConnection();
		this.cartData.setConnecion(con);
	}
	
	public int CartInsert(CartInfo cartInfo) throws Exception{
		x =  cartData.registCart(cartInfo);
		
		if(x>0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		return x;
	}
	
	public ArrayList<CartListInfo> CartList(CartListInfo cartListInfo) throws Exception{
		ArrayList<CartListInfo> list = cartData.ListCart(cartListInfo);
		
		if(list != null) {
			commit(con);
		}
		else {
			rollback(con);
		}
		return list;
	}
	
	public int CartDelete(CartListInfo cartListInfo) throws Exception{
		x =  cartData.deleteCart(cartListInfo);
		
		if(x>0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		return x;
	}
	
	public void closeConnection() {
		close(con);
	}
}

package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static comm.JdbcUtil.*;
import beans.CartInfo;
import beans.CartListInfo;

public class CartData {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	int x = 0;
	boolean state = false;

	private static CartData instance;

	public static CartData getInstance() {

		if (instance == null) {
			instance = new CartData();
		}
		return instance;
	}

	public void setConnecion(Connection con) {
		this.con = con;
	}

	public int registCart(CartInfo cartInfo) throws Exception {

		try {
			sql = "insert into cart (member_id,fk_item_num) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, cartInfo.getMemberId());
			ps.setInt(2, cartInfo.getItemNum());
			x = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return x;
	}

	public ArrayList<CartListInfo> ListCart(CartListInfo cartListInfo) throws Exception {
		ArrayList<CartListInfo> list = new ArrayList<CartListInfo>();
		try {
			sql = "select * from item,cart where item.item_num=cart.fk_item_num AND member_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cartListInfo.getMemberId());
			rs = ps.executeQuery();

			while (rs.next()) {

				cartListInfo = new CartListInfo();

				cartListInfo.setItemNum(rs.getInt("item_num"));
				cartListInfo.setItemName(rs.getString("item_name"));
				cartListInfo.setItemPrice(rs.getInt("item_price"));
				cartListInfo.setItemContent(rs.getString("item_content"));
				cartListInfo.setItemImage(rs.getString("item_image"));
				cartListInfo.setMemberId(rs.getString("member_id"));

				list.add(cartListInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return list;
	}

	public int deleteCart(CartListInfo cartListInfo) throws Exception {

		try {
			sql = "delete from cart where fk_item_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartListInfo.getItemNum());
			x = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return x;
	}
}

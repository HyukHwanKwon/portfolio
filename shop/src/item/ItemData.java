package item;
import static comm.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ItemInfo;

public class ItemData {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	boolean state = false;
	int x = 0;
	
	private static ItemData instance;
	
	public static ItemData getInstance() {
		if(instance == null) {
			instance=new ItemData();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int registItem(ItemInfo itemInfo) throws Exception{

		try {
			sql = "insert into Item values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,itemInfo.getItemNum());
			ps.setString(2,itemInfo.getItemName());
			ps.setInt(3,itemInfo.getItemPrice());
			ps.setString(4,itemInfo.getItemContent());
			ps.setString(5,itemInfo.getItemImage());
			
			x=ps.executeUpdate();
			
			if(x>0) {
				System.out.println("itemData OK");
				x=1;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return x;
	}
	
	public ArrayList<ItemInfo> itemList() throws Exception{
		ArrayList<ItemInfo> ii = new ArrayList<ItemInfo>();
		try {
			sql="select * from item";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ItemInfo itemInfo = new ItemInfo();
				
				itemInfo.setItemNum(rs.getInt("item_num"));
				itemInfo.setItemName(rs.getString("item_name"));
				itemInfo.setItemPrice(rs.getInt("item_price"));
				itemInfo.setItemContent(rs.getString("item_Content"));
				itemInfo.setItemImage(rs.getString("item_image"));
				
				ii.add(itemInfo);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return ii;
	}
	
	public int deleteItem(ItemInfo itemInfo) throws Exception{
		
		try {
			sql = "delete from item where item_num=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, itemInfo.getItemNum());
			x=ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return x;
	}
	
	public int modifyItem(ItemInfo itemInfo) throws Exception{
		
		try {
			sql = "Update item set  item_name=?, item_price=?, item_content=?, item_image=? where item_num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, itemInfo.getItemName());
			ps.setInt(2, itemInfo.getItemPrice());
			ps.setString(3, itemInfo.getItemContent());
			ps.setString(4, itemInfo.getItemImage());
			ps.setInt(5, itemInfo.getItemNum());
			x=ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return x;
	}
	
public ItemInfo detailItem(ItemInfo itemInfo) throws Exception{

		try {
			sql = "select * from item where item_num=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, itemInfo.getItemNum());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				itemInfo.setItemNum(rs.getInt("item_num"));
				itemInfo.setItemName(rs.getString("item_name"));
				itemInfo.setItemPrice(rs.getInt("item_price"));
				itemInfo.setItemContent(rs.getString("item_content"));
				itemInfo.setItemImage(rs.getString("item_image"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return itemInfo;
	}
	
}

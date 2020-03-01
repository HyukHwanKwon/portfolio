package item;

import java.sql.Connection;
import java.util.ArrayList;

import beans.ItemInfo;
import comm.JdbcUtil;
import static comm.JdbcUtil.*;

public class ItemService {
	ItemData itemData;
	Connection con;
	int x = 0;
	public ItemService() {
		this.itemData = ItemData.getInstance();
		this.con = JdbcUtil.getConnection();
		this.itemData.setConnection(con);
	}
	
	public int itemRegist(ItemInfo itemInfo) throws Exception{
		 x= itemData.registItem(itemInfo);
		
		if(x>0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		return x;
	}
	
	public ArrayList<ItemInfo> itemList() throws Exception{
		ArrayList<ItemInfo> list = itemData.itemList();
		
		if(list != null) {
			commit(con);
			System.out.println("성공");
		}else {
			rollback(con);
			System.out.println("실패");
		}
		return list;
		
	}
	
	public int itemDelete(ItemInfo itemInfo) throws Exception{
		 x= itemData.deleteItem(itemInfo);
		
		if(x>0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		return x;
	}
	
	public int itemModify(ItemInfo itemInfo) throws Exception{
		 x= itemData.modifyItem(itemInfo);
		
		if(x>0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		return x;
	}
	public int itemModifyUpdate(ItemInfo itemInfo) throws Exception{
		 x= itemData.modifyItem(itemInfo);
		
		if(x>0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		return x;
	}
	
	public ItemInfo itemDetail(ItemInfo itemInfo) throws Exception{
		itemInfo = itemData.detailItem(itemInfo);
		
		if(itemInfo !=null) {
			commit(con);
		}
		else {
			rollback(con);
		}
		return itemInfo ;
	}
	
	public void closeConnection() {
		close(con);
	}
}

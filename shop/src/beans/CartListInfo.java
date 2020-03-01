package beans;

public class CartListInfo {
	private String MemberId;
	private int ItemNum;
	private String ItemName;
	private int itemPrice;
	private String itemContent;
	private String itemImage;
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public int getItemNum() {
		return ItemNum;
	}
	public void setItemNum(int itemNum) {
		ItemNum = itemNum;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	
	@Override
	public String toString() {
		return "CartListInfo [MemberId=" + MemberId + ", ItemNum=" + ItemNum + ", ItemName=" + ItemName + ", itemPrice="
				+ itemPrice + ", itemContent=" + itemContent + ", itemImage=" + itemImage + "]";
	}
	
}

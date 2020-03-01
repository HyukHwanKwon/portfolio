package beans;

public class ItemInfo {
	private int itemNum;
	private String itemName;
	private int itemPrice;
	private String itemContent;
	private String itemImage;
	private int itemReadCount;
	
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public int getItemReadCount() {
		return itemReadCount;
	}
	public void setItemReadCount(int itemReadCount) {
		this.itemReadCount = itemReadCount;
	}
	@Override
	public String toString() {
		return "ItemInfo [itemNum=" + itemNum + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemContent="
				+ itemContent + ", itemImage=" + itemImage + ", itemReadCount=" + itemReadCount + "]";
	}
	
}

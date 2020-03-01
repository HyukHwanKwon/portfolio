package beans;

public class CartInfo {
	private String MemberId;
	private int ItemNum;
	
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
	@Override
	public String toString() {
		return "CartInfo [MemberId=" + MemberId + ", ItemNum=" + ItemNum + "]";
	}
	
	
	
	
}

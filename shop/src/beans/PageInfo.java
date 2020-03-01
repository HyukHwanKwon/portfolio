package beans;

public class PageInfo {
	private int page;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int listPage;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getListPage() {
		return listPage;
	}
	public void setListPage(int listPage) {
		this.listPage = listPage;
	}
	
	@Override
	public String toString() {
		return "PageInfo [page=" + page + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", listPage=" + listPage + "]";
	}
	
}

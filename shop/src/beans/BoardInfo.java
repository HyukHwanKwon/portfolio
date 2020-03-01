package beans;

import java.sql.Timestamp;

public class BoardInfo {
	private String BoardId;
	private String BoardTitle;
	private String BoardContent;
	private String BoardImage;
	private Timestamp RegDate;
	private int BoardNum;
	
	public String getBoardId() {
		return BoardId;
	}
	public void setBoardId(String boardId) {
		BoardId = boardId;
	}
	public String getBoardTitle() {
		return BoardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		BoardTitle = boardTitle;
	}
	public String getBoardContent() {
		return BoardContent;
	}
	public void setBoardContent(String boardContent) {
		BoardContent = boardContent;
	}
	public String getBoardImage() {
		return BoardImage;
	}
	public void setBoardImage(String boardImage) {
		BoardImage = boardImage;
	}
	public Timestamp getRegDate() {
		return RegDate;
	}
	public void setRegDate(Timestamp regDate) {
		RegDate = regDate;
	}
	public int getBoardNum() {
		return BoardNum;
	}
	public void setBoardNum(int boardNum) {
		BoardNum = boardNum;
	}
	
	@Override
	public String toString() {
		return "BoardInfo [BoardId=" + BoardId + ", BoardTitle=" + BoardTitle + ", BoardContent=" + BoardContent
				+ ", BoardImage=" + BoardImage + ", RegDate=" + RegDate + ", BoardNum=" + BoardNum + "]";
	}
	
	
}

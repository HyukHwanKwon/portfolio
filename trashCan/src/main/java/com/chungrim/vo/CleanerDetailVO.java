package com.chungrim.vo;

public class CleanerDetailVO {
	private String cleanerName;
	private String trashAmount;
	private String placeName;
	private String detailName;
	private String floorName;
	private String genderName;
	public String getCleanerName() {
		return cleanerName;
	}
	public void setCleanerName(String cleanerName) {
		this.cleanerName = cleanerName;
	}
	public String getTrashAmount() {
		return trashAmount;
	}
	public void setTrashAmount(String trashAmount) {
		this.trashAmount = trashAmount;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	@Override
	public String toString() {
		return "CleanerDetailVO [cleanerName=" + cleanerName + ", trashAmount=" + trashAmount + ", placeName="
				+ placeName + ", detailName=" + detailName + ", floorName=" + floorName + ", genderName=" + genderName
				+ "]";
	}
	
}

package com.chungrim.vo;

public class StatisticsVO {
	private String raspberrypiIp;
	private int placeSeq;
	private int detailSeq;
	private int floorSeq;
	private int genderNum;
	private String placeName;
	private String detailName;
	private String floorName;
	private String genderName;
	private int statisticsUseNum;
	private String date;
	private String month;
	private String day;
	private int max;
	private int trashAmount;
	
	public int getTrashAmount() {
		return trashAmount;
	}
	public void setTrashAmount(int trashAmount) {
		this.trashAmount = trashAmount;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRaspberrypiIp() {
		return raspberrypiIp;
	}
	public void setRaspberrypiIp(String raspberrypiIp) {
		this.raspberrypiIp = raspberrypiIp;
	}
	public int getPlaceSeq() {
		return placeSeq;
	}
	public void setPlaceSeq(int placeSeq) {
		this.placeSeq = placeSeq;
	}
	public int getDetailSeq() {
		return detailSeq;
	}
	public void setDetailSeq(int detailSeq) {
		this.detailSeq = detailSeq;
	}
	public int getFloorSeq() {
		return floorSeq;
	}
	public void setFloorSeq(int floorSeq) {
		this.floorSeq = floorSeq;
	}
	public int getGenderNum() {
		return genderNum;
	}
	public void setGenderNum(int genderNum) {
		this.genderNum = genderNum;
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
	public int getStatisticsUseNum() {
		return statisticsUseNum;
	}
	public void setStatisticsUseNum(int statisticsUseNum) {
		this.statisticsUseNum = statisticsUseNum;
	}
	
	@Override
	public String toString() {
		return "StatisticsVO [raspberrypiIp=" + raspberrypiIp + ", placeSeq=" + placeSeq + ", detailSeq=" + detailSeq
				+ ", floorSeq=" + floorSeq + ", genderNum=" + genderNum + ", placeName=" + placeName + ", detailName="
				+ detailName + ", floorName=" + floorName + ", genderName=" + genderName + ", statisticsUseNum="
				+ statisticsUseNum + ", date=" + date + ", month=" + month + ", day=" + day + ", max=" + max
				+ ", trashAmount=" + trashAmount + "]";
	}
}

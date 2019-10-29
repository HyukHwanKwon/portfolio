package com.chungrim.vo;

public class RaspberrypiVO {
	private String raspberrypiIp;
	private String raspberrypiStatus;
	private int placeSeq;
	private int detailSeq;
	private int floorSeq;
	private int genderNum;
	private String placeName;
	private String detailName;
	private String floorName;
	private String genderName;
	private int mappingNum;
	
	public int getMappingNum() {
		return mappingNum;
	}
	public void setMappingNum(int mappingNum) {
		this.mappingNum = mappingNum;
	}
	public String getRaspberrypiIp() {
		return raspberrypiIp;
	}
	public void setRaspberrypiIp(String raspberrypiIp) {
		this.raspberrypiIp = raspberrypiIp;
	}
	public String getRaspberrypiStatus() {
		return raspberrypiStatus;
	}
	public void setRaspberrypiStatus(String raspberrypiStatus) {
		this.raspberrypiStatus = raspberrypiStatus;
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
	
	@Override
	public String toString() {
		return "RaspberrypiVO [raspberrypiIp=" + raspberrypiIp + ", raspberrypiStatus=" + raspberrypiStatus
				+ ", placeSeq=" + placeSeq + ", detailSeq=" + detailSeq + ", floorSeq=" + floorSeq + ", genderNum="
				+ genderNum + ", placeName=" + placeName + ", detailName=" + detailName + ", floorName=" + floorName
				+ ", genderName=" + genderName + "]";
	}
}

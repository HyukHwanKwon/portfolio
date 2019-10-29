package com.chungrim.vo;

public class CleanerVO {
	private String cleanerId;
	private String cleanerPassword;
	private String cleanerName;
	private String cleanerStatus;
	private String cleanerPhone;
	private String cleanerToken;
	
	public String getCleanerId() {
		return cleanerId;
	}
	public void setCleanerId(String cleanerId) {
		this.cleanerId = cleanerId;
	}
	public String getCleanerPassword() {
		return cleanerPassword;
	}
	public void setCleanerPassword(String cleanerPassword) {
		this.cleanerPassword = cleanerPassword;
	}
	public String getCleanerName() {
		return cleanerName;
	}
	public void setCleanerName(String cleanerName) {
		this.cleanerName = cleanerName;
	}
	public String getCleanerStatus() {
		return cleanerStatus;
	}
	public void setCleanerStatus(String cleanerStatus) {
		this.cleanerStatus = cleanerStatus;
	}
	public String getCleanerPhone() {
		return cleanerPhone;
	}
	public void setCleanerPhone(String cleanerPhone) {
		this.cleanerPhone = cleanerPhone;
	}
	public String getCleanerToken() {
		return cleanerToken;
	}
	public void setCleanerToken(String cleanerToken) {
		this.cleanerToken = cleanerToken;
	}
	@Override
	public String toString() {
		return "CleanerVO [cleanerId=" + cleanerId + ", cleanerPassword=" + cleanerPassword + ", cleanerName="
				+ cleanerName + ", cleanerStatus=" + cleanerStatus + ", cleanerPhone=" + cleanerPhone
				+ ", cleanerToken=" + cleanerToken + "]";
	}
	
	
}

package com.chungrim.vo;

import java.util.Date;

public class MappingVO {
	private String raspberrypiIp;
	private String cleanerId;
	private Date mappingDate;
	private String cleanerName;
	public String getCleanerName() {
		return cleanerName;
	}
	public void setCleanerName(String cleanerName) {
		this.cleanerName = cleanerName;
	}
	public String getRaspberrypiIp() {
		return raspberrypiIp;
	}
	public void setRaspberrypiIp(String raspberrypiIp) {
		this.raspberrypiIp = raspberrypiIp;
	}
	public String getCleanerId() {
		return cleanerId;
	}
	public void setCleanerId(String cleanerId) {
		this.cleanerId = cleanerId;
	}
	public Date getMappingDate() {
		return mappingDate;
	}
	public void setMappingDate(Date mappingDate) {
		this.mappingDate = mappingDate;
	}
}

package beans;

public class ManagerInfo {
	private String ManagerId;
	private String ManagerPassword;
	public String getManagerId() {
		return ManagerId;
	}
	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}
	public String getManagerPassword() {
		return ManagerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		ManagerPassword = managerPassword;
	}
	
	@Override
	public String toString() {
		return "ManagerInfo [ManagerId=" + ManagerId + ", ManagerPassword=" + ManagerPassword + "]";
	}
	
	
}

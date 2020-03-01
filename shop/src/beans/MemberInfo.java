package beans;

public class MemberInfo {
	private String MemberId;
	private String MemberPassword;
	private String MemberName;
	private int MemberPhone;
	private String MemberEmail;
	
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getMemberPassword() {
		return MemberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		MemberPassword = memberPassword;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public int getMemberPhone() {
		return MemberPhone;
	}
	public void setMemberPhone(int memberPhone) {
		MemberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return MemberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		MemberEmail = memberEmail;
	}
	
	@Override
	public String toString() { // << 문자값으로 바꿈
		return "MemberInfo [MemberId=" + MemberId + ", MemberPassword=" + MemberPassword + ", MemberName=" + MemberName
				+ ", MemberPhone=" + MemberPhone + ", MemberEmail=" + MemberEmail + "]";
	}
	
}

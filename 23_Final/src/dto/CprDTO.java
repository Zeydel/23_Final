package dto;

public class CprDTO {
	private int userID;
	private String cpr;

	public CprDTO(int userID, String cpr) {
		this.userID=userID;
		this.cpr=cpr;
	}
	
	public CprDTO() {
		
	}	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}




}

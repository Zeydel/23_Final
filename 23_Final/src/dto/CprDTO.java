package dto;

public class CprDTO {
	private int userID;
	private int cpr;

	public CprDTO(int userID, int cpr) {
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

	public int getCpr() {
		return cpr;
	}

	public void setCpr(int cpr) {
		this.cpr = cpr;
	}
	
	




}

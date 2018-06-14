package dto;

public class RoleDTO {
	
	int userID;
	String role;
	
	//Contains information about a users role. Each user can have multiple roles
	public RoleDTO(int userID, String role) {
		this.userID = userID;
		this.role = role;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}

package dto;

public class UserDTO {	
	private int userID;
	private String userName;
	private String initials;
	private String password;
	private String repeat_password;
	
	
	public UserDTO(int userID, String userName, String initials, String password) {
		this.userID = userID;
		this.userName = userName;
		this.initials = initials;
		this.password = password;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getInitials() {
		return initials;
	}


	public void setInitials(String initials) {
		this.initials = initials;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRepeat_password() {
		return repeat_password;
	}


	public void setRepeat_password(String repeat_password) {
		this.repeat_password = repeat_password;
	}


}

package dto;
import java.util.ArrayList;

public class UserViewDTO {
	private int userID;
	private String userName;
	private String initials;
	private String password;
	private int cpr;
	private ArrayList<String> roles;
	private String repeat_password;
	
	
	//Contains all information about a user.
	public UserViewDTO(int userID, String userName, String initials, String password, int cpr, ArrayList<String> roles) {
		this.userID = userID;
		this.userName = userName;
		this.initials = initials;
		this.password = password;
		this.cpr = cpr;
		this.roles = roles;
	}
	public String toString() {
		return (userID + userName + initials + password + cpr + roles);
	}

	//Empty constructor for JSON
	public UserViewDTO() {
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

	public int getCpr() {
		return cpr;
	}
	public void setCpr(int cpr) {
		this.cpr = cpr;
	}
	public ArrayList<String> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}

	public String getRepeat_password() {
		return repeat_password;
	}

	public void setRepeat_password(String repeat_password) {
		this.repeat_password = repeat_password;
	}
	
	
	
	
}

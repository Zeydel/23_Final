package dal;
import java.util.ArrayList;

public class UserDTO {
	private int userID;
	private String userName;
	private String initials;
	private String password;
	private String cpr;
	private ArrayList<String> roles;
	
	public UserDTO(int userID, String userName, String initials, String password, String cpr, ArrayList<String> roles) {
		this.userID = userID;
		this.userName = userName;
		this.initials = initials;
		this.password = password;
		this.cpr = cpr;
		this.roles = roles;
	}

	//Empty constructor for JSON
	public UserDTO() {
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

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public ArrayList<String> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}
	
	
}

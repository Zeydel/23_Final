/*package npdao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dto.DALException;
import dto.RecipeDTO;
import dto.UserDTO;
import dto.UserViewDTO;

public class NpUserDAO {
	
	ArrayList<UserDTO> Users = new ArrayList<UserDTO>();
	public NpUserDAO() {
		Users.add(new UserDTO(1, "Angelo A", "AA", "lKie4fa"));
		Users.add(new UserDTO(2, "Antonella B", "AB", "atoJ21v"));
		Users.add(new UserDTO(3, "Luigi C", "LC", "iEfm5aO"));
	}
	
	public UserDTO getUser(int userID) throws DALException {
		for(UserDTO user : Users) {
			if(user.getUserID() == userID) {
				return user;
			}
		}
		throw new DALException("User with ID" + userID + " not found.");
	}
	
	public List<UserDTO> getUserList(){
		return Users;
	}
	
	public void createUser(UserDTO user) {
		Users.add(user);
	}
	
	public void updateUser(UserDTO user) throws DALException {
		for(int i = 0; i < Users.size(); i++) {
			if(Users.get(i).getUserID() == user.getUserID()) {
				Users.set(i, user);
				return;
			}
		} throw new DALException("User with ID" + user.getUserID() + " not found.");
	}
	
	public void deleteUser(int userID) throws DALException {
		for(int i = 0; i < Users.size(); i++) {
			if(Users.get(i).getUserID() == userID) {
				Users.remove(i);
				return;
			}
		} throw new DALException("User with ID" + userID + " not found.");
	}

}
*/
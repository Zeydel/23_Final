package npdao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dto.DALException;
import dto.RecipeDTO;
import dto.UserViewDTO;

public class NpUserDAO {
	
	ArrayList<UserViewDTO> Users = new ArrayList<UserViewDTO>();
	public NpUserDAO() {
		Users.add(new UserViewDTO(1, "Angelo A", "AA", "lKie4fa", 8019761, new ArrayList<String>(Arrays.asList("Admin", "Pharmacist"))));
		Users.add(new UserViewDTO(2, "Antonella B", "AB", "atoJ21v", 1234567890, new ArrayList<String>(Arrays.asList("Pharmacist"))));
		Users.add(new UserViewDTO(3, "Luigi C", "LC", "iEfm5aO", 98763210, new ArrayList<String>(Arrays.asList("Admin"))));
	}
	
	public UserViewDTO getUser(int userID) throws DALException {
		for(UserViewDTO user : Users) {
			if(user.getUserID() == userID) {
				return user;
			}
		}
		throw new DALException("User with ID" + userID + " not found.");
	}
	
	public List<UserViewDTO> getUserList(){
		return Users;
	}
	
	public void createUser(UserViewDTO user) {
		Users.add(user);
		for(int i = 0; i<Users.size();i++) {
			System.out.println(Users.get(i).toString());
		}
	}
	
	public void updateUser(UserViewDTO user) throws DALException {
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

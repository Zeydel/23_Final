package npdao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import dto.CprDTO;
import dto.DALException;
import dto.RoleDTO;
import dto.UserDTO;
import dto.UserViewDTO;

public class NpUserViewDAO {
	
	
	
	ArrayList<UserViewDTO> UserViews = new ArrayList<UserViewDTO>();
	NpStorage Storage = new NpStorage();
	public NpUserViewDAO() {
		try {
			UserDTO user = null;
			CprDTO cpr = null;
			ArrayList<String> sroles = null;
			
		for(int i = 0; i < Storage.getUser().getUserList().size();i++) {
			user = Storage.getUser().getUserList().get(i);
			cpr = Storage.getCpr().getCpr(user.getUserID());
			ArrayList<RoleDTO> roles = Storage.getRole().getRolesList(user.getUserID());
			sroles = new ArrayList<String>();
			for(int j = 0; j < roles.size(); j++) {
				sroles.add(roles.get(j).getRole());
			}
		}
			
				createUserView(new UserViewDTO(user.getUserID(), user.getUserName(), user.getInitials(), user.getPassword(), cpr.getCpr(), sroles));
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public UserViewDTO getUserView(int userID) throws DALException {
		for(UserViewDTO userView : UserViews) {
			if(userView.getUserID()==userID) {
				return userView;
			}
		} throw new DALException("User with ID " + userID + " doesn't exist");
	}
	
	public List<UserViewDTO> getUserList(){
		return UserViews;
	}
	
	public void createUserView(UserViewDTO UserView) throws DALException {
		UserViews.add(UserView);
	}
	
	public void updateUserView(UserViewDTO UserView) throws DALException {
		for(int i = 0; i<UserViews.size(); i++) {
			if(UserViews.get(i).getUserID()==UserView.getUserID()) {
				UserViews.set(i, UserView);
				return;
			}
		}
	}
	
	public void deleteUserView(int userID) throws DALException{
		for(int i = 0; i<UserViews.size(); i++) {
			if(UserViews.get(i).getUserID()==userID) {
				UserViews.remove(i);
			}
		} throw new DALException("User with user ID " + userID + " doesn't exist");
	}
}


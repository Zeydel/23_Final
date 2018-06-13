package npdao;

import java.util.ArrayList;
import java.util.List;

import dto.CprDTO;
import dto.DALException;
import dto.RoleDTO;

public class NpRoleDAO {
	
ArrayList<RoleDTO> roles = new ArrayList<RoleDTO>();
	
	public NpRoleDAO() {
		roles.add(new RoleDTO(1, "Administrator"));
		roles.add(new RoleDTO(2, "Pharmacologist"));
		roles.add(new RoleDTO(3, "Administrator"));
	}
	
	public RoleDTO getRole(int userID) throws DALException{
		for(RoleDTO roles : roles) {
			if(roles.getUserID()== userID) {
				return roles;
			}
				
		} throw new DALException("Role(s) with ID " + userID + " Not found");
	}
	
	public ArrayList<RoleDTO> getRolesList(int userID){
		ArrayList<RoleDTO> userRoles = new ArrayList<RoleDTO>();
		for(int i = 0; i < roles.size(); i++) {
			if(roles.get(i).getUserID() == userID ) {
				userRoles.add(roles.get(i));
			}
		}
		return userRoles;
	}
	
	public ArrayList<RoleDTO> getRolesList(){  
		return roles;
	}

	public void createRole(RoleDTO Role) throws DALException{
		roles.add(Role);
	}
	
	public void updateRole(RoleDTO role) throws DALException{
		for(int i = 0; i<roles.size(); i++) {
			if(roles.get(i).getUserID() == role.getUserID()) {
				roles.set(i, role);
				return;
			}
		}throw new DALException("Role(s) with ID " + role.getUserID() + " doesn't exist");
	}
	
	public void deleteRole(int userID) throws DALException {
		int size = roles.size();
		for(int i = 0; i < roles.size(); i++) {
			if(roles.get(i).getUserID() == userID) {
				roles.remove(i);
			}
		}if(size==roles.size()) {
			throw new DALException("Role with user ID " + userID + " Doesn't exist.");
		}
	}
	

	
	

}

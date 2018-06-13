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
	
	public CprDTO getCpr(int userID) throws DALException{
		for(CprDTO roles : roles) {
			if(recipe.getUserID()== userID) {
				return recipe;
			}
				
		} throw new DALException("Recipe with recipe ID" + userID + " Not found");
	}
	
	public List<CprDTO> getCprList(){  
		return recipes;
	}

	public void createCpr(CprDTO Recipe){
		recipes.add(Recipe);
	}
	
	public void updateCpr(CprDTO user) throws DALException{
		for(int i = 0; i<recipes.size(); i++) {
			if(recipes.get(i).getUserID() == user.getUserID()) {
				recipes.set(i, user);
				return;
			}
		}throw new DALException("Recipe with Recipe ID " + user.getUserID() + " doesn't exist");
	}
	
	public void deleteCpr(int userID) throws DALException {
		for(int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).getUserID() == userID) {
				recipes.remove(i);
				return;
			}
		}throw new DALException("Recipe with recipe ID " + userID + "Doesn't exist.");
	}
	

	
	

}

package npdao;

import java.util.ArrayList;
import java.util.List;

import dto.CprDTO;
import dto.DALException;
import dto.ProductBatchComponentDTO;
import dto.RecipeDTO;

public class NpCprDAO {
	
	ArrayList<CprDTO> recipes = new ArrayList<CprDTO>();
	
	public NpCprDAO() {
		recipes.add(new CprDTO(1, 12345678));
		recipes.add(new CprDTO(2, 12890890));
		recipes.add(new CprDTO(3, 21898890));
	}
	
	public CprDTO getCpr(int userID) throws DALException{
		for(CprDTO recipe : recipes) {
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

/*package npdao;

import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RawMaterialDTO;
import dto.RecipeComponentDTO;

public class NpRecipeComponentDAO {

	ArrayList<RecipeComponentDTO> RecipeComponents = new ArrayList<RecipeComponentDTO>();
	public NpRecipeComponentDAO() {
		RecipeComponents.add(new RecipeComponentDTO(1, 1, 10f, 0.1f));
		RecipeComponents.add(new RecipeComponentDTO(1, 2, 2f, 0.1f));
		RecipeComponents.add(new RecipeComponentDTO(2, 3, 2f, 0.1f));
	}
	
	public RecipeComponentDTO getRecipeComponent(int recipeID, int rawMaterialID) throws DALException{
		for(RecipeComponentDTO RecipeComponent : RecipeComponents) {
			if(RecipeComponent.getRecipeID()==recipeID && RecipeComponent.getRawMaterialID()==rawMaterialID) {
				return RecipeComponent;
			}
		} throw new DALException("Recipe Component with recipe ID " + recipeID + " and " + rawMaterialID + " Doesn't exist.");
	}
	
	public List<RecipeComponentDTO> getRecipeComponentList(){
		return RecipeComponents;
	}
	
	public void createRecipeComponent(RecipeComponentDTO RecipeComponent) throws DALException{
		RecipeComponents.add(RecipeComponent);
	}
	
	public void updateRecipeComponent(RecipeComponentDTO RecipeComponent) throws DALException{
		for(int i = 0; i < RecipeComponents.size(); i++) {
			if(RecipeComponents.get(i).getRecipeID()==RecipeComponent.getRecipeID() && RecipeComponents.get(i).getRawMaterialID()==RecipeComponent.getRawMaterialID()){
				RecipeComponents.set(i, RecipeComponent);
				return;
			}
		}throw new DALException("Recipe Component with recipe ID " + RecipeComponent.getRecipeID() + " and " + RecipeComponent.getRawMaterialID() + " Doesn't exist.");
	}
	public void deleteReceptComponent(int recipeID, int rawMaterialID) throws DALException{
		for(int i = 0; i < RecipeComponents.size(); i++) {
			if(RecipeComponents.get(i).getRecipeID()==recipeID && RecipeComponents.get(i).getRawMaterialID()==rawMaterialID){
				RecipeComponents.remove(i);
				return;
			}
		}throw new DALException("Recipe Component with recipe ID " + recipeID + " and " + rawMaterialID + " Doesn't exist.");

	}
	
}
*/
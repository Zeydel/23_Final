package dao;

import java.util.ArrayList;
import java.util.List;

import dto.RecipeComponentDTO;
import dto.RecipeDTO;

public class NpRecipeDAO {
	
	ArrayList<RecipeDTO> Recipes = new ArrayList<RecipeDTO>();
	public NpRecipeDAO() {
		Recipes.add(new RecipeDTO(1, "Margherita"));
		Recipes.add(new RecipeDTO(2, "Prosciutto"));
		Recipes.add(new RecipeDTO(3, "Capricciosa"));
	}
	
	public RecipeDTO getRecipe(int recipeID) throws DALException{
		for(RecipeDTO recipe : Recipes) {
			if(recipe.getRecipeID()== recipeID) {
				return recipe;
			}
				
		} throw new DALException("Recipe with recipe ID" + recipeID + " Not found");
	}
	
	public List<RecipeDTO> getRecipeList(){  
		return Recipes;
	}

	public void createRecipe(RecipeDTO Recipe){
		Recipes.add(Recipe);
	}
	
	public void updateRecipe(RecipeDTO Recipe) throws DALException{
		for(int i = 0; i<Recipes.size(); i++) {
			if(Recipes.get(i).getRecipeID() == Recipe.getRecipeID()) {
				Recipes.set(i, Recipe);
				return;
			}
		}throw new DALException("Recipe with Recipe ID " + Recipe.getRecipeID() + " doesn't exist");
	}
	
	public void deleteRecipe(int recipeID) throws DALException {
		for(int i = 0; i < Recipes.size(); i++) {
			if(Recipes.get(i).getRecipeID() == recipeID) {
				Recipes.remove(i);
				return;
			}
		}throw new DALException("Recipe with recipe ID " + recipeID + "Doesn't exist.");
	}
	
}

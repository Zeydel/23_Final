package dao;

import java.util.ArrayList;

import dto.RecipeDTO;

public class NpRecipeDAO {
	
	ArrayList<RecipeDTO> Recipes;
	public NpRecipeDAO() {
		Recipes.add(new RecipeDTO(1, "Margherita"));
		Recipes.add(new RecipeDTO(2, "Prosciutto"));
		Recipes.add(new RecipeDTO(3, "Capricciosa"));
	}

}

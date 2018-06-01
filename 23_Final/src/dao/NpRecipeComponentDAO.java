package dao;

import java.util.ArrayList;

import dto.RecipeComponentDTO;

public class NpRecipeComponentDAO {

	ArrayList<RecipeComponentDTO> RecipeComponents;
	public NpRecipeComponentDAO() {
		RecipeComponents.add(new RecipeComponentDTO(1, 1, 10f, 0.1f));
		RecipeComponents.add(new RecipeComponentDTO(1, 2, 2f, 0.1f));
		RecipeComponents.add(new RecipeComponentDTO(2, 3, 2f, 0.1f));
	}
	
}

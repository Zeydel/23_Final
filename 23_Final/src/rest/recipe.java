package rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.NpStorage;
import dto.RecipeDTO;




@Path("recipes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class recipe {
	static NpStorage Storage = new NpStorage();
	
	@POST
	public boolean createRecipe(RecipeDTO recipe) {
		Storage.getRecipe().createRecipe(recipe);
		return true;
	}
	
	@GET
	public List<RecipeDTO> getRecipes() {
		return Storage.getRecipe().getRecipeList();
	}
	
}

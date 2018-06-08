package rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dbdao.DbStorage;
import dto.DALException;
import dto.RecipeDTO;
import npdao.NpStorage;




@Path("/recipes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Recipe {
	//static NpStorage Storage = new NpStorage();
	DbStorage Storage = new DbStorage();
	
	@POST
	public boolean createRecipe(RecipeDTO recipe) {
		try {
			Storage.getRecipe().createRecipe(recipe);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@GET
	public List<RecipeDTO> getRecipes() {
		try {
			return Storage.getRecipe().getRecipeList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

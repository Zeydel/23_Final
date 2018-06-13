package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dbdao.DbStorage;
import dto.CprDTO;
import dto.DALException;
import dto.RecipeDTO;
import dto.RoleDTO;
import dto.UserDTO;
import dto.UserViewDTO;
import npdao.NpStorage;




@Path("/recipes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Recipe {
	static NpStorage Storage = new NpStorage();
	//DbStorage Storage = new DbStorage();
	
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
	
	@DELETE
	@Path("{recipeID}")
	public void deleteRecipe(@PathParam("recipeID")String recipeID) {
		try {
			Storage.getRecipe().deleteRecipe(Integer.parseInt(recipeID));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("{recipeID}")
	public RecipeDTO getRecipe(@PathParam("recipeID")String recipeID){
		try {
			return Storage.getRecipe().getRecipe(Integer.parseInt(recipeID));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@Path("/edit")
	public void editUser(RecipeDTO recipe) {
		try {
			recipe.setRecipeID(recipe.getRecipeID()+1);
			Storage.getRecipe().updateRecipe(recipe);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

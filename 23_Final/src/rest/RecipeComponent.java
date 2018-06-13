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
import dto.RecipeComponentDTO;




@Path("/recipeComponent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecipeComponent {
	//static NpStorage Storage = new NpStorage();
	DbStorage Storage = new DbStorage();
	
	@POST
	public boolean createRecipeComponent(RecipeComponentDTO recipeComponent) {
		try {
			Storage.getRecipeComponent().createReceptKomp(recipeComponent);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@GET
	public List<RecipeComponentDTO> getRecipeComponents() {
		try {
			return Storage.getRecipeComponent().getRecipeComponentList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@DELETE
	@Path("{value}")
	public void deleteRecipeComponent(@PathParam("value")String ID) {
		String [] ids = ID.split("-");
		try {
			Storage.getRecipeComponent().deleteRecipeComponent(Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("{value}")
	public RecipeComponentDTO getRecipeComponent(@PathParam("value")String ID){
		String [] ids = ID.split("-");
		try {
			return Storage.getRecipeComponent().getRecipeComponent(Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
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
	public void editRecipeComponent(RecipeComponentDTO recipeComponent) {
		try {
			recipeComponent.setRecipeID(recipeComponent.getRecipeID());
			recipeComponent.setRawMaterialID(recipeComponent.getRawMaterialID());;
			Storage.getRecipeComponent().updateRecipeComponent(recipeComponent);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
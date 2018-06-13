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

import dto.DALException;
import dto.RawMaterialDTO;
import dto.RecipeDTO;
import dto.UserViewDTO;
import npdao.NpStorage;
import dbdao.DbStorage;

@Path("rawmaterial")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RawMaterial {
	static DbStorage Storage = new DbStorage();
	//static NpStorage Storage = new NpStorage();
	
	@POST
	public boolean createRawMaterial(RawMaterialDTO rawMaterial) throws DALException {
		Storage.getRawMaterial().createRawMaterial(rawMaterial);
		return true;
	}
	
	@POST
	@Path("/edit")
	public void editRawMaterial(RawMaterialDTO rawMaterial) {
		try {
			//rawMaterial.setRawMaterialID(rawMaterial.getRawMaterialID());
			Storage.getRawMaterial().updateRawMaterial(rawMaterial);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	public List<RawMaterialDTO> getRawMaterials() throws DALException {
		return Storage.getRawMaterial().getRawMaterialList();
	}
	
	@GET
	@Path("{rawMaterialID}")
	public RawMaterialDTO getRecipe(@PathParam("rawMaterialID")String rawMaterialID){
		try {
			return Storage.getRawMaterial().getRawMaterial(Integer.parseInt(rawMaterialID));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@DELETE
	@Path("{rawMaterialID}")
	public void deleteRawMaterial(@PathParam("rawMaterialID")int rawMaterialID) {
		try {
			
			Storage.getRawMaterial().deleteRawMaterial(rawMaterialID);
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

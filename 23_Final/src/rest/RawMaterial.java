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
import dto.UserViewDTO;
import dbdao.DbStorage;

@Path("rawmaterial")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RawMaterial {
	static DbStorage Storage = new DbStorage();
	
	@POST
	public boolean createRawMaterial(RawMaterialDTO rawMaterial) throws DALException {
		Storage.getRawMaterial().createRawMaterial(rawMaterial);
		return true;
	}
	
	@GET
	public List<RawMaterialDTO> getUsers() throws DALException {
		return Storage.getRawMaterial().getRawMaterialList();
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

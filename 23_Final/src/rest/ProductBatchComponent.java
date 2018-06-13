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
import dto.ProductBatchComponentDTO;




@Path("/ProductBatchComponent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductBatchComponent {
	static DbStorage Storage = new DbStorage();
	//static NpStorage Storage = new NpStorage();
	
	@POST
	public boolean createProductBatchComponent() {
		return true;
	}
	
	@GET
	public List<ProductBatchComponentDTO> getProductBatchComponent() {
		try {
			return Storage.getProductBatchComponent().getProductBatchKomponentList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

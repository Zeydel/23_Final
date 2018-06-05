package rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.NpStorage;
import dto.ProductBatchComponentDTO;




@Path("ProductBatchComponent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductBatchComponent {
	static NpStorage Storage = new NpStorage();
	
	@POST
	public boolean createProductBatchComponent() {
		return true;
	}
	
	@GET
	public List<ProductBatchComponentDTO> getProductBatchComponent() {
		return Storage.getProductBatchComponent().getProductBatchKomponentList();
	}
}

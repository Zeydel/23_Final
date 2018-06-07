package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.ProductBatchViewDTO;
import dto.UserViewDTO;
import npdao.NpStorage;

@Path("/productbatchviews")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductBatchView {
static NpStorage Storage = new NpStorage();
	
	@POST
	public boolean createUser(UserViewDTO user) {
		Storage.getUser().createUser(user);
		return true;
	}
	
	@GET
	public List<ProductBatchViewDTO> getProductBatchView() {
		return Storage.getProductBatchView().getProductBatchViewList();
	}
}

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
import dto.DALException;
import dto.ProductBatchDTO;
import dto.ProductBatchViewDTO;
import dto.UserViewDTO;

@Path("/productbatchviews")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductBatchView {
DbStorage Storage = new DbStorage();
	
	@POST
	public boolean createProductBatch(ProductBatchDTO productBatch) {
		try {
			Storage.getProductBatch().createProductBatch(new ProductBatchDTO(productBatch.getProductBatchID(), productBatch.getStatus(), productBatch.getRecipeID()));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@POST
	@Path("/edit")
	public void editProductBatch(ProductBatchDTO productBatch) {
		try{
			Storage.getProductBatch().updateProductBatch(new ProductBatchDTO(productBatch.getProductBatchID(), productBatch.getStatus(), productBatch.getRecipeID()));
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	
	@GET
	public List<ProductBatchViewDTO> getProductBatchView() {
		try{
		return Storage.getProductBatchView().getProductBatchViewList();
	}catch (DALException e) {
		e.printStackTrace();
	}
		return null;
	}
	
	@GET
	@Path("{productBatchID}")
	public ProductBatchDTO getProductBatch(@PathParam("productBatchID")String productBatchID) {
		try {
			return Storage.getProductBatch().getProductBatch(Integer.parseInt(productBatchID));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	@DELETE
	@Path("{productBatchID}")
	public void deleteProductBatch(@PathParam("productBatchID")String productBatchID) {
		try {
			Storage.getProductBatch().deleteProductBatch(Integer.parseInt(productBatchID));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

	
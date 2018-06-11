package rest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import dto.RawMaterialBatchViewDTO;

	@Path("rawMaterialBatch")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
public class RawMaterialBatchView {
		static DbStorage Storage = new DbStorage();
		
		@POST
		public boolean createRawMaterialBatch(RawMaterialBatchViewDTO RawMaterialBatchView) {
			return true;
		}
		
		@GET
		public List<RawMaterialBatchViewDTO> getRawMaterialViewList() throws DALException{
			return Storage.getRawMaterialBatch().getRawMaterialBatchList();
		}
		
		
		@DELETE
		@Path("{rawMaterialBatchID}")
		public void deleteRawMaterialBatch(@PathParam("rawMaterialBatchID")int rawMaterialBatchID) {
			try {
				
				Storage.getRawMaterialBatch().deleteRawMaterialBatch(rawMaterialBatchID);
				
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}



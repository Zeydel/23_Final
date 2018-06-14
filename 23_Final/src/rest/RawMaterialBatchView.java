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
import dto.RawMaterialBatchDTO;
import dto.RawMaterialBatchViewDTO;


	@Path("rawMaterialBatch")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
public class RawMaterialBatchView {
		static DbStorage Storage = new DbStorage();
		//static NpStorage Storage = new NpStorage();
		
		@POST
		public void createRawMaterialBatch(RawMaterialBatchDTO rawMaterialBatch) throws DALException {
			Storage.getRawMaterialBatch().createRawMaterialBatch(rawMaterialBatch);
		}
		
		@POST
		@Path("/edit")
		public void editRawMaterialBatch(RawMaterialBatchDTO rawMaterialBatch) {
			try {
				//rawMaterial.setRawMaterialID(rawMaterial.getRawMaterialID());
				Storage.getRawMaterialBatch().updateRawMaterialBatch(rawMaterialBatch);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@GET
		public List<RawMaterialBatchViewDTO> getRawMaterialViewList() throws DALException{
			return Storage.getRawMaterialBatch().getRawMaterialBatchList();
		}
		
		@GET
		@Path("{rawMaterialBatchID}")
		public RawMaterialBatchViewDTO getRawMaterialBatch(@PathParam("rawMaterialBatchID")String rawMaterialBatchID){
			try {
				return Storage.getRawMaterialBatch().getRawMaterialBatchView(Integer.parseInt(rawMaterialBatchID));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@GET
		@Path("/batches/{rawMaterialBatchID}")
		public List<RawMaterialBatchDTO> getRawMaterialBatches(@PathParam("rawMaterialID")String rawMaterialBatchID){
			try {
				return Storage.getRawMaterialBatch().getRawMaterialBatchList(Integer.parseInt(rawMaterialBatchID));
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



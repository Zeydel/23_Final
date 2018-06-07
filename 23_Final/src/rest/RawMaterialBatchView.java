package rest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.RawMaterialBatchViewDTO;
import dto.UserViewDTO;
import npdao.NpStorage;
import npdao.NpUserDAO;

	@Path("rawMaterialBatchView")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
public class RawMaterialBatchView {
		static NpStorage Storage = new NpStorage();
		
		@POST
		public boolean createRawMaterialBatchView(RawMaterialBatchViewDTO RawMaterialView) {
			return true;
		}
		
		@GET
		public List<RawMaterialBatchViewDTO> getRawMaterialViewList(){
			return Storage.getRawMaterialBatchView().getRawMaterialViewList();
		}
		
		
}



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
import dto.UserViewDTO;
import npdao.NpStorage;
import npdao.NpUserDAO;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class User {
	//static NpStorage Storage = new NpStorage();
	DbStorage Storage = new DbStorage();
//	
//	@POST
//	public boolean createUser(UserViewDTO user) {
//		Storage.getUser().createUser(user);
//		return true;
//	}
//	
//	@POST
//	@Path("/edit")
//	public void editUser(UserViewDTO user) {
//		try {
//			Storage.getUser().updateUser(user);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@GET
	public List<UserViewDTO> getUsers() {
		try {
			return Storage.getUser().getUserList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("{userID}")
	public UserViewDTO getUser(@PathParam("userID")String userID) {
		try {
			return Storage.getUser().getUser(Integer.parseInt(userID));
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
//	
//	
//	@DELETE
//	@Path("{userID}")
//	public void deleteUser(@PathParam("userID")String userID) {
//		try {
//			Storage.getUser().deleteUser(Integer.parseInt(userID));
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//
//	
//	
	
}

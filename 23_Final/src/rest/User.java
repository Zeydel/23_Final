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

import dao.DALException;
import dao.NpStorage;
import dao.NpUserDAO;
import dto.UserDTO;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class User {
	static NpStorage Storage = new NpStorage();
	
	@POST
	public boolean createUser(UserDTO user) {
		Storage.getUser().createUser(user);
		return true;
	}
	
	@GET
	public List<UserDTO> getUsers() {
		return Storage.getUser().getUserList();
	}
	
	@GET
	@Path("{userID}")
	public UserDTO getUser(@PathParam("userID")String userID) {
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
	
	
	@DELETE
	@Path("{userID}")
	public void deleteUser(@PathParam("userID")String userID) {
		try {
			Storage.getUser().deleteUser(Integer.parseInt(userID));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@POST
//	@Path("{userID}")
//	public void editUser(@PathParam("userID") UserDTO user) {
//		try {
//			Storage.getUser().updateUser(user);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	
}

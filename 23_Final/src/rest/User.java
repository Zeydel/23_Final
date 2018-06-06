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
	
	@DELETE
	public void deleteUser(int userID) {
		try {
			Storage.getUser().deleteUser(userID);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

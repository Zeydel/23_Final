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

import dao.NpStorage;
import dao.NpUserDAO;
import dto.UserDTO;

@Path("recipes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class recipe {
	static NpStorage Storage = new NpStorage();
	
	@POST
	public boolean createUser(UserDTO recipe) {
		Storage.getUser().createUser(recipe);
		return true;
	}
	
	@GET
	public List<UserDTO> getUsers() {
		return Storage.getUser().getUserList();
	}
	
}

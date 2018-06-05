package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.UserDTO;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Login {

	@POST
	public boolean createUser(UserDTO user) {
		Storage.getUser().createUser(user);
		return true;
	}
	
	@GET
	public List<UserDTO> getUsers() {
		return Storage.getUser().getUserList();
	}
	
}

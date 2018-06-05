package rest;

import java.lang.ProcessBuilder.Redirect;
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
import javax.ws.rs.core.Response;


import dao.NpStorage;
import dao.NpUserDAO;
import dto.UserDTO;

@Path("login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class User {
	
	@POST
	public void verfication() {
		Redirect("/23_Final/html/user-tabel.html");
		redire
	}
	
	
	
}

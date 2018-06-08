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
import dto.CprDTO;
import dto.DALException;
import dto.RoleDTO;
import dto.UserDTO;
import dto.UserViewDTO;
import npdao.NpStorage;
import npdao.NpUserDAO;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class User {
	//static NpStorage Storage = new NpStorage();
	DbStorage Storage = new DbStorage();

	@POST
	public boolean createUser(UserViewDTO user) {
		try {
			Storage.getUser().createUser(new UserDTO(user.getUserID(), user.getUserName(), user.getInitials(), user.getPassword()));
			Storage.getCpr().createCpr(new CprDTO(user.getUserID(), user.getCpr()));
			for(int i = 0; i < user.getRoles().size(); i++) {
				Storage.getRole().createRole(new RoleDTO(user.getUserID(), user.getRoles().get(i)));
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@POST
	@Path("/edit")
	public void editUser(UserViewDTO user) {
		try {
			Storage.getUser().updateUser(new UserDTO(user.getUserID(), user.getUserName(), user.getInitials(), user.getPassword()));
			Storage.getCpr().updateCpr(new CprDTO(user.getUserID(), user.getCpr()));
			Storage.getRole().deleteRole(user.getUserID());
			if(user.getRoles() != null) {
				for(int i = 0; i < user.getRoles().size(); i++) {
					Storage.getRole().createRole(new RoleDTO(user.getUserID(), user.getRoles().get(i)));
				}
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	public List<UserViewDTO> getUsers() {
		try {
			return Storage.getUserView().getUserList();
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
			return Storage.getUserView().getUser(Integer.parseInt(userID));
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





}

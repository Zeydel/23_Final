package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RecipeDTO;
import dto.UserDTO;
import dto.UserViewDTO;

public class DbUserDAO {
	
	public DbUserDAO() {
		try {
			Connector Connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createUser(UserDTO user) throws DALException {
		try {
		Connector.doUpdate(
				"INSERT INTO user(userID, userName, initials, password) VALUES " +
				"('" + user.getUserID() + "', '" + user.getUserName() + "', '" + user.getInitials() + "', '" + user.getPassword() + "')"
			);
		} catch(DALException e) {throw new DALException("User not created"); }
	}

	public void updateUser(UserDTO user) throws DALException {
		try {
		Connector.doUpdate(
				"UPDATE user SET userName = '" + user.getUserName() + "', initials = '" + user.getInitials() + "', password = '"
						+ user.getPassword() + "' WHERE userID = " + user.getUserID());
		
		}
		catch (DALException e) {throw new DALException("User with user id " + user.getUserID() + " doesn't exist"); }

	}
	
	public void deleteUser(int userID) throws DALException {
		try {
		Connector.doUpdate(
				"DELETE FROM user "
				+ "WHERE userID = " + userID + ""
				);
		} catch (DALException e) {throw new DALException("User with user ID " + userID + " Doesn't exist.");}
	}

}


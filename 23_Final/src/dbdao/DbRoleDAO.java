package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RecipeDTO;
import dto.RoleDTO;

public class DbRoleDAO {
	
	public DbRoleDAO() {
		try {
			Connector Connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createRole(RoleDTO role) throws DALException {
		try {
		Connector.doUpdate(
				"INSERT INTO roles(userID, role) VALUES " +
				"('" + role.getUserID() + "', '" + role.getRole() + "')"
			);
		} catch(DALException e) {throw new DALException("Role Not Created"); }
	}

	public void updateRecept(RoleDTO role) throws DALException {
		try {
		Connector.doUpdate(
				"UPDATE role SET role = '" + role.getRole() + "' WHERE userID = " +
				role.getUserID()
		);
		}
		catch (DALException e) {throw new DALException("User with ID " + role.getUserID() + " doesn't exist"); }

	}
	
	public void deleteRole(int userID) throws DALException {
		try {
		Connector.doUpdate(
				"DELETE FROM roles "
				+ "WHERE userID = '" + userID + "';"
				);
		} catch (DALException e) {throw new DALException("User with ID " + userID + " Doesn't exist.");}
	}

}

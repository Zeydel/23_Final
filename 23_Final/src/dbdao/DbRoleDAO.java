package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RecipeDTO;

public class DbRoleDAO {
	
	public DbRoleDAO() {
		try {
			Connector Connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createRecipe(RecipeDTO recipe) throws DALException {
		try {
		Connector.doUpdate(
				"INSERT INTO recept(recept_id, recept_navn) VALUES " +
				"(" + recipe.getRecipeID() + ", '" + recipe.getRecipeName() + "')"
			);
		} catch(DALException e) {throw new DALException("Recipe Not Created"); }
	}

	public void updateRecept(RecipeDTO recipe) throws DALException {
		try {
		Connector.doUpdate(
				"UPDATE recept SET recept_navn = '" + recipe.getRecipeName() + "' WHERE recept_id = " +
				recipe.getRecipeID()
		);
		}
		catch (DALException e) {throw new DALException("Recipe with Recipe ID " + recipe.getRecipeID() + " doesn't exist"); }

	}
	
	public void deleteRole(int userID) throws DALException {
		try {
		Connector.doUpdate(
				"DELETE FROM role "
				+ "WHERE userID = " + userID
				);
		} catch (DALException e) {throw new DALException("Recipe with recipe ID " + userID + "Doesn't exist.");}
	}

}

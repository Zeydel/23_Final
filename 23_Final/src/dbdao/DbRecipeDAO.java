package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RecipeDTO;

public class DbRecipeDAO {
	
	public DbRecipeDAO() {
		try {
			Connector Connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RecipeDTO getRecipe(int recipeID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM recipe WHERE recipeID = " + recipeID);
	    try {
	    	if (!rs.first()) throw new DALException("Recepten " + recipeID + " findes ikke");
	    	return new RecipeDTO (rs.getInt("recipeID"), rs.getString("recipeName"));
	    }
	    catch (SQLException e) {throw new DALException("Recipe with recipe ID" + recipeID + " Not found"); }
	}

	public List<RecipeDTO> getRecipeList() throws DALException {
		List<RecipeDTO> list = new ArrayList<RecipeDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipe;");
		try
		{
			while (rs.next()) 
			{
				list.add(new RecipeDTO (rs.getInt("recipeID"), rs.getString("recipeName")));
			}
		}
		catch (SQLException e) { throw new DALException("No list found", e); }
		return list;
	}

	public void createRecipe(RecipeDTO recipe) throws DALException {
		try {
		Connector.doUpdate(
				"INSERT INTO recipe(recipeID, recipeName) VALUES " +
				"(" + recipe.getRecipeID() + ", '" + recipe.getRecipeName() + "')"
			);
		} catch(DALException e) {throw new DALException("Recipe Not Created"); }
	}

	public void updateRecipe(RecipeDTO recipe) throws DALException {
		try {
		Connector.doUpdate(
				"UPDATE recipe SET recipeName = '" + recipe.getRecipeName() + "' WHERE recipeID = " +
				recipe.getRecipeID()
		);
		}
		catch (DALException e) {throw new DALException("Recipe with Recipe ID " + recipe.getRecipeID() + " doesn't exist"); }

	}
	
	public void deleteRecipe(int recipeID) throws DALException {
		try {
		Connector.doUpdate(
				"DELETE FROM recipe "
				+ "WHERE recipeID = '" + recipeID + " ';"
				);
		} catch (DALException e) {throw new DALException("Recipe with recipe ID " + recipeID + "Doesn't exist.");}
	}

}

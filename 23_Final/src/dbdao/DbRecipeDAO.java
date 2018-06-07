package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RecipeDTO;

public class DbRecipeDAO {

	public RecipeDTO getRecept(int recipeID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM recept WHERE recept_id = " + recipeID);
	    try {
	    	if (!rs.first()) throw new DALException("Recepten " + recipeID + " findes ikke");
	    	return new RecipeDTO (rs.getInt("recept_id"), rs.getString("recept_navn"));
	    }
	    catch (SQLException e) {throw new DALException("Recipe with recipe ID" + recipeID + " Not found"); }
	}

	public List<RecipeDTO> getReceptList() throws DALException {
		List<RecipeDTO> list = new ArrayList<RecipeDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recept");
		try
		{
			while (rs.next()) 
			{
				list.add(new RecipeDTO (rs.getInt("recept_id"), rs.getString("recept_navn")));
			}
		}
		catch (SQLException e) { throw new DALException("No list found", e); }
		return list;
	}

	public void createRecept(RecipeDTO recipe) throws DALException {
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
	
	public void deleteRecipe(int recipeID) throws DALException {
		try {
		Connector.doUpdate(
				"DELETE FROM recipe "
				+ "WHERE recipeID = " + recipeID
				);
		} catch (DALException e) {throw new DALException("Recipe with recipe ID " + recipeID + "Doesn't exist.");}
	}

}

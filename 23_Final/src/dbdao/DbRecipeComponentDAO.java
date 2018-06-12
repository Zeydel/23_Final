package dbdao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dbdao.Connector;
import dto.DALException;
import dto.RecipeComponentDTO;


public class DbRecipeComponentDAO {

	public RecipeComponentDTO getRecipeComponent(int recipeID, int rawMaterialID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM recipeComponent WHERE recipeID = " + recipeID + " AND rawMaterialID = " + rawMaterialID);
	    try {
	    	if (!rs.first()) throw new DALException("Receptkomponenten " + recipeID + " findes ikke");
	    	return new RecipeComponentDTO(rs.getInt("recipeID"), rs.getInt("rawMaterialID"), rs.getFloat("nom_netto"), rs.getFloat("tolerance"));
	    }
	    catch (SQLException e) {throw new DALException(null, e); }
	}

	public List<RecipeComponentDTO> getRecipeComponentList(int recipeID) throws DALException {
		List<RecipeComponentDTO> list = new ArrayList<RecipeComponentDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipeComponent WHERE recipeID = " + recipeID);
		try
		{
			while (rs.next()) 
			{
				list.add(new RecipeComponentDTO(rs.getInt("recipeID"), rs.getInt("rawMaterialID"), rs.getFloat("nom_netto"), rs.getFloat("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException("Recipe component with ID" + recipeID + " doesn't exist"); }
		return list;
	}


	public List<RecipeComponentDTO> getRecipeComponentList() throws DALException {
		List<RecipeComponentDTO> list = new ArrayList<RecipeComponentDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipeComponent");
		try
		{
			while (rs.next()) 
			{
				list.add(new RecipeComponentDTO(rs.getInt("recipeID"), rs.getInt("rawMaterialID"), rs.getFloat("nom_netto"), rs.getFloat("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException(null, e); }
		return list;
	}


	public void createReceptKomp(RecipeComponentDTO recipeComponent) throws DALException {
		try {
		Connector.doUpdate(
				"INSERT INTO recipeComponent(recipeID, rawMaterialID, nom_netto, tolerance) VALUES " +
				"('" + recipeComponent.getRecipeID() + "', '" + recipeComponent.getRawMaterialID() + "', '" + recipeComponent.getNom_netto() + "', '" + 
				recipeComponent.getTolerance() + "')"
			);
		} catch (DALException e) {throw new DALException("Recipe Component not created");}

	}


	public void updateRecipeComponent(RecipeComponentDTO recipeComponent) throws DALException {
		try{
		Connector.doUpdate(
				"UPDATE recipeComponent SET nom_netto =  '" + recipeComponent.getNom_netto() + 
				"', tolerance = '" + recipeComponent.getTolerance() + "' WHERE recipeID = " +
				recipeComponent.getRecipeID()+ " AND rawMaterialID = " + recipeComponent.getRawMaterialID()
		);
		}catch(DALException e) {throw new DALException ("Recipe component with ID " + recipeComponent.getRecipeID() + " doesn't exist.");}

	}
	
	public void deleteRecipeComponent(int recipeID, int rawMaterialID) throws DALException {
		try {
			Connector.doUpdate(
					"DELETE FROM recipeComponent "
					+ "WHERE recipeID = " + recipeID + " AND rawMaterialID = " + rawMaterialID ); 
		
		} catch (DALException e) {throw new DALException("Recipe component with id " + recipeID + " and rawMaterial ID " + rawMaterialID + " doesn't exist.");}
	}

}

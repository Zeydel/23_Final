package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.ProductBatchDTO;
import rest.ProductBatchComponent;

public class DbProductBatchDAO {

	public ProductBatchDTO getProductBatch(int productBatchID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM productBatch WHERE productBatchID = " + productBatchID);
		try {
			if (!rs.first()) throw new DALException("ProductBatch with ID " + productBatchID + " not found");
			return new ProductBatchDTO (rs.getInt("productBatchID"), getStatus(rs.getString("status")), rs.getInt("recipeID"));
		}
		catch (SQLException e) {throw new DALException("Productbatch with id " + productBatchID + " not found", e); }
	}

	public List<ProductBatchDTO> getProduktBatchList() throws DALException {
		List<ProductBatchDTO> list = new ArrayList<ProductBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM productBatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProductBatchDTO(rs.getInt("productBatchID"), rs.getInt("status"), rs.getInt("recipeID")));
			}
		}
		catch (SQLException e) { throw new DALException("No list found"); }
		return list;
	}

	public void createProductBatch(ProductBatchDTO ProductBatch) throws DALException {
		Connector.doUpdate(
				"INSERT INTO productBatch(productBatchID, status, recipeID) VALUES " +
						"(" + ProductBatch.getProductBatchID() + ", '" + ProductBatch.getStatus() + "', '" + ProductBatch.getRecipeID() +"')"
				);

	}

	public void updateProductBatch(ProductBatchDTO produktbatch) throws DALException {
		try {
			Connector.doUpdate(
					"UPDATE productBatch SET status = " + produktbatch.getStatus() + 
					", recipeID = " + produktbatch.getRecipeID() + " WHERE productBatchID = " + produktbatch.getProductBatchID()
					);
		}catch(DALException e) {throw new DALException("ProductBatch with ID " + produktbatch.getProductBatchID() + "Doesn't exist.");}
	}

	public void deleteProductBatch(int productBatchID) throws DALException{
		try {
			Connector.doUpdate("DELETE FROM productBatch "
					+ "WHERE productBatchID = " + productBatchID);
		} catch(DALException e) {throw new DALException("Product Batch with id " + productBatchID + " doesn't exist.");


		}
	}

	public int getStatus(String str) {
		if(str.equals("created")) {
			return 0;
		} else if (str.equals("under process")){
			return 1;
		} else if (str.equals("completed")) {
			return 2;
		}
		return -1;
	}
}

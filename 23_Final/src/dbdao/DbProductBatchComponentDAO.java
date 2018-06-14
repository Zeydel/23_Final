package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.ProductBatchComponentDTO;

public class DbProductBatchComponentDAO {
	
	public ProductBatchComponentDTO getProductBatchComponent(int productBatchID, int rawMaterialBatchID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM productBatchComponent WHERE productbatchID = " + productBatchID + " AND rawMaterialBatchID = " + rawMaterialBatchID);
	    try {
	    	if (!rs.first()) throw new DALException("productBatchComponent with productBatchID " + productBatchID + " and " + rawMaterialBatchID + " not found");
	    	return new ProductBatchComponentDTO (rs.getInt("productbatchID"), rs.getInt("rawMaterialBatchID"), rs.getFloat("tara"), rs.getFloat("netto"), rs.getInt("userID"));
	    }
	    catch (SQLException e) {throw new DALException(null, e); }
	}

	public List<ProductBatchComponentDTO> getProductBatchKomponentList(int productbatchID) throws DALException {
		List<ProductBatchComponentDTO> list = new ArrayList<ProductBatchComponentDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM productBatchComponent WHERE productbatchID = " + productbatchID);
		try
		{
			while (rs.next()) 
			{
				list.add(new ProductBatchComponentDTO(rs.getInt("productBatchID"), rs.getInt("rawMaterialBatchID"), rs.getFloat("tara"), rs.getFloat("netto"), rs.getInt("userID")));
			}
		}
		catch (SQLException e) { throw new DALException("No list found with ID " + productbatchID); }
		return list;
	}

	public List<ProductBatchComponentDTO> getProductBatchKomponentList() throws DALException {
		List<ProductBatchComponentDTO> list = new ArrayList<ProductBatchComponentDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM productBatchComponent");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProductBatchComponentDTO(rs.getInt("productbatchID"), rs.getInt("rawMaterialBatchID"), rs.getFloat("tara"), rs.getFloat("netto"), rs.getInt("userID")));
			}
		}
		catch (SQLException e) { throw new DALException("No list found"); }
		return list;
	}

	public void createProductBatchComponent(ProductBatchComponentDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate(
				"INSERT INTO ProductBatchComponent(productBatchID, rawMaterialBatchID, tara, netto, userID) VALUES " +
				"('" + produktbatchkomponent.getProductbatchID() + "', '" + produktbatchkomponent.getRawMaterialBatchID() + "', '" + produktbatchkomponent.getTara() + "', '" + 
				produktbatchkomponent.getNetto() + "', '" + produktbatchkomponent.getUserID() + "')"
			);
	}

	public void updateProductBatchComponent(ProductBatchComponentDTO produktbatchkomponent) throws DALException {
		try {
		Connector.doUpdate(
				"UPDATE productBatchComponent SET tara =  '" + produktbatchkomponent.getTara() + 
				"', netto = '" + produktbatchkomponent.getNetto() + "', userID = '" + produktbatchkomponent.getUserID() + "' WHERE productbatchID = " +
				produktbatchkomponent.getProductbatchID() + " AND rawMaterialBatchID = + " + produktbatchkomponent.getRawMaterialBatchID()
		);
		} catch (DALException e) {throw new DALException("produktbatchkomponent with ID " + produktbatchkomponent.getProductbatchID() + "Doesn't exist.");}
		
	}
	
	public void deleteProductBatchComponent(int productBatchID, int rawMaterialBatchID) throws DALException {
		try {
		Connector.doUpdate(
				"DELETE FROM productBatchComponent "
				+ "WHERE productBatchID = " + productBatchID + " AND rawMaterialBatchID = " + rawMaterialBatchID
				);
		} catch (DALException e) {throw new DALException("produktbatchkomponent with ID " + productBatchID + "Doesn't exist.");}
	}
	

	}



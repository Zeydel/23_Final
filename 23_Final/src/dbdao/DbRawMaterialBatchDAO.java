package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RawMaterialBatchDTO;


public class DbRawMaterialBatchDAO {

	public RawMaterialBatchDTO getRawMaterialBatch(int rawMaterialBatchID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE rawMaterialBatchID = " + rawMaterialBatchID);
		try {
			if (!rs.first()) throw new DALException("Rawmaterialbatch with ID" + rawMaterialBatchID + " not found.");
			return new RawMaterialBatchDTO (rs.getInt("rawMaterialBatchID"), rs.getInt("rawMaterialID"), rs.getFloat("amount"));
		}
		catch (SQLException e) {throw new DALException(null, e); }
	}

	public List<RawMaterialBatchDTO> getRawMaterialBatchList() throws DALException {
		List<RawMaterialBatchDTO> list = new ArrayList<RawMaterialBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new RawMaterialBatchDTO(rs.getInt("rawMaterialBatchID"), rs.getInt("rawMaterialID"), rs.getFloat("amount")));
			}
		}
		catch (SQLException e) { throw new DALException(null, e); }
		return list;
	}

	public List<RawMaterialBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		List<RawMaterialBatchDTO> list = new ArrayList<RawMaterialBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE rawMaterialBatchID = " + raavareId);
		try
		{
			while (rs.next()) 
			{
				list.add(new RawMaterialBatchDTO(rs.getInt("rawMaterialBatchID"), rs.getInt("rawMaterialID"), rs.getFloat("amountamount")));
			}
		}
		catch (SQLException e) { throw new DALException(null, e); }
		return list;
	}

	public void createRawMaterialBatch(RawMaterialBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate(
				"INSERT INTO raavarebatch(rawMaterialBatchID, rawMaterialID, maengde) VALUES " +
						"(" + raavarebatch.getRawMaterialBatchID() + ", '" + raavarebatch.getRawMaterialID() + "', '" + raavarebatch.getAmount() +"')"
				);

	}

	public void updateRaavareBatch(RawMaterialBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate(
				"UPDATE raavarebatch SET rawMaterialID = " + raavarebatch.getRawMaterialID() + 
				",maengde = " + raavarebatch.getAmount() + " WHERE rawMaterialBatchID = " + raavarebatch.getRawMaterialBatchID()
				);

	}

	public void deleteRawMaterialBatch(int rawMaterialBatchID) throws DALException {
		try {
			Connector.doUpdate(
					"DELETE FROM rawMaterialBatch"
							+ "WHERE rawMaterialBatchID = " + rawMaterialBatchID
					);
		} catch(DALException e) {throw new DALException("Rawmaterialbatch with ID" + rawMaterialBatchID + " not found.");}

	}
}

package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RawMaterialBatchDTO;


public class DbRawMaterialBatchDAO {

	public RawMaterialBatchDTO getRawMaterialBatch(int rawMaterialBatchID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM rawMaterialBatch WHERE rawMaterialBatchID = " + rawMaterialBatchID);
		try {
			if (!rs.first()) throw new DALException("Rawmaterialbatch with ID" + rawMaterialBatchID + " not found.");
			return new RawMaterialBatchDTO (rs.getInt("rawMaterialBatchID"), rs.getInt("rawMaterialID"), rs.getFloat("amount"));
		}
		catch (SQLException e) {throw new DALException(null, e); }
	}

	public List<RawMaterialBatchDTO> getRawMaterialBatchList() throws DALException {
		List<RawMaterialBatchDTO> list = new ArrayList<RawMaterialBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM rawMaterialBatch");
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
		ResultSet rs = Connector.doQuery("SELECT * FROM rawMaterialBatch WHERE rawMaterialBatchID = " + raavareId);
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

	public void createRawMaterialBatch(RawMaterialBatchDTO rawMaterialBatch) throws DALException {
		Connector.doUpdate(
				"INSERT INTO rawMaterialBatch(rawMaterialBatchID, rawMaterialID, amount) VALUES " +
						"(" + rawMaterialBatch.getRawMaterialBatchID() + ", '" + rawMaterialBatch.getRawMaterialID() + "', '" + rawMaterialBatch.getAmount() +"')"
				);

	}

	public void updateRaavareBatch(RawMaterialBatchDTO rawMaterialBatch) throws DALException {
		Connector.doUpdate(
				"UPDATE rawMaterialBatch SET rawMaterialID = " + rawMaterialBatch.getRawMaterialID() + 
				", amount = " + rawMaterialBatch.getAmount() + " WHERE rawMaterialBatchID = " + rawMaterialBatch.getRawMaterialBatchID()
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

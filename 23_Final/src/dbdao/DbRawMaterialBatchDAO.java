package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RawMaterialBatchDTO;
import dto.RawMaterialBatchViewDTO;


public class DbRawMaterialBatchDAO {
	
	public DbRawMaterialBatchDAO() {
		try {
			Connector Connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Returns raw material batch object where ID parameter matches

	public RawMaterialBatchDTO getRawMaterialBatch(int rawMaterialBatchID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM rawMaterialBatch WHERE rawMaterialBatchID = " + rawMaterialBatchID);
		try {
			if (!rs.first()) throw new DALException("Rawmaterialbatch with ID" + rawMaterialBatchID + " not found.");
			return new RawMaterialBatchDTO (rs.getInt("rawMaterialBatchID"), rs.getInt("rawMaterialID"), rs.getFloat("amount"));
		}
		catch (SQLException e) {throw new DALException(null, e); }
	}
	
	public RawMaterialBatchDTO getRawMaterialBatches(int rawMaterialID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM rawMaterialBatch WHERE rawMaterialBatchID = " + rawMaterialID);
		try {
			if (!rs.first()) throw new DALException("Rawmaterialbatch with ID" + rawMaterialID + " not found.");
			return new RawMaterialBatchDTO (rs.getInt("rawMaterialBatchID"), rs.getInt("rawMaterialID"), rs.getFloat("amount"));
		}
		catch (SQLException e) {throw new DALException(null, e); }
	}
	
	public RawMaterialBatchViewDTO getRawMaterialBatchView(int rawMaterialBatchID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM rawmaterialbatchview WHERE rawMaterialBatchID = " + rawMaterialBatchID);
		try {
			if (!rs.first()) throw new DALException("Rawmaterialbatch with ID" + rawMaterialBatchID + " not found.");
			return new RawMaterialBatchViewDTO (rs.getInt("rawMaterialBatchID"), rs.getInt("rawMaterialID"), rs.getFloat("amount"), rs.getString("rawMaterialName"));
		}
		catch (SQLException e) {throw new DALException(null, e); }
	}

	public List<RawMaterialBatchViewDTO> getRawMaterialBatchList() throws DALException {
		List<RawMaterialBatchViewDTO> list = new ArrayList<RawMaterialBatchViewDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM rawmaterialbatchview");
		try
		{
			while (rs.next()) 
			{
				list.add(new RawMaterialBatchViewDTO(rs.getInt("rawMaterialBatchID"), rs.getInt("rawMaterialID"), rs.getFloat("amount"), rs.getString("rawMaterialName")));
			}
		}
		catch (SQLException e) { throw new DALException(null, e); }
		return list;
	}

	public List<RawMaterialBatchDTO> getRawMaterialBatchList(int RawMaterialBatchID) throws DALException {
		List<RawMaterialBatchDTO> list = new ArrayList<RawMaterialBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM rawMaterialBatch WHERE rawMaterialBatchID = " + RawMaterialBatchID);
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
		Connector.doUpdate("INSERT INTO rawMaterialBatch (rawMaterialBatchID, rawMaterialID, amount) VALUES ('" + rawMaterialBatch.getRawMaterialBatchID() + " ' ,' " + rawMaterialBatch.getRawMaterialID() + " ' ,' " + rawMaterialBatch.getAmount() + "')");
		
	}

	public void updateRawMaterialBatch(RawMaterialBatchDTO rawMaterialBatch) throws DALException {
		Connector.doUpdate(
				"UPDATE rawMaterialBatch SET rawMaterialID = " + rawMaterialBatch.getRawMaterialID() + 
				", amount = " + rawMaterialBatch.getAmount() + " WHERE rawMaterialBatchID = " + rawMaterialBatch.getRawMaterialBatchID()
				);

	}

	public void deleteRawMaterialBatch(int rawMaterialBatchID) throws DALException {
		try {
			Connector.doUpdate(
					"DELETE FROM rawMaterialBatch WHERE rawMaterialBatchID = " + rawMaterialBatchID
					);
		} catch(DALException e) {throw new DALException("Rawmaterialbatch with ID" + rawMaterialBatchID + " not found.");}

	}
	
	
}

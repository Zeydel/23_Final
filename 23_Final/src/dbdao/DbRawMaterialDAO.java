package dbdao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dbdao.Connector;
import dto.DALException;
import dto.RawMaterialDTO;

public class DbRawMaterialDAO {

	public RawMaterialDTO getRawMaterial(int rawMaterialID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM rawMaterial WHERE rawMaterialID = " + rawMaterialID);
		try {
			if(!rs.first()) throw new DALException("The rawmaterial with id " + rawMaterialID + " doesn't exist");
			return new RawMaterialDTO (rs.getInt("rawMaterialID"), rs.getString("rawMaterialName"), rs.getString("supplier"));
		}
		catch (SQLException e) {throw new DALException(null, e);
		}
	}
	
	public List<RawMaterialDTO> getRawMaterialList() throws DALException{
		List<RawMaterialDTO> list = new ArrayList<RawMaterialDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM rawMaterial");
		try {
			while(rs.next()) {
				list.add(new RawMaterialDTO (rs.getInt("rawMaterialID"), rs.getString("rawMaterialName"), rs.getString("supplier")));
			}
		} catch (SQLException e) { throw new DALException("No list found", e); }
		return list;
	}
	
	public void createRawMaterial(RawMaterialDTO rawMaterial) throws DALException {
		try {
			Connector.doUpdate("INSERT INTO rawMaterial(rawMaterialID, rawMaterialName, supplier) VALUES"
					+ "(" + rawMaterial.getRawMaterialID() + ", '" + rawMaterial.getRawMaterialName() + "', '" + rawMaterial.getSupplier() +"')");
		} catch(DALException e) {throw new DALException("Raw material not created");}
	}
	
	
	public void updateRawMaterial(RawMaterialDTO rawMaterial) throws DALException{
		try{
			Connector.doUpdate("UPDATE rawMaterial SET rawMaterialName = '"
		+ rawMaterial.getRawMaterialName() + "', supplier = '" + rawMaterial.getSupplier() + "' WHERE rawMaterialID = " + rawMaterial.getRawMaterialID());
		}
		catch (DALException e) {throw new DALException("Rawmaterial with id " + rawMaterial.getRawMaterialID() + " doesn't exist.");}
	}
	
	public void deleteRawMaterial(int rawMaterialID) throws DALException{
		try{
			Connector.doUpdate(
					"DELETE FROM rawMaterial "
					+ "WHERE rawMaterialID = " + rawMaterialID);
			
		}catch (DALException e) {throw new DALException("Rawmaterial with ID " + rawMaterialID + " doesn't exist");
	}
}
}


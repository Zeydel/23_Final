package dbdao;

import java.sql.SQLException;

import dto.CprDTO;
import dto.DALException;

public class DbCprDAO {
	
	public DbCprDAO() {
		try {
			Connector Connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createCpr(CprDTO Cpr) throws DALException {
		try{
			Connector.doUpdate("INSERT INTO cpr(userID, cpr) VALUES " +
		"(" + Cpr.getUserID() + ", '" + Cpr.getCpr() + "')");
		} catch(DALException e) {throw new DALException("Cpr not created");}
	}
	
	public void updateCpr(CprDTO Cpr) throws DALException {
		try{
			Connector.doUpdate("UPDATE cpr SET cpr = '" + Cpr.getCpr() + "' WHERE userID = " + Cpr.getUserID());
		}catch(DALException e) {throw new DALException("Cpr with User id " + Cpr.getUserID() + " doesn't exist.");}
	}
	
	public void deleteCpr(int userID) throws DALException{
		try {
			Connector.doUpdate("DELETE FROM cpr "
					+ "WHERE userID = " + userID);
		} catch (DALException e) {throw new DALException("Cpr with user id " + userID + " doesn't exist.");}
	}

}

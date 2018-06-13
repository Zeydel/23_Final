package dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dto.DALException;
import dto.UserViewDTO;

public class DbUserViewDAO {

	public DbUserViewDAO() {
		try {
			Connector Connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserViewDTO getUser(int userID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM userview WHERE userID = " + userID);
		try {
			if (!rs.first()) throw new DALException("The user with ID " + userID + " could not be found");
			return new UserViewDTO (rs.getInt("userID"), rs.getString("userName"), rs.getString("initials"), rs.getString("password"), rs.getInt("cpr"), stringToList(rs.getString("roles")) );
		}
		catch (SQLException e) {throw new DALException("Recipe with recipe ID" + userID + " Not found"); }
	}

	public List<UserViewDTO> getUserList() throws DALException {
		List<UserViewDTO> list = new ArrayList<UserViewDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM userview;");
		try
		{
			while (rs.next()) 
			{
				list.add(new UserViewDTO (rs.getInt("userID"), rs.getString("userName"), rs.getString("initials"), rs.getString("password"), rs.getInt("cpr"), stringToList(rs.getString("roles"))));
			}
		}
		catch (SQLException e) { throw new DALException("No list found", e); }
		return list;
	}

	public ArrayList<String> stringToList(String string){
		ArrayList<String> roles = new ArrayList<String>(Arrays.asList(string.split(",")));
		return roles;
	}
}


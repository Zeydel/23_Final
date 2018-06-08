package dbdao;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import dto.DALException;
	import dto.ProductBatchDTO;
import dto.ProductBatchViewDTO;
import rest.ProductBatchComponent;
public class DbProductBatchViewDAO {

	public ProductBatchViewDTO getProductBatchView(int productBatchID) throws DALException {
			ResultSet rs = Connector.doQuery("SELECT * FROM productBatchView WHERE productBatchID = " + productBatchID);
			try {
				if (!rs.first()) throw new DALException("ProductBatchView with ID " + productBatchID + " not found");
				return new ProductBatchViewDTO (rs.getInt("productBatchID"), rs.getInt("status"), rs.getInt("recipeID"), rs.getString("recipeName"));
			}
			catch (SQLException e) {throw new DALException(null, e); }
		}

		public List<ProductBatchViewDTO> getProductBatchViewList() throws DALException {
			List<ProductBatchViewDTO> list = new ArrayList<ProductBatchViewDTO>();
			ResultSet rs = Connector.doQuery("SELECT * FROM productbatchview");
			try
			{
				while (rs.next()) 
				{
					list.add(new ProductBatchViewDTO(rs.getInt("productBatchID"), rs.getString("status"), rs.getInt("recipeID"), rs.getString("recipeName")));
				}
			}
			catch (SQLException e) { throw new DALException("No list found"); }
			return list;
		}


}

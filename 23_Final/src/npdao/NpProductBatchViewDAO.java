package npdao;

import java.util.ArrayList;
import java.util.List;
import dto.ProductBatchComponentDTO;
import dto.ProductBatchDTO;
import dto.ProductBatchViewDTO;

public class NpProductBatchViewDAO {
	
	ArrayList<ProductBatchViewDTO> ProductBatchViews = new ArrayList<ProductBatchViewDTO>();
	
	public NpProductBatchViewDAO() {
		ProductBatchViews.add(new ProductBatchViewDTO(1, 1, 1, "Torben"));
	}

	public ProductBatchViewDTO getProductBatchView(int productBatchID) throws DALException {
		for(ProductBatchViewDTO productBatchView : ProductBatchViews) {
			if(productBatchView.getProductBatchID()==productBatchID) {
				return productBatchView;
			}
		} throw new DALException("Product batch with ID " + productBatchID + " doesn't exist.");
	}
	
	public List<ProductBatchViewDTO> getProductBatchViewList(){
		return ProductBatchViews;
	}
	
	public void createProductBatchView(ProductBatchViewDTO productBatchView) {
		ProductBatchViews.add(productBatchView);
	}
	
	public void updateProductBatchView(ProductBatchViewDTO productBatchView) throws DALException {
		for(int i = 0; i < ProductBatchViews.size(); i++) {
			if(ProductBatchViews.get(i).getProductBatchID()==productBatchView.getProductBatchID()) {
				ProductBatchViews.set(i, productBatchView);
				return;
			}
		} throw new DALException("Productbatch with ID " + productBatchView.getProductBatchID() + " doesn't exist");
	}
	
	public void deleteProductBatchView(int productBatchID) throws DALException{
		for(int i = 0; i<ProductBatchViews.size(); i++) {
			if(ProductBatchViews.get(i).getProductBatchID() == productBatchID) {
				ProductBatchViews.remove(i);
				return;
			}
		} throw new DALException("Productbatch with ID " + productBatchID + " doesn't exist.");
	}
}

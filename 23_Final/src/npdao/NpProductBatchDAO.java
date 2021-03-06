/*package npdao;

import java.util.ArrayList;

import java.util.List;

import dto.DALException;
import dto.ProductBatchComponentDTO;
import dto.ProductBatchDTO;

public class NpProductBatchDAO {

	ArrayList<ProductBatchDTO> ProductBatches = new ArrayList<ProductBatchDTO>();
	public NpProductBatchDAO(){
		ProductBatches.add(new ProductBatchDTO(1, 2, 1));
		ProductBatches.add(new ProductBatchDTO(2, 2, 1));
		ProductBatches.add(new ProductBatchDTO(4, 1, 3));
	}
	
	public ProductBatchDTO getProductBatch(int productBatchID) throws DALException {
		for(ProductBatchDTO productBatch : ProductBatches) {
			if(productBatch.getProductBatchID() == productBatchID) {
				return productBatch;
			}
		} throw new DALException("Productbatch with ID" + productBatchID + " not found.");
	}
	

	public List<ProductBatchDTO> getProductBatchList(){
		return ProductBatches;
	}
	
	public void createProductBatch(ProductBatchDTO productBatch) {
		ProductBatches.add(productBatch);
	}
	
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException {
		for(int i = 0; i < ProductBatches.size(); i++) {
			if(ProductBatches.get(i).getProductBatchID() == productBatch.getProductBatchID()) {
				ProductBatches.set(i, productBatch);
				return;
			}
		} throw new DALException("Productbatch with ID" + productBatch.getProductBatchID() + " not found.");
	}
	
	public void deleteProductBatch(int productBatchID) throws DALException {
		for(int i = 0; i < ProductBatches.size(); i++) {
			if(ProductBatches.get(i).getProductBatchID() == productBatchID) {
				ProductBatches.remove(i);
				return;
			}
		} throw new DALException("Productbatch with ID" + productBatchID + " not found.");
	}
}
*/
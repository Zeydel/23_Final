package dao;

import java.util.ArrayList;

import dto.ProductBatchDTO;

public class NpProductBatchDAO {

	ArrayList<ProductBatchDTO> ProductBatches;
	public NpProductBatchDAO(){
		ProductBatches.add(new ProductBatchDTO(1, 2, 1));
		ProductBatches.add(new ProductBatchDTO(2, 2, 1));
		ProductBatches.add(new ProductBatchDTO(4, 1, 3));
	}
	
	public ProductBatchDTO getProductBatch(int productBatchID) {
		for(ProductBatchDTO productBatch : ProductBatches) {
			if(productBatch.getProductBatchID() == productBatchID) {
				return productBatch;
			}
		} throw new DALException("Productbatch with ID" + productBatchID + " not found.");
	}
	
	get
	
	getList
	
	create
	
	update
	
	delete
}

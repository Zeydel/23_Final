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
}

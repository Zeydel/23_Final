package dao;

import java.util.ArrayList;

import dto.ProductBatchComponentDTO;

public class NpProductBatchComponentDAO {
	
	ArrayList<ProductBatchComponentDTO> productBatchComponents;
	public NpProductBatchComponentDAO() {
		productBatchComponents.add(new ProductBatchComponentDTO(1, 1, 0.5f, 10.05f, 1));
		productBatchComponents.add(new ProductBatchComponentDTO(2, 1, 0.5f, 10.01f, 2));
		productBatchComponents.add(new ProductBatchComponentDTO(4, 7, 0.5f, 0.99f, 3));
	}

}

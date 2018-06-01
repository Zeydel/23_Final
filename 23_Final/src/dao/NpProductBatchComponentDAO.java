package dao;

import java.util.ArrayList;
import java.util.List;

import dto.ProductBatchComponentDTO;
import dto.UserDTO;

public class NpProductBatchComponentDAO {

	ArrayList<ProductBatchComponentDTO> productBatchComponents;
	public NpProductBatchComponentDAO() {
		productBatchComponents.add(new ProductBatchComponentDTO(1, 1, 0.5f, 10.05f, 1));
		productBatchComponents.add(new ProductBatchComponentDTO(2, 1, 0.5f, 10.01f, 2));
		productBatchComponents.add(new ProductBatchComponentDTO(4, 7, 0.5f, 0.99f, 3));
	}

	public ProductBatchComponentDTO getProductBatchComponent(int produktBatchID, int rawMaterialID) throws DALException {
		for(ProductBatchComponentDTO productBatchComponent : productBatchComponents) {
			if(productBatchComponent.getProductbatchID() == produktBatchID && productBatchComponent.getRawMaterialID() == rawMaterialID) {
				return productBatchComponent;
			}
		} throw new DALException("ProductBatchComponent with productBatchID " + produktBatchID + " and " + rawMaterialID + " not found");
	}

	public List<ProductBatchComponentDTO> getProductBatchKomponentList(){
		return productBatchComponents;
	}

	public void createProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException {
		productBatchComponents.add(productBatchComponent);
	}

	public void updateProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException {
		for(int i = 0; i < productBatchComponents.size(); i++) {
			if(productBatchComponents.get(i).getProductbatchID() == productBatchComponent.getProductbatchID() && productBatchComponents.get(i).getRawMaterialID() == productBatchComponent.getRawMaterialID()) {
				productBatchComponents.set(i, productBatchComponent);
			}
		} throw new DALException("ProductBatchComponent with productBatchID " + productBatchComponent.getProductbatchID() + " and " + productBatchComponent.getRawMaterialID() + " not found");
	}

	public void deleteProductBatchComponent(int produktBatchID, int rawMaterialID) throws DALException {
		for(int i = 0; i < productBatchComponents.size(); i++) {
			if(productBatchComponents.get(i).getProductbatchID() == produktBatchID && productBatchComponents.get(i).getRawMaterialID() == rawMaterialID) {
				productBatchComponents.remove(i);
			}
		} throw new DALException("ProductBatchComponent with productBatchID " + produktBatchID + " and " + rawMaterialID + " not found");
	}
}

package dao;

public class NpStorage {
	
	NpProductBatchComponentDAO ProductBatchComponent;
	NpProductBatchDAO ProductBatch;
	NpRawMaterialBatchDAO RawMaterialBatch;
	NpRawMaterialDAO RawMaterial;
	NpRecipeDAO Recipe;
	NpUserDAO User;
	NpProductBatchViewDAO ProductBatchView;
	public NpStorage() {
		this.ProductBatchComponent  = new NpProductBatchComponentDAO();
		this.ProductBatch = new NpProductBatchDAO();
		this.RawMaterialBatch = new NpRawMaterialBatchDAO();
		this.RawMaterial = new NpRawMaterialDAO();
		this.Recipe = new NpRecipeDAO();
		this.User = new NpUserDAO();
		this.ProductBatchView = new NpProductBatchViewDAO();
	}
	public NpProductBatchComponentDAO getProductBatchComponent() {
		return ProductBatchComponent;
	}
	public void setProductBatchComponent(NpProductBatchComponentDAO productBatchComponent) {
		ProductBatchComponent = productBatchComponent;
	}
	public NpProductBatchDAO getProductBatch() {
		return ProductBatch;
	}
	public void setProductBatch(NpProductBatchDAO productBatch) {
		ProductBatch = productBatch;
	}
	public NpRawMaterialBatchDAO getRawMaterialBatch() {
		return RawMaterialBatch;
	}
	public void setRawMaterialBatch(NpRawMaterialBatchDAO rawMaterialBatch) {
		RawMaterialBatch = rawMaterialBatch;
	}
	public NpRawMaterialDAO getRawMaterial() {
		return RawMaterial;
	}
	public void setRawMaterial(NpRawMaterialDAO rawMaterial) {
		RawMaterial = rawMaterial;
	}
	public NpRecipeDAO getRecipe() {
		return Recipe;
	}
	public void setRecipe(NpRecipeDAO recipe) {
		Recipe = recipe;
	}
	public NpUserDAO getUser() {
		return User;
	}
	public void setUser(NpUserDAO user) {
		User = user;
	}
	public NpProductBatchViewDAO getProductBatchView() {
		return ProductBatchView;
	}
	public void setProductBatchView(NpProductBatchViewDAO productBatchView) {
		ProductBatchView = productBatchView;
	}

}

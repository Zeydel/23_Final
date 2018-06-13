
package npdao;

public class NpStorage {
	
	NpProductBatchComponentDAO ProductBatchComponent;
	NpProductBatchDAO ProductBatch;
	NpRawMaterialBatchDAO RawMaterialBatch;
	NpRawMaterialDAO RawMaterial;
	NpRecipeDAO Recipe;
	NpUserDAO User;
	NpCprDAO Cpr;
	NpProductBatchViewDAO ProductBatchView;
	NpRawMaterialBatchViewDAO RawMaterialBatchView;
	public NpStorage() {
		this.ProductBatchComponent  = new NpProductBatchComponentDAO();
		this.ProductBatch = new NpProductBatchDAO();
		this.RawMaterialBatch = new NpRawMaterialBatchDAO();
		this.RawMaterial = new NpRawMaterialDAO();
		this.Recipe = new NpRecipeDAO();
		this.User = new NpUserDAO();
		this.ProductBatchView = new NpProductBatchViewDAO();
		this.RawMaterialBatchView = new NpRawMaterialBatchViewDAO();
		this.Cpr = new NpCprDAO();
	}
	public NpRawMaterialBatchViewDAO getRawMaterialBatchView() {
		return RawMaterialBatchView;
	}
	public void setRawMaterialBatchView(NpRawMaterialBatchViewDAO rawMaterialBatchView) {
		RawMaterialBatchView = rawMaterialBatchView;
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
	public NpCprDAO getCpr() {
		return Cpr;
	}
	public void setCpr(NpCprDAO cpr) {
		Cpr = cpr;
	}
	
	

}


package dto;

public class ProductBatchViewDTO {
	private int productBatchID;
	private String status;
	private int recipeID;
	private String recipeName;
	
	//Contains information about a productbatch along with the recipe name of the productbatch
	public ProductBatchViewDTO(int productBatchID, String status, int recipeID, String recipeName) {
		this.productBatchID = productBatchID;
		this.status = status;
		this.recipeID = recipeID;
		this.recipeName = recipeName;
	}

	public int getProductBatchID() {
		return productBatchID;
	}

	public void setProductBatchID(int productBatchID) {
		this.productBatchID = productBatchID;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	

}

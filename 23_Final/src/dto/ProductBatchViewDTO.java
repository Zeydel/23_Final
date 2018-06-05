package dto;

public class ProductBatchViewDTO {
	private int productBatchID;
	private int status;
	private int recipeID;
	private String recipeName;
	
	public ProductBatchViewDTO(int productBatchID, int status, int recipeID, String recipeName) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

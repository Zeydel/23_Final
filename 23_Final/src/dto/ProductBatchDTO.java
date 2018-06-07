package dto;

public class ProductBatchDTO {
	
	private int productBatchID;
	private int status;
	private int recipeID;
	
	public ProductBatchDTO(int productBatchID, int status, int recipeID) {
		this.productBatchID = productBatchID;
		this.status = status;
		this.recipeID = recipeID;
	}

	//Empty constructor for JSON
	public ProductBatchDTO() {
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

	
	
}

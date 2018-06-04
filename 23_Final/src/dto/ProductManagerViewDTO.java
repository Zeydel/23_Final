package dto;

public class ProductManagerViewDTO {
	private int status;
	private int recipeID;
	private int amount;
	private int rawMaterialID;
	
	// Empty constructor for JSON
	public ProductManagerViewDTO() {
		
	}
	
	
	public ProductManagerViewDTO(int status, int recipeID, int amount, int rawMaterialID) {
		this.setStatus(status);
		this.setRecipeID(recipeID);
		this.setAmount(amount);
		this.setRawMaterialID(rawMaterialID);
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


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getRawMaterialID() {
		return rawMaterialID;
	}


	public void setRawMaterialID(int rawMaterialID) {
		this.rawMaterialID = rawMaterialID;
	}
	
}

package dto;

public class ProductBatchViewDTO {
	private int productBatchID;
	private int status;
	private int receptID;
	private String recipeName;
	
	public ProductBatchViewDTO(int productBatchID, int status, int receptID, String recipeName) {
		this.productBatchID = productBatchID;
		this.status = status;
		this.receptID = receptID;
		this.recipeName = recipeName;
	}
	
	public ProductBatchViewDTO() {
	
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

	public int getReceptID() {
		return receptID;
	}

	public void setReceptID(int receptID) {
		this.receptID = receptID;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	

}

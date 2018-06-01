package dto;

public class ProductBatchDTO {
	
	private int productBatchID;
	private int status;
	private int receptID;
	
	public ProductBatchDTO(int productBatchID, int status, int receptID) {
		this.productBatchID = productBatchID;
		this.status = status;
		this.receptID = receptID;
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

	public int getReceptID() {
		return receptID;
	}

	public void setReceptID(int receptID) {
		this.receptID = receptID;
	}
	
}

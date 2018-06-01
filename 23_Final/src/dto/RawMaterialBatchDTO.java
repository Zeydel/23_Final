package dto;

public class RawMaterialBatchDTO {
	
	private int rawMaterialBatchID;
	private int rawMaterialID;
	private float amount;
	
	public RawMaterialBatchDTO(int rawMaterialBatchID, int rawMaterialID, float amount) {
		this.rawMaterialBatchID = rawMaterialBatchID;
		this.rawMaterialID = rawMaterialID;
		this.amount = amount;
	}
	
	//Empty constructor for JSON
	public RawMaterialBatchDTO() {
	}

	public int getRawMaterialBatchID() {
		return rawMaterialBatchID;
	}

	public void setRawMaterialBatchID(int rawMaterialBatchID) {
		this.rawMaterialBatchID = rawMaterialBatchID;
	}

	public int getRawMaterialID() {
		return rawMaterialID;
	}

	public void setRawMaterialID(int rawMaterialID) {
		this.rawMaterialID = rawMaterialID;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}

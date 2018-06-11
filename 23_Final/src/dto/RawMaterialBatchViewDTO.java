package dto;

public class RawMaterialBatchViewDTO {
	private int rawMaterialBatchID;
	private int rawMaterialID;
	private float amount;
	private String rawMaterialName;
	
	public RawMaterialBatchViewDTO(int rawMaterialBatchID, int rawMaterialID, float amount, String rawMaterialName) {
		this.rawMaterialBatchID = rawMaterialBatchID;
		this.rawMaterialID = rawMaterialID;
		this.amount = amount;
		this.rawMaterialName = rawMaterialName;
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

	public String getRawMaterialName() {
		return rawMaterialName;
	}

	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


}

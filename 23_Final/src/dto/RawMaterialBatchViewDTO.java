package dto;

public class RawMaterialBatchViewDTO {
	private int rawMaterialBatchID;
	private int rawMaterialID;
	private String rawMaterialName;
	private int amount;
	private String supplier;
	
	public RawMaterialBatchViewDTO(int rawMaterialBatchID, int rawMaterialID, String rawMaterialName, int amount, String supplier) {
		this.rawMaterialBatchID = rawMaterialBatchID;
		this.rawMaterialID = rawMaterialID;
		this.rawMaterialName = rawMaterialName;
		this.amount = amount;
		this.supplier = supplier;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}

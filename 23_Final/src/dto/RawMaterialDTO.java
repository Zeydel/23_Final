package dto;

public class RawMaterialDTO {
	
	private int rawMaterialID;
	private String rawMaterialName;
	private String supplier;

	//Contains information about a rawmaterial
	public RawMaterialDTO(int rawMaterialID, String rawMaterialName, String supplier) {
		this.rawMaterialID = rawMaterialID;
		this.rawMaterialName = rawMaterialName;
		this.supplier = supplier;
	}
	
	//Empty constructor for JSON
	public RawMaterialDTO() {
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
}

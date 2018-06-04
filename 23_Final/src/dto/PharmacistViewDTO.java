package dto;

public class PharmacistViewDTO {

	private int rawMaterialID;
	private String rawMaterialName;
	private int amount;
	private String recipeName;
	
	public PharmacistViewDTO(int rawMaterialID, String rawMaterialName, int amount, String recipeName) {
		this.setRawMaterialID(rawMaterialID);
		this.setRawMaterialName(rawMaterialName);
		this.setAmount(amount);
	}
	
	//Empty constructor for JSON
	public PharmacistViewDTO() {
	}

	public int getRawMaterialID() {
		return rawMaterialID;
	}

	public void setRawMaterialID(int rawMaterialId) {
		this.rawMaterialID = rawMaterialId;
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

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	
	
}

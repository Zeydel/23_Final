package dto;

public class ProductBatchComponentDTO {
	
	private int productbatchID;
	private int rawMaterialID;
	private float tara;
	private float netto;
	private int userID;
	
	public ProductBatchComponentDTO(int productbatchID, int rawMaterialID, float tara, float netto, int userID) {
		this.productbatchID = productbatchID;
		this.rawMaterialID = rawMaterialID;
		this.tara = tara;
		this.netto = netto;
		this.userID = userID;
	}

	//Empty constructor for JSON
	public ProductBatchComponentDTO() {
	}

	public int getProductbatchID() {
		return productbatchID;
	}

	public void setProductbatchID(int productbatchID) {
		this.productbatchID = productbatchID;
	}

	public int getRawMaterialID() {
		return rawMaterialID;
	}

	public void setRawMaterialID(int rawMaterialID) {
		this.rawMaterialID = rawMaterialID;
	}

	public float getTara() {
		return tara;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public float getNetto() {
		return netto;
	}

	public void setNetto(float netto) {
		this.netto = netto;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}

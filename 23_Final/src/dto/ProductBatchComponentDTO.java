package dto;

//Contains part of a productbatch. Each individual part of a productbatch is stored along with the user responsible
public class ProductBatchComponentDTO {
	
	private int productbatchID;
	private int rawMaterialBatchID;
	private float tara;
	private float netto;
	private int userID;
	
	public ProductBatchComponentDTO(int productbatchID, int rawMaterialBatchID, float tara, float netto, int userID) {
		this.productbatchID = productbatchID;
		this.rawMaterialBatchID = rawMaterialBatchID;
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

	public int getRawMaterialBatchID() {
		return rawMaterialBatchID;
	}

	public void setRawMaterialBatchID(int rawMaterialBatchID) {
		this.rawMaterialBatchID = rawMaterialBatchID;
	}
	

}

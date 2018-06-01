package dal;

public class ProductBatchComponentDTO {
	
	private int productbatchID;
	private int rawMaterialID;
	private int tara;
	private int netto;
	private int userID;
	
	public ProductBatchComponentDTO(int productbatchID, int rawMaterialID, int tara, int netto, int userID) {
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

	public int getTara() {
		return tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

	public int getNetto() {
		return netto;
	}

	public void setNetto(int netto) {
		this.netto = netto;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}

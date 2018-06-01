package dto;

public class RecipeComponentDTO {
	
	private int recipeID;
	private int rawMaterialID;
	private float nom_netto;
	private float tolerance;
	
	public RecipeComponentDTO(int recipeID, int rawMaterialID, float nom_netto, float tolerance) {
		this.recipeID = recipeID;
		this.rawMaterialID = rawMaterialID;
		this.nom_netto = nom_netto;
		this.tolerance = tolerance;
	}

	//Empty constructor for JSON
	public RecipeComponentDTO() {
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public int getRawMaterialID() {
		return rawMaterialID;
	}

	public void setRawMaterialID(int rawMaterialID) {
		this.rawMaterialID = rawMaterialID;
	}

	public float getNom_netto() {
		return nom_netto;
	}

	public void setNom_netto(float nom_netto) {
		this.nom_netto = nom_netto;
	}

	public float getTolerance() {
		return tolerance;
	}

	public void setTolerance(float tolerance) {
		this.tolerance = tolerance;
	}

}

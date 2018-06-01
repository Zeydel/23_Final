package dal;

public class RecipeComponent {
	
	private int recipeID;
	private int rawMaterialID;
	private float nom_netto;
	private float tolerance;
	
	public RecipeComponent(int recipeID, int rawMaterialID, float nom_netto, float tolerance) {
		this.recipeID = recipeID;
		this.rawMaterialID = rawMaterialID;
		this.nom_netto = nom_netto;
		this.tolerance = tolerance;
	}

	public RecipeComponent() {
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

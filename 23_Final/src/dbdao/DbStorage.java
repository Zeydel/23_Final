package dbdao;

public class DbStorage {
	
	DbRecipeDAO Recipe = new DbRecipeDAO();

	public DbStorage() {
		Recipe = new DbRecipeDAO();
	}

	public DbRecipeDAO getRecipe() {
		return Recipe;
	}

	public void setRecipe(DbRecipeDAO recipe) {
		Recipe = recipe;
	}

}

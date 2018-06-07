package dbdao;

public class DbStorage {
	
	DbRecipeDAO Recipe;
	DbUserViewDAO User;

	public DbStorage() {
		Recipe = new DbRecipeDAO();
		User = new DbUserViewDAO();
	}

	public DbRecipeDAO getRecipe() {
		return Recipe;
	}

	public void setRecipe(DbRecipeDAO recipe) {
		Recipe = recipe;
	}

	public DbUserViewDAO getUser() {
		return User;
	}

	public void setUser(DbUserViewDAO user) {
		User = user;
	}
	
	

}


package dbdao;

public class DbStorage {
	
	DbRecipeDAO Recipe;
	DbUserDAO User;
	DbUserViewDAO UserView;
	DbRoleDAO Role;
	DbCprDAO Cpr;
	DbProductBatchDAO ProductBatch;
	DbProductBatchViewDAO ProductBatchView;
	DbRawMaterialDAO RawMaterial;



	public DbStorage() {
		Recipe = new DbRecipeDAO();
		UserView = new DbUserViewDAO();
		User = new DbUserDAO();
		Role = new DbRoleDAO();
		Cpr = new DbCprDAO();
		ProductBatch = new DbProductBatchDAO();
		ProductBatchView = new DbProductBatchViewDAO();
		RawMaterial = new DbRawMaterialDAO();
		
	}

	public DbRecipeDAO getRecipe() {
		return Recipe;
	}

	public void setRecipe(DbRecipeDAO recipe) {
		Recipe = recipe;
	}

	public DbUserDAO getUser() {
		return User;
	}

	public void setUser(DbUserDAO user) {
		User = user;
	}

	public DbUserViewDAO getUserView() {
		return UserView;
	}

	public void setUserView(DbUserViewDAO userView) {
		UserView = userView;
	}

	public DbRoleDAO getRole() {
		return Role;
	}

	public void setRole(DbRoleDAO role) {
		Role = role;
	}

	public DbCprDAO getCpr() {
		return Cpr;
	}

	public void setCpr(DbCprDAO cpr) {
		Cpr = cpr;
	}

	public DbProductBatchDAO getProductBatch() {
		return ProductBatch;
	}

	public void setProductBatch(DbProductBatchDAO productBatch) {
		ProductBatch = productBatch;
	}

	public DbProductBatchViewDAO getProductBatchView() {
		return ProductBatchView;
	}

	public void setProductBatchView(DbProductBatchViewDAO productBatchView) {
		ProductBatchView = productBatchView;
	}
	

	public DbRawMaterialDAO getRawMaterial() {
		return RawMaterial;
	}
	
	public void setRawMaterial(DbRawMaterialDAO rawMaterial) {
		RawMaterial = rawMaterial;
	}
	
}


package ase;

import java.io.IOException;
import java.util.List;

import dbdao.DbStorage;
import dto.DALException;
import dto.ProductBatchComponentDTO;
import dto.ProductBatchDTO;
import dto.RawMaterialBatchDTO;
import dto.RawMaterialDTO;
import dto.RecipeComponentDTO;
import dto.RecipeDTO;
import dto.UserViewDTO;

public class WeightController {

	public static void main(String[] args) {
		WeightFunction Weight = new WeightFunction();
		DbStorage Storage = new DbStorage();
		UserViewDTO user = null;

		try {
			String usrID = Weight.getStringFromDisplay("Enter user ID");
			while(user == null) {
				try {
					user = Storage.getUserView().getUser(Integer.parseInt(usrID.replaceAll("[\\D]", "")));
				} catch (NumberFormatException e) {
					usrID = Weight.getStringFromDisplay("Please enter a number");
				} catch (DALException e) {
					usrID = Weight.getStringFromDisplay("User not found. Try again");
				}
			}
			Weight.getStringFromDisplay("Welcome " + user.getUserName());
			String pbID = Weight.getStringFromDisplay("Enter ProductBatch ID");
			System.out.println(pbID);
			ProductBatchDTO ProductBatch = null;
			while(ProductBatch == null) {
				try {
					ProductBatch = Storage.getProductBatch().getProductBatch(Integer.parseInt(pbID.replaceAll("[\\D]", "")));
				} catch (NumberFormatException e) {
					pbID = Weight.getStringFromDisplay("Please enter a number");
				} catch (DALException e) {
					pbID = Weight.getStringFromDisplay("User not found. Try again");
				}
			}
			RecipeDTO recipe = null;
			//Weight.writeLongStringInDisplay("DOING THINGS");
			try {
				recipe = Storage.getRecipe().getRecipe(ProductBatch.getRecipeID());
			} catch (DALException e) {
				Weight.writeInDisplay("NO RECIPE", 10);				
			}
			//Weight.clearInputStream();
			Weight.writeLongStringInDisplay("Please clear weight");
			Weight.waitForInput();
			Weight.writeLongStringInDisplay("Current Recipe: " + recipe.getRecipeName());
			Weight.WeightTare();
			ProductBatch.setStatus(2);
			try {
				Storage.getProductBatch().updateProductBatch(ProductBatch);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<RecipeComponentDTO> recipeComponents = null;
			List<ProductBatchComponentDTO> productBatchComponents = null;
			try {
				recipeComponents = Storage.getRecipeComponent().getRecipeComponentList(recipe.getRecipeID());
				productBatchComponents = Storage.getProductBatchComponent().getProductBatchKomponentList(ProductBatch.getProductBatchID());
			} catch (DALException e) {
				// TODO Auto-generated caftch block
				e.printStackTrace();
			}

			int remainingComponents;
			RawMaterialBatchDTO RawMaterialBatch = null;
			RawMaterialDTO RawMaterial = null;

			if(productBatchComponents != null) {
				for(int i = 0; i < productBatchComponents.size(); i++) {
					try {
						RawMaterialBatch = Storage.getRawMaterialBatch().getRawMaterialBatch(productBatchComponents.get(i).getRawMaterialBatchID());
						RawMaterial = Storage.getRawMaterial().getRawMaterial(RawMaterialBatch.getRawMaterialID());
					} catch (DALException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(int j = 0; j < recipeComponents.size(); j++) {
						if(RawMaterial.getRawMaterialID() == recipeComponents.get(j).getRawMaterialID()) {
							recipeComponents.remove(j);
							break;
						}
					}
				}
			}

			for(int i = 0; i < recipeComponents.size(); i++) {
				Weight.getStringFromDisplay("Place");
				int tare = Weight.WeightTare();

				String rbID = Weight.getStringFromDisplay("Enter rbid");
				RawMaterialBatch = null;
				RawMaterial = null;

				while(true) {
					while(RawMaterialBatch == null) {
						try {
							RawMaterialBatch = Storage.getRawMaterialBatch().getRawMaterialBatch(Integer.parseInt(rbID.replaceAll("[\\D]", "")));
							RawMaterial = Storage.getRawMaterial().getRawMaterial(RawMaterialBatch.getRawMaterialID());
						} catch (NumberFormatException e) {
							rbID = Weight.getStringFromDisplay("Please enter a number");
						} catch (DALException e) {
							rbID = Weight.getStringFromDisplay("Batch not found. Try again");
						}
					}
					int cur = 0;
					for(int j = 0; j < recipeComponents.size(); j++) {
						if(recipeComponents.get(i).getRawMaterialID() == RawMaterial.getRawMaterialID()) {
							Weight.writeLongStringInDisplay("Weighing " + RawMaterial.getRawMaterialName());
							cur = j;
							break;
						}
					}
					
					Weight.waitForInput();
					float weight = Weight.getWeight()/1000;
					float tara = tare/1000;
					
					float tolareance = recipeComponents.get(cur).getTolerance();
					float desiredWeight = recipeComponents.get(cur).getNom_netto();
					
					float min = desiredWeight - (tolareance * desiredWeight);
					float max = desiredWeight + (tolareance * desiredWeight);
					
					if(desiredWeight > min && desiredWeight < max) {
						ProductBatchComponentDTO ProductBatchComponent = new ProductBatchComponentDTO(ProductBatch.getProductBatchID(), RawMaterialBatch.getRawMaterialBatchID(), tara, weight, user.getUserID());
						try {
							Storage.getProductBatchComponent().createProductBatchComponent(ProductBatchComponent);
						} catch (DALException e) {
							Weight.writeLongStringInDisplay("An error happened");
						}
					} else {
						Weight.writeLongStringInDisplay("Weight outside of tolerance. Try again");
						i--;
					}
				}

			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

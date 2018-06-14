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
			while(user == null) {
				try {
					String usrID = Weight.getStringFromDisplay("Enter user ID");
					user = Storage.getUserView().getUser(Integer.parseInt(usrID.replaceAll("[\\D]", "")));
				} catch (NumberFormatException e) {
					Weight.writeLongStringInDisplay("Please enter a number");
					Weight.waitForInput();
				} catch (DALException e) {
					Weight.writeLongStringInDisplay("User not found. Try again");
					Weight.waitForInput();
				}
			}
			Weight.getStringFromDisplay("Welcome " + user.getUserName());
			ProductBatchDTO ProductBatch = null;
			while(ProductBatch == null) {
				try {
					String pbID = Weight.getStringFromDisplay("Enter ProductBatch ID");
					ProductBatch = Storage.getProductBatch().getProductBatch(Integer.parseInt(pbID.replaceAll("[\\D]", "")));
				} catch (NumberFormatException e) {
					Weight.writeLongStringInDisplay("Please enter a number");
					Weight.waitForInput();
				} catch (DALException e) {
					Weight.writeLongStringInDisplay("Batch not found. Try again");
					Weight.waitForInput();
				}
			}
			RecipeDTO recipe = null;
			try {
				recipe = Storage.getRecipe().getRecipe(ProductBatch.getRecipeID());
			} catch (DALException e) {
				Weight.writeInDisplay("NO RECIPE", 10);				
			}
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

			int cur = -1;
			while(recipeComponents.size() != 0) {
				Weight.writeLongStringInDisplay("Place empty container");
				Weight.waitForInput();
				int tare = Weight.WeightTare();

				RawMaterialBatch = null;
				RawMaterial = null;

				while(cur == -1) {
					while(RawMaterial == null) {
						try {
							String rbID = Weight.getStringFromDisplay("Enter rbid");
							RawMaterialBatch = Storage.getRawMaterialBatch().getRawMaterialBatch(Integer.parseInt(rbID.replaceAll("[\\D]", "")));
							RawMaterial = Storage.getRawMaterial().getRawMaterial(RawMaterialBatch.getRawMaterialID());
						} catch (NumberFormatException e) {
							Weight.writeLongStringInDisplay("Please enter a number");
							Weight.waitForInput();
						} catch (DALException e) {
							Weight.writeLongStringInDisplay("Batch not found. Try again");
							Weight.waitForInput();
						}
					}

					for(int j = 0; j < recipeComponents.size(); j++) {
						if(recipeComponents.get(j).getRawMaterialID() == RawMaterial.getRawMaterialID()) {
							cur = j;
							break;
						}
						Weight.writeLongStringInDisplay("Rawmaterial already weighed");
					}
				}
				ProductBatchComponentDTO ProductBatchComponent = null;
				while(ProductBatchComponent == null) {
					Weight.writeLongStringInDisplay("Weighing " + RawMaterial.getRawMaterialName());
					Weight.waitForInput();
					float weight = Weight.getWeight()/1000.0f;
					float tara = tare/1000.0f;

					float tolareance = recipeComponents.get(cur).getTolerance();
					float desiredWeight = recipeComponents.get(cur).getNom_netto();

					float min = desiredWeight - (tolareance * desiredWeight);
					float max = desiredWeight + (tolareance * desiredWeight);

					if(weight > min && weight < max) {
						ProductBatchComponent = new ProductBatchComponentDTO(ProductBatch.getProductBatchID(), RawMaterialBatch.getRawMaterialBatchID(), tara, weight, user.getUserID());
						try {
							Storage.getProductBatchComponent().createProductBatchComponent(ProductBatchComponent);
							RawMaterialBatch.setAmount(RawMaterialBatch.getAmount() - weight);
							Storage.getRawMaterialBatch().updateRawMaterialBatch(RawMaterialBatch);
							recipeComponents.remove(cur);
							Weight.writeLongStringInDisplay("Component Registered");
							Weight.waitForInput();
						} catch (DALException e) {
							Weight.writeLongStringInDisplay("An error happened");
						}
					} else {
						Weight.writeLongStringInDisplay("Weight outside of tolerance.");
						Weight.waitForInput();
					}
				}
				ProductBatchComponent = null;
				RawMaterialBatch = null;
				RawMaterial = null;
				cur = -1;
			}
			ProductBatch.setStatus(3);
			try {
				Storage.getProductBatch().updateProductBatch(ProductBatch);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ProductBatch.setStatus(3);
			try {
				Storage.getProductBatch().updateProductBatch(ProductBatch);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Weight.writeLongStringInDisplay("All components weighed");
			Weight.waitForInput();
			Weight.writeLongStringInDisplay(" ");


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
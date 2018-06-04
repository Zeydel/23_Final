package dao;

import java.util.ArrayList;
import java.util.List;

import dto.PharmacistViewDTO;
import dto.RecipeDTO;

public class NpPharmacistViewDAO {
	
	ArrayList<PharmacistViewDTO> materials = new ArrayList<PharmacistViewDTO>();
	public NpPharmacistViewDAO() {
		materials.add(new PharmacistViewDTO(123, "Sur sovs", 24, "Boller i karry"));
		materials.add(new PharmacistViewDTO(124, "Sød sovs", 25, "Boller i risengrød"));
		materials.add(new PharmacistViewDTO(125, "sovs", 25, "Boller"));
	}
	
	public PharmacistViewDTO getMaterials(int rawMaterialID) throws DALException {
		for(PharmacistViewDTO material : materials) {
			if(material.getRawMaterialID() == rawMaterialID) {
				return material;
			}
		} throw new DALException("materials with ID: " + rawMaterialID + " Not found");
	}
	
	public List<PharmacistViewDTO> getMaterialList() {
		return materials;
	}
	
	public void addMaterial(PharmacistViewDTO material) {
		materials.add(material);
	}
	
	public void updateMateria(PharmacistViewDTO material) throws DALException {
		for(int i = 0; i<materials.size(); i++) {
			if(materials.get(i).getRawMaterialID() == material.getRawMaterialID()) {
				materials.set(i, material);
				return;
			}
		}throw new DALException("Material with material ID " + material.getRawMaterialID() + " doesn't exist");
	}
	
	public void deleteMateria(int rawMaterialID) throws DALException {
		for(int i = 0; i < materials.size(); i++) {
			if(materials.get(i).getRawMaterialID() == rawMaterialID) {
				materials.remove(i);
				return;
			}
		}throw new DALException("Material with materials ID " + rawMaterialID + "Doesn't exist.");
	}
}

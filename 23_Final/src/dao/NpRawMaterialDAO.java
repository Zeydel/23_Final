package dao;

import java.util.ArrayList;
import java.util.List;

import dto.RawMaterialBatchDTO;
import dto.RawMaterialDTO;

public class NpRawMaterialDAO {

	ArrayList<RawMaterialDTO> RawMaterials = new ArrayList<RawMaterialDTO>();
	public NpRawMaterialDAO() {
		RawMaterials.add(new RawMaterialDTO(1, "dej", "Wawelka"));
		RawMaterials.add(new RawMaterialDTO(2, "tomat", "Knoor"));
		RawMaterials.add(new RawMaterialDTO(5, "ost", "Ost og Skinke A/S"));
	}

	public RawMaterialDTO getRawMaterial(int rawMaterialID) throws DALException {
		for(RawMaterialDTO RawMaterial : RawMaterials) {
			if(RawMaterial.getRawMaterialID() == rawMaterialID) {
				return RawMaterial;
			}
		} throw new DALException("Raw matertial with ID" + rawMaterialID + " not found.");
	}

	public List<RawMaterialDTO> getRawMaterialList(){
		return RawMaterials;
	}

	public void createRawMaterial(RawMaterialDTO RawMaterial) {
		RawMaterials.add(RawMaterial);
	}

	public void updateRawMaterial(RawMaterialDTO RawMaterial) throws DALException {
		for(int i = 0; i < RawMaterials.size(); i++) {
			if(RawMaterials.get(i).getRawMaterialID() == RawMaterial.getRawMaterialID()) {
				RawMaterials.set(i, RawMaterial);
				return;
			}
		} throw new DALException("Raw matertial with ID" + RawMaterial.getRawMaterialID() + " not found.");
	}

	public void deleteRawMaterial(int rawMaterialID) throws DALException {
		for(int i = 0; i < RawMaterials.size(); i++) {
			if(RawMaterials.get(i).getRawMaterialID() == rawMaterialID) {
				RawMaterials.remove(i);
				return;
			}
		} throw new DALException("Raw matertial with ID" + rawMaterialID + " not found.");
	}
}

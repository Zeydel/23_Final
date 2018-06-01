package dao;

import java.util.ArrayList;

import dto.RawMaterialDTO;

public class NpRawMaterialDAO {
	
	ArrayList<RawMaterialDTO> RawMaterials;
	public NpRawMaterialDAO() {
		RawMaterials.add(new RawMaterialDTO(1, "dej", "Wawelka"));
		RawMaterials.add(new RawMaterialDTO(2, "tomat", "Knoor"));
		RawMaterials.add(new RawMaterialDTO(5, "ost", "Ost og Skinke A/S"));
	}

}

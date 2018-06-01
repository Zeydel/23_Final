package dao;

import java.util.ArrayList;

import dto.RawMaterialBatchDTO;

public class NpRawMaterialBatchDAO {
	
	ArrayList<RawMaterialBatchDTO> RawMaterialBatches;
	NpRawMaterialBatchDAO(){
		RawMaterialBatches.add(new RawMaterialBatchDTO(1, 1, 1000F));
		RawMaterialBatches.add(new RawMaterialBatchDTO(2, 2, 300F));
		RawMaterialBatches.add(new RawMaterialBatchDTO(4, 5, 100F));
	}

}

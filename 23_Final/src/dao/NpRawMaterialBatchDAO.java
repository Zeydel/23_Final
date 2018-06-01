package dao;

import java.util.ArrayList;
import java.util.List;

import dto.RawMaterialBatchDTO;

public class NpRawMaterialBatchDAO {
	
	ArrayList<RawMaterialBatchDTO> RawMaterialBatches;
	NpRawMaterialBatchDAO(){
		RawMaterialBatches.add(new RawMaterialBatchDTO(1, 1, 1000F));
		RawMaterialBatches.add(new RawMaterialBatchDTO(2, 2, 300F));
		RawMaterialBatches.add(new RawMaterialBatchDTO(4, 5, 100F));
	}
	
	public RawMaterialBatchDTO getRawMaterialBatch(int rawMaterialBatchID) throws DALException {
		for(RawMaterialBatchDTO rawMaterial : RawMaterialBatches) {
			if(rawMaterial.getRawMaterialBatchID() == rawMaterialBatchID) {
				return rawMaterial;
			}
		} throw new DALException("Rawmaterialbatch with ID" + rawMaterialBatchID + " not found.");
	}
	
	public List<RawMaterialBatchDTO> getRawMaterialBatchList(){
		return RawMaterialBatches;
	}
	
	public void createRawMaterialBatch(RawMaterialBatchDTO RawMaterialBatch) {
		RawMaterialBatches.add(RawMaterialBatch);
	}
	
	public void updateRawMaterialBatch(RawMaterialBatchDTO RawMaterialBatch) throws DALException {
		for(int i = 0; i < RawMaterialBatches.size(); i++) {
			if(RawMaterialBatches.get(i).getRawMaterialBatchID() == RawMaterialBatch.getRawMaterialBatchID()) {
				RawMaterialBatches.set(i, RawMaterialBatch);
			}
		} throw new DALException("Rawmaterialbatch with ID" + RawMaterialBatch.getRawMaterialBatchID() + " not found.");
	}
	
	public void deleteRawMaterialBatch(int rawMaterialBatchID) throws DALException {
		for(int i = 0; i < RawMaterialBatches.size(); i++) {
			if(RawMaterialBatches.get(i).getRawMaterialBatchID() == rawMaterialBatchID) {
				RawMaterialBatches.remove(i);
			}
		} throw new DALException("Rawmaterialbatch with ID" + rawMaterialBatchID + " not found.");
	}
}

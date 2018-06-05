package dao;

import java.util.ArrayList;
import java.util.List;

import dto.RawMaterialViewDTO;

public class NpRawMaterialViewDAO {
	
	ArrayList<RawMaterialViewDTO> RawMaterialViews = new ArrayList<RawMaterialViewDTO>();
	public NpRawMaterialViewDAO() {
		
	}
	
	public RawMaterialViewDTO getRawMaterialView(int rawMaterialBatchID, int rawMaterialID) throws DALException {
		for(RawMaterialViewDTO rawMaterialView : RawMaterialViews) {
			if(rawMaterialView.getRawMaterialBatchID() == rawMaterialBatchID && rawMaterialView.getRawMaterialID() == rawMaterialID) {
				return rawMaterialView;
			}
		} throw new DALException("Rawmaterial view with id " + rawMaterialID + " and " + rawMaterialBatchID + " doesn't exist.");
		
	}
	
	public List<RawMaterialViewDTO> getRawMaterialViewList(){
		return RawMaterialViews;
	}
	
	public void createRawMaterialBatchView(RawMaterialViewDTO RawMaterialView) {
		RawMaterialViews.add(RawMaterialView);
	}
	
	public void updateRawMaterialView(RawMaterialViewDTO RawMaterialView) throws DALException {
		for(int i = 0; i<RawMaterialViews.size(); i++) {
			if(RawMaterialViews.get(i).getRawMaterialBatchID()==RawMaterialView.getRawMaterialBatchID() && RawMaterialViews.get(i).getRawMaterialID()==RawMaterialView.getRawMaterialID()) {
				RawMaterialViews.set(i, RawMaterialView);
				return;
			}
		}throw new DALException("Rawmaterial view with id " + RawMaterialView.getRawMaterialID() + " and " + RawMaterialView.getRawMaterialBatchID() + " doesn't exist.");

	}
	
	public void deleteRawMaterialView(int rawMaterialID, int rawMaterialBatchID) throws DALException {
		for(int i = 0; i<RawMaterialViews.size();i++) {
			if(RawMaterialViews.get(i).getRawMaterialBatchID()==rawMaterialBatchID && RawMaterialViews.get(i).getRawMaterialID()==rawMaterialID) {
				RawMaterialViews.remove(i);
				return;
			}
		} throw new DALException("Rawmaterial view with id " + rawMaterialID + " and " + rawMaterialBatchID + " doesn't exist.");

	}
}

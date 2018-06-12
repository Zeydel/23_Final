package npdao;

import java.util.ArrayList;
import java.util.List;

import dto.DALException;
import dto.RawMaterialBatchViewDTO;

public class NpRawMaterialBatchViewDAO {
	
	ArrayList<RawMaterialBatchViewDTO> RawMaterialViews = new ArrayList<RawMaterialBatchViewDTO>();
	public NpRawMaterialBatchViewDAO() {
		RawMaterialViews.add(new RawMaterialBatchViewDTO(1, 2, 3, "hej"));
	}
	
	public RawMaterialBatchViewDTO getRawMaterialView(int rawMaterialBatchID, int rawMaterialID) throws DALException {
		for(RawMaterialBatchViewDTO rawMaterialView : RawMaterialViews) {
			if(rawMaterialView.getRawMaterialBatchID() == rawMaterialBatchID && rawMaterialView.getRawMaterialID() == rawMaterialID) {
				return rawMaterialView;
			}
		} throw new DALException("Rawmaterial view with id " + rawMaterialID + " and " + rawMaterialBatchID + " doesn't exist.");
		
	}
	
	public List<RawMaterialBatchViewDTO> getRawMaterialViewList(){
		return RawMaterialViews;
	}
	
	public void createRawMaterialBatchView(RawMaterialBatchViewDTO RawMaterialView) {
		RawMaterialViews.add(RawMaterialView);
	}
	
	public void updateRawMaterialView(RawMaterialBatchViewDTO RawMaterialView) throws DALException {
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

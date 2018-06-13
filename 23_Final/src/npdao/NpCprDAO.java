package npdao;

import java.util.ArrayList;

import dto.CprDTO;
import dto.DALException;

public class NpCprDAO {
	
	ArrayList<CprDTO> cprlist = new ArrayList<CprDTO>();
	
	public NpCprDAO() {
		cprlist.add(new CprDTO(1, 12345678));
		cprlist.add(new CprDTO());
		cprlist.add(new CprDTO());
	}
		
		public CprDTO getCpr(int userID) throws DALException {
			for(CprDTO cpr : cprlist) {
				if(cpr.getUserID() == userID) {
					return cpr;
				}
			}
			throw new DALException("User with ID" + userID + " not found.");
		}
		
		public ArrayList<CprDTO> getCpr(){
			return cprlist;
		}
		
		public void createCpr(CprDTO userID) {
			cprlist.addAll(cprlist);
			for(int i = 0; i<cprlist.size();i++) {
				System.out.println(cprlist.get(i).toString());
			}
		}
		
		public void updateCpr(CprDTO cpr) throws DALException {
			for(int i = 0; i < cprlist.size(); i++) {
				if(cprlist.get(i).getUserID() == cpr.getUserID()) {
					cprlist.set(i, cpr);
				}
			} throw new DALException("User with ID" + cpr.getUserID() + " not found.");
		}
		
		public void deleteCpr(int userID) throws DALException {
			for(int i = 0; i < cprlist.size(); i++) {
				if(cprlist.get(i).getUserID() == userID) {
					cprlist.remove(i);
					return;
				}
			} throw new DALException("User with ID" + userID + " not found.");
		}
		
	

}

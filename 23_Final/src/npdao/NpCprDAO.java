package npdao;

import java.util.ArrayList;

import dto.CprDTO;
import dto.ProductBatchComponentDTO;

public class NpCprDAO {
	
	ArrayList<CprDTO> cpr = new ArrayList<CprDTO>();
	
	public NpCprDAO() {
		cpr.add(new CprDTO(1, 12345678));
		cpr.add(new CprDTO());
		cpr.add(new CprDTO());
	}

}

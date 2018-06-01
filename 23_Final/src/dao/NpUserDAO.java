package dao;

import java.util.ArrayList;
import java.util.Arrays;

import dto.UserDTO;

public class NpUserDAO {
	
	ArrayList<UserDTO> Users;
	public NpUserDAO() {
		Users.add(new UserDTO(1, "Angelo A", "AA", "lKie4fa", "080197-0761", new ArrayList<String>(Arrays.asList("Admin", "Pharmacist"))));
		Users.add(new UserDTO(2, "Antonella B", "AB", "atoJ21v", "123456-7890", new ArrayList<String>(Arrays.asList("Pharmacist"))));
		Users.add(new UserDTO(3, "Luigi C", "LC", "iEfm5aO", "987654-3210", new ArrayList<String>(Arrays.asList("Admin"))));
	}

}

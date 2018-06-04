package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import NpUserDAO;

@WebServlet("/html/LoginVerification")
public class LoginVerification extends HttpServlet{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	NpUserDAO testbrugere = new NpUserDAO();
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.hentindtastetid 
    testbruger == indtstaeid 
    	// Check user 
    	
    	response.sendRedirect("/23_Final/html/user-tabel.html");
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/23_Final/html/user-tabel.html");
    }
    
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		
//		resp.sendRedirect("/html/user-list.html");
//	}
}

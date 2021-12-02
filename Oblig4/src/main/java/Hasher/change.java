package Hasher;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.PersonDAO;

/**
 * Servlet implementation class change
 */
@WebServlet("/change")
public class change extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PersonDAO personDAO;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// Method to change all passwords in database to hashed passwords, only used once to change all the test passwords to hash
	// Probably will never need to use again.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hashText = request.getParameter("hash");
		if(hashText.equals("hashpasswords")) {
			personDAO.changeUnhashedPasswordToHashedPassword();
		}
			response.sendRedirect("/Oblig4/index.html");
	}

}

package paamelding;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.PersonDAO;
import persondata.Person;

/**
 * Servlet implementation class Paameldingsbekreftelse
 */
@WebServlet("/Paameldingsbekreftelse")
public class Paameldingsbekreftelse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PersonDAO personDAO;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person deltager = (Person) request.getAttribute("deltager");
		
		request.setAttribute("deltager", deltager);
		request.getRequestDispatcher("/paameldingsbekreftelse.jsp")
	    .forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

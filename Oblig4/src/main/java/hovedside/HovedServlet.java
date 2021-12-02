package hovedside;

import java.io.IOException;
import Validator.Validator;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import database.PersonDAO;
import persondata.Person;

@WebServlet("/deltagerliste")
public class HovedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PersonDAO personDAO; // Oppretter DAO objekt som vi kan bruke for å hente ut data

	// Henter liste fra databasen og forwarder requesten til jsp filen som viser
	// dataen
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Håndterer om en bruker ikke er logget inn
		if (Validator.isLoggedIn(request, response) == false) {
			request.getRequestDispatcher("logginn.jsp")
					.forward(request, response);
		}

		HttpSession session = request.getSession();
		int mobil = Integer.parseInt(session.getAttribute("mobil").toString());

		List<Person> personer = personDAO.hentAllePersoner();

		List<Person> innlogget = personDAO.hentPersonFraMobil(mobil);
		Person person = innlogget.get(0);

		System.out.println(innlogget.get(0));

		request.setAttribute("innlogget", true);
		request.setAttribute("personer", personer);
		request.setAttribute("innlogget", person);

		request.getRequestDispatcher("deltagerliste.jsp")
				.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletRequest response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession();
		sesjon.invalidate();
	}

}

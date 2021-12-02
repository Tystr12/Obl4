package paamelding;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import Hasher.Hasher;
import Validator.Validator;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.PersonDAO;
import innlogging.LoggInnUtil;
import persondata.Kjonn;
import persondata.Person;

@WebServlet("/paamelding")
public class Paamelding extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PersonDAO personDAO;
       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.getRequestDispatcher("paamelding.jsp")
//		.forward(request, response);
//		
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		String passordRepetert = request.getParameter("passordRepetert");
		String inputKjonn =request.getParameter("kjonn");
		
		String kjonn = Person.convertInputToChar(inputKjonn);
		
		boolean navn = Validator.checkNavnFelt(fornavn, etternavn);
		boolean mobilG = Validator.inputMobilErGyldig(mobil);
		boolean passG = Validator.inputPassordFeltErLike(passord, passordRepetert);
		
		
		if(navn && mobilG && passG) {
			Person p = new Person(fornavn, etternavn, Integer.parseInt(mobil), Hasher.hashPassword(passord), kjonn);
			
			personDAO.leggTilPerson(p);
			LoggInnUtil.loggInn(request, passord, mobil);
			request.setAttribute("deltager", p);
			
			
			
			request.getRequestDispatcher("/paameldingsbekreftelse.jsp")
				    .forward(request, response);
		} else {
			String feilmelding = "Det du skreiv var ikke gyldig, vennligst prøv på nytt.";
			request.setAttribute("feilmelding", feilmelding);
			request.getRequestDispatcher("/paamelding.jsp")
					.forward(request, response);
		}
		
	}

}

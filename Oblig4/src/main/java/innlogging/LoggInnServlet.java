package innlogging;

import java.io.IOException;
import Hasher.Hasher;
import Validator.Validator;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import database.PersonDAO;
import persondata.Person;


@WebServlet("/innlogging")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PersonDAO personDAO;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getSession().getAttribute("innlogget")!= null)  {
    		response.sendRedirect("/Oblig4/deltagerliste");
    	}
    	
    	response.sendRedirect("/Oblig4/logginn.jsp");
        
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		
		Person deltager = personDAO.hentPersonFraMobil(Integer.parseInt(mobil)).get(0);
		
		String hashetPass = Hasher.hashPassword(passord);
		
		// hvis input matcher databasen logg inn og send til deltagerlisten.
		if(deltager.getMobil() == Integer.parseInt(mobil) && deltager.getPassord().equals(hashetPass)) {
			LoggInnUtil.loggInn(request, hashetPass, mobil);
			response.sendRedirect("/Oblig4/deltagerliste");
		} else{
			String feilmelding = Validator.invalidSessionMelding;
			request.setAttribute("feilmelding", feilmelding);
			request.getRequestDispatcher("/logginn.jsp")
		    .forward(request, response);
		}
		
	}
		
		

}

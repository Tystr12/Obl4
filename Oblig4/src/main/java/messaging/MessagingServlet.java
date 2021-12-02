package messaging;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Validator.Validator;
import database.MessageDAO;
import database.PersonDAO;
import persondata.Messages;
import persondata.Person;

/**
 * Servlet implementation class MessagingServlet
 */
@WebServlet("/Messaging")
public class MessagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private MessageDAO messageDao;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Håndterer om en bruker ikke er logget inn
				if (Validator.isLoggedIn(request, response) == false) {
					request.getRequestDispatcher("logginn.jsp")
							.forward(request, response);
				}

				HttpSession session = request.getSession();
				int mobil = Integer.parseInt(session.getAttribute("mobil").toString());

				List<Messages> messages = messageDao.hentAlleMessages();

				request.setAttribute("innlogget", true);
				request.setAttribute("messages", messages);
				request.setAttribute("innmobil", session.getAttribute("mobil"));
				

				request.getRequestDispatcher("mes.jsp")
						.forward(request, response);

			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		HttpSession session = request.getSession();
		int author = (int) session.getAttribute("mobil");
		
		
		Messages mes = new Messages(subject, contents, new Timestamp(System.currentTimeMillis()), author);
		messageDao.leggTilMessage(mes);
		
		response.sendRedirect("/Oblig4/Messaging");
	}

}

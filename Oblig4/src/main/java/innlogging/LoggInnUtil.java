package innlogging;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggInnUtil {
	
public static boolean loggInn(HttpServletRequest request, String passord, String mobil) {
		
		//Logge ut
		loggUt(request);
		
		//Logg inn
		
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(60); // 60 sekunder
		sesjon.setAttribute("passord", passord);
		sesjon.setAttribute("mobil", Integer.parseInt(mobil));
		sesjon.setAttribute("innlogget", true);
		return true;
		
		
	}

	//Sjekke om request tilhører innlogget bruker
	
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		return sesjon != null && sesjon.getAttribute("passord") != null;
	}
	
	//Logge ut
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		
		}
	}

}

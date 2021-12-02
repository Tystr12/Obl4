package Validator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Validator {
	
	public static String invalidSessionMelding = "Kun deltagere får se deltagerlisten. Venligst logg inn eller registrer deg.";
	
	public static boolean isLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		    HttpSession session = request.getSession(false);
		    if (session == null || session.getAttribute("mobil") == null) {
		       
		    	request.setAttribute("feilmelding", invalidSessionMelding);
		    	return false;
		    	
		}
		    return true;
	}
	
	public static boolean checkNavnFelt(String fornavn, String etternavn) throws IOException, ServletException {
		boolean erGyldig = false;
		if(inputNavnErGyldig(fornavn) && inputNavnErGyldig(etternavn)) {
			erGyldig = true;
		}
		return erGyldig;
	}
	
	public static boolean inputNavnErGyldig(String input) {
		boolean isValid = false;
		if(input.substring(0, 1).equals(input.substring(0, 1).toUpperCase()) && input.length() >= 2) {
			isValid = true;
		}
		return isValid;
	}
	
	public static boolean inputMobilErGyldig(String input) {
		if(input.trim().length() != 8) {
			return false;
		}
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean inputPassordFeltErLike(String passord, String pasordRepetert) {
		if(passord.equals(pasordRepetert)) {
			return true;
		}
		return false;
	}
	
}

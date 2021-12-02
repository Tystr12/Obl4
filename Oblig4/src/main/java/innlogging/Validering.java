package innlogging;

import java.util.List;

import database.PersonDAO;
import persondata.Person;

public class Validering {
	
	public static boolean isGyldigPassord(String passord, String mobil) {
    	boolean erGyldig = false;
    	PersonDAO personDAO = new PersonDAO();
    	List<Person> queryResults = personDAO.hentPersonFraMobil(Integer.parseInt(mobil));
    	Person p = queryResults.get(0);
    	if(p.getPassord() == passord) {
    		erGyldig = true;
    	}
    	return erGyldig;
    }
}

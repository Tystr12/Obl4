package database;

import java.util.ArrayList;
import Hasher.Hasher;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import persondata.Messages;
import persondata.Person;

@Stateless
public class MessageDAO {
	
	@PersistenceContext(name="messagesDB") //samme navnet som ligger i persistencexml persistence unit name
	private EntityManager em;
	
	// Henter ut liste av studenter fra databasen vår ved å bruke entitymanager, slipper try catch
	public List<Messages> hentAlleMessages() {
		
		TypedQuery<Messages> query = em.createQuery("select m from Messages m ORDER BY m.created_on DESC", Messages.class);
		return query.getResultList();
	}
		
	@Transactional
	public void leggTilMessage(Messages m) {
		m = em.merge(m);
		em.persist(m);
	}
	
	public Person getPersonFromMessage(Messages m) {
		PersonDAO p = new PersonDAO();
		List<Messages> list = new ArrayList<>();
		list.add(em.find(Messages.class, m.getMessage_author()));
		return (Person) list;
	}
	
	public List<Messages> hentMessagesFraMobil(int mobil) {
		List<Messages> list = new ArrayList<>();
		list.add(em.find(Messages.class, mobil));
		return list;
	}
	
	
}


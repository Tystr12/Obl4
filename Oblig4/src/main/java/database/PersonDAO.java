package database;

import java.util.ArrayList;
import Hasher.Hasher;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import persondata.Person;

@Singleton
public class PersonDAO {
	
	@PersistenceContext(name="personDB") //samme navnet som ligger i persistencexml persistence unit name
	private EntityManager em;
	
	// Henter ut liste av studenter fra databasen vår ved å bruke entitymanager, slipper try catch
	public List<Person> hentAllePersoner() {
		
		TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
		return query.getResultList();
	}
		
	@Transactional
	public void leggTilPerson(Person p) {
		p = em.merge(p);
		em.persist(p);
	}
	
	public List<Person> hentPersonFraMobil(int mobil) {
		List<Person> list = new ArrayList<>();
		list.add(em.find(Person.class, mobil));
		return list;
	}
	
	// Changes all passwords in the database that are unhashed to hashed passwords 
	@Transactional
	public void changeUnhashedPasswordToHashedPassword() {
		TypedQuery<Person> queryOfPeople = em.createQuery("select p from Person p", Person.class);
		List<Person> listOfUnhashedPasswords = queryOfPeople.getResultList();
		for(Person p: listOfUnhashedPasswords) {
			String pass = p.getPassord();
			if(pass.length() < 15) {
				p.setPassord(Hasher.hashPassword(pass));
				p = em.merge(p);
				em.persist(p);
			}
		}
	}
	
	
}

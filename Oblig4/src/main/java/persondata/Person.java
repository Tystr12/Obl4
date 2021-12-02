package persondata;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "obl4")
public class Person {
	
	public Person(String fornavn, String etternavn, int mobil, String passord, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.kjonn = kjonn;
	}
	
	public Person() {
		
	}
	
	private String fornavn;
	private String etternavn;
	
	@Id
	private int mobil;
	
	private String passord;
	private String kjonn;
	

	@Override
	public String toString() {
		return "Person [fornavn=" + fornavn + ", etternavn=" + etternavn + ", telefon=" + mobil + ", passord="
				+ passord + ", kjonn=" + kjonn + "]";
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getMobil() {
		return mobil;
	}

	public void setMobil(int telefon) {
		this.mobil = telefon;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}


	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	public static String convertInputToChar(String kjonn) {
		String input = kjonn.toUpperCase();
		String result;
		if(input.equals("MANN")) {
			result = "M";
		} else {
			result = "K";
		}
		return result;
		
	}
	
}

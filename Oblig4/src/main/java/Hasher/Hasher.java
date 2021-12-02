package Hasher;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hasher {
	
	public static String hashPassword(String password){
		
		
		
		byte[] passwordSomBytes = null;
		try {
			passwordSomBytes = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] digest = md.digest(passwordSomBytes);
		
		return Base64.getEncoder().encodeToString(digest);
	}

}

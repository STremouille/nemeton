package test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import cryption.Crypting;

public class CryptingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String crypted = "";
		String decrypted="";
		String secret="ThisIsASecretKey";
		try {
			crypted=Crypting.crypt("test de", "AES",secret);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Text crypted :"+crypted);
		
		try {
			decrypted=Crypting.decrypt(crypted, "AES",secret);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Text decrypted :"+decrypted);
	}

}

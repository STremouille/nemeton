package cryption;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypting {
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
	

		
	public static String crypt(String textToCrypt,String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		Key key = new SecretKeySpec(keyValue, transformation);
		Cipher c = Cipher.getInstance(transformation);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(textToCrypt.getBytes());
		return new String(encValue);
	}
	
	public static String decrypt(String textToCrypt,String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Key key = new SecretKeySpec(keyValue, transformation);
		Cipher c = Cipher.getInstance(transformation);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decodeValue = c.doFinal(textToCrypt.getBytes());
		return new String(decodeValue);
	}
	
	public static byte[] crypt(byte[] byteToCrypt,String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		Key key = new SecretKeySpec(keyValue, transformation);
		Cipher c = Cipher.getInstance(transformation);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(byteToCrypt);
		return encValue;
	}
	
	public static byte[] decrypt(byte[] byteToDecrypt,String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		Key key = new SecretKeySpec(keyValue, transformation);
		Cipher c = Cipher.getInstance(transformation);
		c.init(Cipher.DECRYPT_MODE, key);
		return c.doFinal(byteToDecrypt);
	}
}

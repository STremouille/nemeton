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
	private static byte[] keyValue;
	
	private static void initCrypt(String secret){
		keyValue = new String(secret).getBytes();
		System.out.println("init");
	}

		
	public static String crypt(String textToCrypt,String transformation,String secret) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		initCrypt(secret);
		System.out.println(new String(keyValue));
		Key key = new SecretKeySpec(keyValue, transformation);
		Cipher c = Cipher.getInstance(transformation);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(textToCrypt.getBytes());
		return new String(encValue);
	}
	
	public static String decrypt(String textToCrypt,String transformation,String secret) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		initCrypt(secret);
		Key key = new SecretKeySpec(keyValue, transformation);
		Cipher c = Cipher.getInstance(transformation);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decodeValue = c.doFinal(textToCrypt.getBytes());
		return new String(decodeValue);
	}
	
	public static byte[] crypt(byte[] byteToCrypt,String transformation,String secret) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		initCrypt(secret);
		Key key = new SecretKeySpec(keyValue, transformation);
		Cipher c = Cipher.getInstance(transformation);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = new byte[10];
//		byte[] encValue = c.doFinal(byteToCrypt);
		return encValue;
	}
	
	public static byte[] decrypt(byte[] byteToDecrypt,String transformation,String secret) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		initCrypt(secret);
		Key key = new SecretKeySpec(keyValue, transformation);
		Cipher c = Cipher.getInstance(transformation);
		c.init(Cipher.DECRYPT_MODE, key);
		return c.doFinal(byteToDecrypt);
	}
}

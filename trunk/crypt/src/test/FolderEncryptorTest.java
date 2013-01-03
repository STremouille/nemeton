package test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import cryption.FolderEncryptor;

public class FolderEncryptorTest {
	
	public static void main (String[] args)
	{
		String secret = "ThisIsASecretKey";
		try {
			FolderEncryptor.decryptFolder("testfolder", "aes",secret);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

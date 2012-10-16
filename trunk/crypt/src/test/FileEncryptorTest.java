package test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import cryption.FileEncryptor;

public class FileEncryptorTest {
	public static void main(String[] args)
	{
		try {
			//FileEncryptor.cryptFile("frenchgoldrap.mp3", "aes");
//			FileEncryptor.decryptFile("frenchgoldrap.mp3.sam", "aes");
			FileEncryptor.decryptFile("tst1.txt.sam", "aes");
		} catch (IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

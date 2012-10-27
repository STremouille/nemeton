package test;

import java.io.File;
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
		String secret="ThisIsASecretKey";
		try {
			FileEncryptor.cryptFile("testfolder\\nemeton.jar", "aes",secret);
//			FileEncryptor.decryptFile("tst1.txt.sam", "aes",secret);
		} catch (IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

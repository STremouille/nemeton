package main;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import cryption.FolderEncryptor;
import frame.MyFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if(args.length>1)
			{
				if(args[0].equals("-c")||args[0].equals("-C"))
					FolderEncryptor.cryptFolder(args[1], "aes");
				else if(args[0].equals("-d")||args[0].equals("-D"))
					FolderEncryptor.decryptFolder(args[1], "aes");
			}
			else
			{
				MyFrame mf= new MyFrame();
			}
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

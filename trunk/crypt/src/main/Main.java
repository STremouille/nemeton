package main;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.sound.midi.ControllerEventListener;
import javax.swing.text.View;

import ui.CryptController;
import ui.CryptModel;
import ui.CryptView;

import cryption.FolderEncryptor;

public class Main {

	/**
	 * @param args
	 */
	static String secret = "ThisIsASecretKey";
	
	private static CryptModel model;
	private static CryptView view;
	private static CryptController controller;
	
	public static void main(String[] args) {
		// init MVC
		model = new CryptModel();
		
		try {
			if(args.length>1)
			{
				if(args[0].equals("-c")||args[0].equals("-C"))
					model.cryptFolder(args[1], "aes",secret);
				else if(args[0].equals("-d")||args[0].equals("-D"))
					model.decryptFolder(args[1], "aes",secret);
			}
			else
			{
				view = new CryptView(model);
				controller = new CryptController(model, view);
			}
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

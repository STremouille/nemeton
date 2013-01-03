package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import cryption.FolderEncryptor;

public class CryptModel extends FolderEncryptor{
	public CryptModel(){
		super();
	}
//	private void myAction() {
//		// TODO Auto-generated method stub
//		open.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				fileChooser.showOpenDialog(open);
//				path.setText(fileChooser.getSelectedFile().getAbsolutePath());
//			}
//		});
//		
//		crypt.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				if(!(path.getText().equals("")|path.getText().equals(null)))
//				{
//					try {
//						System.out.println("Start Crypting ...");
//						model.cryptFolder(path.getText(), "AES",new String(passField.getPassword()));
//						System.out.println("End Cryption");
//					} catch (InvalidKeyException | NoSuchAlgorithmException
//							| NoSuchPaddingException
//							| IllegalBlockSizeException | BadPaddingException
//							| IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		
//		decrypt.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				if(!(path.getText().equals("")|path.getText().equals(null)))
//				{
//					try {
//						System.out.println("Start Decrypting ...");
//						model.decryptFolder(path.getText(), "AES",new String(passField.getPassword()));
//						System.out.println("End Decryption");
//					} catch (InvalidKeyException | NoSuchAlgorithmException
//							| NoSuchPaddingException
//							| IllegalBlockSizeException | BadPaddingException
//							| IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//	}
	
}

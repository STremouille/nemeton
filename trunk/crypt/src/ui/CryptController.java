package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CryptController {
	private CryptModel model;
	private CryptView view;

	public CryptController(CryptModel m, CryptView v) {
		this.model = m;
		this.view = v;

		view.addOpenListener(new OpenListener());
		view.addCryptListener(new CryptListener());
		view.addDecryptListener(new DecryptListener());
	}

	class OpenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Open");
			view.getFileChooser().showOpenDialog(view.getOpen());
			view.getPath().setText(view.getFileChooser().getSelectedFile().getAbsolutePath());
			System.out.println(view.getPath().getText());
		}

	}

	class CryptListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (!(view.getPath().getText().equals(""))) {
				try {
					System.out.println("Start Crypting ...");
					model.cryptFolder(view.getPath().getText(), "AES",
							new String(view.getPassField().getPassword()));
					System.out.println("End Cryption");
				} catch (InvalidKeyException | NoSuchAlgorithmException
						| NoSuchPaddingException | IllegalBlockSizeException
						| BadPaddingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	class DecryptListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (!(view.getPath().getText().equals(""))) {
				try {
					System.out.println("Start Decrypting ...");
					model.decryptFolder(view.getPath().getText(), "AES",
							new String(view.getPassField().getPassword()));
					System.out.println("End Decryption");
				} catch (InvalidKeyException | NoSuchAlgorithmException
						| NoSuchPaddingException | IllegalBlockSizeException
						| BadPaddingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
}

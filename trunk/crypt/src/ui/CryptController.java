package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class CryptController {
	private CryptModel model;
	private CryptView view;

	public CryptController(CryptModel m, CryptView v) {
		this.model = m;
		this.view = v;

		model.setObservator(this);

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
			view.getPath().setText(
					view.getFileChooser().getSelectedFile().getAbsolutePath());
			System.out.println(view.getPath().getText());
		}

	}

	class CryptListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String pass = new String(view.getPassField().getPassword());
			adaptProgressBar(new File(view.getPath().getText()).listFiles().length);
			if (pass.length() > 16 || pass.length() < 8) {
				view.getAlert();
				JOptionPane.showMessageDialog(view,
						"Please enter a password between 8 and 16 characters");
			} else {
				if (!(view.getPath().getText().equals(""))) {
					System.out.println("Start Crypting ...");
					final String p = view.getPath().getText();
					final String pp = String.valueOf(view.getPassField()
							.getPassword());
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								model.cryptFolder(p, "AES", pp);
							} catch (InvalidKeyException
									| NoSuchAlgorithmException
									| NoSuchPaddingException
									| IllegalBlockSizeException
									| BadPaddingException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					System.out.println("End Cryption");

				}
			}
		}
	}

	class DecryptListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String pass = new String(view.getPassField().getPassword());
			adaptProgressBar(new File(view.getPath().getText()).listFiles().length);
			if (pass.length() > 16 || pass.length() < 8) {
				view.getAlert();
				JOptionPane.showMessageDialog(view,
						"Please enter a password between 8 and 16 characters");
			} else {
				if (!(view.getPath().getText().equals(""))) {
					System.out.println("Start Decrypting ...");
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							try {
								model.decryptFolder(view.getPath().getText(),
										"AES", new String(view.getPassField()
												.getPassword()));
							} catch (InvalidKeyException
									| NoSuchAlgorithmException
									| NoSuchPaddingException
									| IllegalBlockSizeException
									| BadPaddingException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("End Decryption");
						}

					});

				}
			}
		}
	}

	public void adaptProgressBar(int b) {
		JProgressBar p = new JProgressBar(0, b);
		p.setStringPainted(true);
		p.setValue(0);
		view.setProgressBar(p);
	}

	public void notifyPB() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				view.getProgressBar().setValue(
						view.getProgressBar().getValue() + 1);
			}
		});

	}

}

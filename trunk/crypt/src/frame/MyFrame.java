package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import cryption.FolderEncryptor;

public class MyFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout layout;
	JButton crypt,decrypt,open;
	JFileChooser fileChooser;
	JPanel southPanel,centerPanel;
	JLabel path;
	JPasswordField passField;
	String secret;
	
	public MyFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 800);
		this.setTitle("Arc");
		this.secret="ThisIsASecretKey";
		
		layout = new CardLayout();
		crypt = new JButton("Crypt");
		decrypt = new JButton("Decrypt");
		open = new JButton("File to Crypt/Decrypt");
		passField = new JPasswordField();
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setCurrentDirectory(new File(MyFrame.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
		path = new JLabel();
		southPanel = new JPanel(new GridLayout());
		centerPanel = new JPanel(new GridLayout());
		
		
		centerPanel.add(path, "Path");
		centerPanel.add(open,"Open");
		southPanel.add(crypt);
		southPanel.add(passField);
		southPanel.add(decrypt);
		
		this.getContentPane().add(centerPanel,BorderLayout.CENTER);
		this.getContentPane().add(southPanel,BorderLayout.PAGE_END);
		
		
		
		myAction();
		this.setVisible(true);
	}
	

	private void myAction() {
		// TODO Auto-generated method stub
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fileChooser.showOpenDialog(open);
				path.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		});
		
		crypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!(path.getText().equals("")|path.getText().equals(null)))
				{
					try {
						System.out.println("Start Crypting ...");
						FolderEncryptor.cryptFolder(path.getText(), "AES",new String(passField.getPassword()));
						System.out.println("End Cryption");
					} catch (InvalidKeyException | NoSuchAlgorithmException
							| NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		decrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!(path.getText().equals("")|path.getText().equals(null)))
				{
					try {
						System.out.println("Start Decrypting ...");
						FolderEncryptor.decryptFolder(path.getText(), "AES",new String(passField.getPassword()));
						System.out.println("End Decryption");
					} catch (InvalidKeyException | NoSuchAlgorithmException
							| NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		this.repaint();
	}
}

package ui;

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

public class CryptView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout layout;
	private JButton crypt,decrypt,open;
	private JFileChooser fileChooser;
	private JPanel southPanel,centerPanel;
	private JLabel path;
	private JPasswordField passField;
	private String secret;
	
	private CryptModel model;
	
	public CryptView(CryptModel model)
	{
		this.model=model;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 800);
		this.setTitle("Arc");
		this.secret="ThisIsASecretKey";
		
		layout = new CardLayout();
		crypt = new JButton("Crypt");
		decrypt = new JButton("Decrypt");
		open = new JButton("File to Crypt/Decrypt");
		passField = new JPasswordField();
		passField.setToolTipText("Enter here your secret key");
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setCurrentDirectory(new File(CryptView.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
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
		
		this.setVisible(true);
	}
	
	public void addOpenListener(ActionListener ol){
		open.addActionListener(ol);
	}
	
	public void addCryptListener(ActionListener ol){
		crypt.addActionListener(ol);
	}
	
	public void addDecryptListener(ActionListener ol){
		decrypt.addActionListener(ol);
	}
	public JPasswordField getPassField() {
		return passField;
	}

	public void setPassField(JPasswordField passField) {
		this.passField = passField;
	}

	

	public JFileChooser getFileChooser() {
		// TODO Auto-generated method stub
		return fileChooser;
	}
	
	public JButton getOpen() {
		return open;
	}

	public void setOpen(JButton open) {
		this.open = open;
	}

	public JLabel getPath() {
		return path;
	}

	public void setPath(JLabel path) {
		this.path = path;
	}
}
	


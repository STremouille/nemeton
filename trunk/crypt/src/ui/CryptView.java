package ui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


public class CryptView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton crypt,decrypt,open;
	private JFileChooser fileChooser;
	private JTextField path;
	private JPasswordField passField;
	private JOptionPane alert;
	private JLabel cryptDecrypt;
	private GridLayout layout;
	private CryptModel model;
	private JProgressBar progressBar;
	
	public CryptView(CryptModel model)
	{
		this.setModel(model);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 800);
		this.setTitle("Nemeton");
		
//		icon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon((File.listRoots()[0]);

		cryptDecrypt = new JLabel("Crypt/Decrypt");
		crypt = new JButton("Crypt");
		decrypt = new JButton("Decrypt");
		open = new JButton("Select file/folder");
		passField = new JPasswordField();
		passField.setToolTipText("Enter here your secret key");
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setCurrentDirectory(new File(CryptView.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
		path = new JTextField();
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);

		layout = new GridLayout(3, 3);
		this.getContentPane().setLayout(layout);
		this.getContentPane().add(cryptDecrypt);
		this.getContentPane().add(path);
		this.getContentPane().add(open);
		this.getContentPane().add(crypt);
		this.getContentPane().add(passField);
		this.getContentPane().add(decrypt);
		this.getContentPane().add(new JLabel());
		this.getContentPane().add(progressBar);
		this.pack();
		this.setVisible(true);
	}
	
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public JButton getCrypt() {
		return crypt;
	}

	public void setCrypt(JButton crypt) {
		this.crypt = crypt;
	}

	public JButton getDecrypt() {
		return decrypt;
	}

	public void setDecrypt(JButton decrypt) {
		this.decrypt = decrypt;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
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

	public JTextField getPath() {
		return path;
	}

	public void setPath(JTextField path) {
		this.path = path;
	}

	public JOptionPane getAlert() {
		return alert;
	}

	public void setAlert(JOptionPane alert) {
		this.alert = alert;
	}

	public CryptModel getModel() {
		return model;
	}

	public void setModel(CryptModel model) {
		this.model = model;
	}
	
	
}
	


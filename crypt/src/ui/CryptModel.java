package ui;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.SwingUtilities;

import cryption.FileEncryptor;
import cryption.FolderEncryptor;

public class CryptModel extends FolderEncryptor{
	private CryptController observator;

	public void setObservator(CryptController observator)
	{
		this.observator=observator;
	}
	public CryptModel(){
		super();
	}
	
	public void cryptFolder(String path,String transformation,String secret) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		File f = new File(path);
		if(f.isDirectory())
		{
			String[] content = f.list();
			for(int i=0;i<content.length;i++)
			{
				
				cryptFolder(path+File.separator+content[i], transformation,secret);
			}
		}
		else
		{
			final String fPath=path;
			final String fTransformation=transformation;
			final String fSecret=secret;
			
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						try {
							FileEncryptor.cryptFile(fPath, fTransformation,fSecret);
						} catch (InvalidKeyException | NoSuchAlgorithmException
								| NoSuchPaddingException
								| IllegalBlockSizeException
								| BadPaddingException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(observator!=null)
							observator.notifyPB();
					}
				});
				
		}
	}
	
	public void decryptFolder(String path,String transformation,String secret) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		File f = new File(path);
		if(f.isDirectory())
		{
			String[] content = f.list();
			for(int i=0;i<content.length;i++)
			{
				decryptFolder(path+File.separator+content[i], transformation,secret);
			}
		}
		else
		{
			final String fPath=path;
			final String fTransformation=transformation;
			final String fSecret=secret;
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					try {
						FileEncryptor.decryptFile(fPath, fTransformation,fSecret);
						if(observator!=null)
							observator.notifyPB();
					} catch (InvalidKeyException | NoSuchAlgorithmException
							| NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
}

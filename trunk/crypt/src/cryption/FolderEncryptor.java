package cryption;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import ui.CryptController;

public class FolderEncryptor {
private CryptController t;

	public void setObservator(CryptController t)
	{
		this.t=t;
	}
	
	public synchronized void cryptFolder(String path,String transformation,String secret) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
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
			FileEncryptor.cryptFile(path, transformation,secret);
			if(t!=null)
				t.notifyPB();
		}
	}
	
	public synchronized void decryptFolder(String path,String transformation,String secret) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
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
			FileEncryptor.decryptFile(path, transformation,secret);
			if(t!=null)
				t.notifyPB();
		}
	}
}

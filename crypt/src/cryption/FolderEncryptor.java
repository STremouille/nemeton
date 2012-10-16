package cryption;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class FolderEncryptor {
	
	
	public static void cryptFolder(String path,String transformation) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		File f = new File(path);
		if(f.isDirectory())
		{
			String[] content = f.list();
			for(int i=0;i<content.length;i++)
			{
				
				cryptFolder(path+File.separator+content[i], transformation);
			}
		}
		else
		{
			FileEncryptor.cryptFile(path, transformation);
		}
	}
	
	public static void decryptFolder(String path,String transformation) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		File f = new File(path);
		if(f.isDirectory())
		{
			String[] content = f.list();
			for(int i=0;i<content.length;i++)
			{
				decryptFolder(path+File.separator+content[i], transformation);
			}
		}
		else
		{
			FileEncryptor.decryptFile(path, transformation);
		}
	}
}

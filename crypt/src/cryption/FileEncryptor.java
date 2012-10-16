package cryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class FileEncryptor {
	FileInputStream fis;
	InputStreamReader isr;
	
	/*public static void writeFile(String name,byte[] fileContent) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(name);
		fos.write(fileContent);
	}*/
	
	public static void cryptFile(String path,String transformation) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		String parent = path.substring(0, path.lastIndexOf(File.separator));
		String child = path.substring(path.lastIndexOf(File.separator),path.length());
		FileOutputStream fos = new FileOutputStream(new File(new File(parent), child+".sam"));
		
		System.out.println("Crypting -> "+child);
		fos.write(cryptFileContent(path,transformation));
		new File(new File(parent), child).delete();
		fos.close();
	}
	
	public static void decryptFile(String path,String transformation) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		String parent = path.substring(0, path.lastIndexOf(File.separator));
		String child = path.substring(path.lastIndexOf(File.separator),path.length());
		child=child.substring(0, child.lastIndexOf("."));
		FileOutputStream fos = new FileOutputStream(new File(new File(parent), child));
		
		System.out.println("Decrypting -> "+child);
		fos.write(decryptFileContent(path,transformation));
		new File(new File(parent), child+".sam").delete();
		fos.close();
	}
	
	private static byte[] cryptFileContent(String path,String transformation)
	{
		File f = new File(path);
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			byte fileContent[] = new byte[(int)f.length()];
			fis.read(fileContent);
			fis.close();
			return Crypting.crypt(fileContent, transformation);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private static byte[] decryptFileContent(String path,String transformation)
	{
		File f = new File(path);
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			byte fileContent[] = new byte[(int)f.length()];
			fis.read(fileContent);
			fis.close();
			return Crypting.decrypt(fileContent, transformation);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

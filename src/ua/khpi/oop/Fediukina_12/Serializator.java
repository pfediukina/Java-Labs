package ua.khpi.oop.Fediukina_12;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializator <T> {
	
	public void serialization(T container )
	{	
		String path = Console.SerMenu();
		if(path == null) return;
		ObjectOutputStream oos = null;
		try {
			XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream( path +".xml")));

			encoder.writeObject(container);
			encoder.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally { 
			if(oos!=null) 
			{
				try {oos.close();} catch (IOException e) {e.printStackTrace();}
				}
			System.out.println("\nЗбережено!");
		}
	}
	
	public T deserializtion() {
		T c = null;
		String path = Console.DeserMenu();
		if(path == null) return null;
		
		try {
			 XMLDecoder decoder = new XMLDecoder(
					    new BufferedInputStream(
					    new FileInputStream(path)));

			@SuppressWarnings("unchecked")
			var b = (T) decoder.readObject();
			 
			return b;
				 
			}	catch(FileNotFoundException e) {e.printStackTrace();}
		         
		        finally { System.out.println("\nДодано!");;
				}
		 
		 return c;
	}
}
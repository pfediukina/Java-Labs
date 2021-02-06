package ua.khpi.oop.Fediukina_08;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializator {
	
	public void serialization(Container container )
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
	
	public Container deserializtion() {
		Container c = null;
		String path = Console.DeserMenu();
		if(path == null) return null;
		
		try {
			 XMLDecoder decoder = new XMLDecoder(
					    new BufferedInputStream(
					    new FileInputStream(path)));

			var b = (Container ) decoder.readObject();
			 
			return b;
				 
			}	catch(FileNotFoundException e) {e.printStackTrace();}
		         
		        finally { System.out.println("\nДодано!");;
				}
		 
		 return c;
	}
}
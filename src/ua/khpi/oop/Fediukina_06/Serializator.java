package ua.khpi.oop.Fediukina_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializator {

	public boolean serialization(Container container )
	{
		boolean flag=false;
		
		
		File file = new File( "save.data");///pathname
		ObjectOutputStream oos=null;
		
		try {
		FileOutputStream fos=new FileOutputStream(file);
		if(fos!=null) {
			oos= new ObjectOutputStream(fos);
			oos.writeObject(container);
			flag=true;
			}
		}	catch(FileNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();	}
		    finally { 
		    	if(oos!=null) 
		    		{try {oos.close();} catch (IOException e) {e.printStackTrace();}}
		    }
		return flag;
	}
	public Container deserializtion() {
		Container container=null;
		File file = new File( "save.data");///pathname
		 ObjectInputStream ois=null;
		 try {
			FileInputStream fis=new FileInputStream(file);
		
			if(fis!=null) {
				ois= new ObjectInputStream(fis);
				container=(Container)ois.readObject();
				
				}
			}	catch(FileNotFoundException e) {e.printStackTrace();}
		        catch (IOException e) {e.printStackTrace();	}
		        catch (ClassNotFoundException e) {e.printStackTrace();	}
		 finally { 
		    	//if(ois!=null) 
		    		{try {ois.close();} catch (IOException e) {e.printStackTrace();}}
		    }
		 return container;
	}
}
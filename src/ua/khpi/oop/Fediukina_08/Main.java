package ua.khpi.oop.Fediukina_08;
 
import java.util.Scanner;

public class Main {
	 
	public static Scanner in = new Scanner(System.in);
	public static Serializator serializator = new Serializator();
	private static int command;
	
	public static void main(String[] args) {
		Container c = new Container();
		
		do {
			command = Console.MenuText();
			switch(command)
			{
			case 1: c.print(); break;
			case 2: c.add(); break;
			case 3: c.set(); break;
			case 4: c.search(); break;
			case 5: c.Sort(); break;
			case 6: serializator.serialization(c); break;
			case 7: c = serializator.deserializtion(); break;
			case 8: c.clear(); break;
			default:
				System.out.println("Невідома команда: " + command);
				break;
			}
		} while (command != 0);
	}
}

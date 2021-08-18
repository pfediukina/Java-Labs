package ua.khpi.oop.Fediukina_09;
 
import java.util.Scanner;

public class Main {
	 
	public static Scanner in = new Scanner(System.in);
	@SuppressWarnings("rawtypes")
	public static Serializator<ContainerList> serializator = new Serializator<ContainerList>();
	private static int command;
	
	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ContainerList<PoliceCabinet> c = new ContainerList<PoliceCabinet>();
		
		do {
			command = Console.MenuText();
			switch(command)
			{
			case 1: 
				{
					List<PoliceCabinet> h = c.getHead();
					System.out.println("");
					int num = 1;
					while(h.next != null)
					{
						h = h.next;
						h.num.print(Integer.toString(num));
						num++;
					}
					break;
				}
			case 2:
				{
					PoliceCabinet pc = Console.Add();
					pc.print("");
					c.add(pc); 
					break;
				}
			case 3:
				{
					c.delete(Console.getNum());
				} break;
			case 4: {
				PoliceCabinet p = c.change(Console.getNum());
				if(p != null)
				{
					p.set();
				}
				
			}; break;
			case 5: serializator.serialization(c); break;
			case 6: c = serializator.deserializtion(); break;
			case 0: return;
			default:
				System.out.println("Невідома команда: " + command);
				break;
			}
		} while (command != 0);
	}
}

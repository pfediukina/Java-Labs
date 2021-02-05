package ua.khpi.oop.Fediukina_07;
 
import java.util.Scanner;

public class Main {
	 
	public static Scanner in = new Scanner(System.in);
	private static int command;
	
	public static void main(String[] args) {
		PoliceCabinet c = new PoliceCabinet();
		
		do {
			command = Menu();
			switch (command) {
			case 1: c.print("0"); break;
			case 2: c.set(); break;
			case 0: break;
			default:
				System.out.println("Невідома команда: " + command);
				break;
			}
		} while (command != 0);
	}
	
	private static int Menu()
	{
		System.out.println(   "\nКоманди:\n"
							+ "1 - Вивести данні\n"
							+ "2 - Змінити\n" 
							+ "0 - Завершити роботу");
		System.out.print("Введіть вашу команду: ");
		return in.nextInt();
	}
}

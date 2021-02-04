package ua.khpi.oop.Fediukina_04;

import java.util.Date;
import java.util.Scanner;

public class Helper {
	public static boolean debug=false;
	public static boolean help=false;
	static Date date = new Date();
	
	public static Scanner in = new Scanner(System.in);
	
	public static void Help()
	{
		
		if (Helper.debug==true) 
			System.out.println("\n("+Helper.date.toString()+") Виклик функції 'Help' )"); 
		if(help)
		{
			System.out.println("\n   Автор: Федюкіна Поліна \n   Група КIT-119Д\n\nЗавдання:\nВвести текст. У тексті знайти всі пари слів,"
					+ "з яких одне є обігом (словом навпаки) іншого (наприклад: \"abc\"-\"cba\", \"def\"-\"fed\")."
					+ "Результат вивести у вигляді таблиці."
					+ "\nПропуски, що повторюються, замiнити на одиночнi. "
					+ "\nВивести початковий текст та результат.");
		}
		
					System.out.println("\nНавігація команд:"
					+"\n*1 (printI)    - вивести поточнi записанi даннi"
					+"\n*2 (add)       - записати/перезаписати даннi"
					+"\n*3 (task)      - виконати основне завдання"
					// +"\n*cls-очистка консоли"
					+"\n*4 (del)       - очистити данi"
					+"\n*5 (help)      - команди ta iнформацiя"
					+"\n*0 (exit)      - вийти");
					
			if (debug==true)
				System.out.println("\n(("+date.toString()+") Функція 'Help' закінчила роботу )");
		}
	
	public static String GetText(String command)
	{
		if (debug==true) {
			System.out.println("\n(("+date.toString()+") Викликана фукція 'GetText'. " +"Вхідні данні: command=\""+command+"\")\n");
		}
		
		System.out.print(command);
		String s = in.nextLine();
		
		if (debug==true)System.out.println("\n(("+date.toString()+") Функція 'GetText' закінчила роботу. Вихід: " + s + ")");
		return s;
	}
	
	public static void GetWords(String s)
	{
		if (debug==true)System.out.println("\n(("+date.toString()+") Викликана фукція 'GetWords'. " +"Вхідні данні: s="+s+")\n");
		String s1 = s.toLowerCase() + " ";
			
		if(s.isEmpty())
		{
			if (debug==true)System.out.println("\n(("+date.toString()+") Функція 'GetWords' закінчила роботу.)");
			System.out.println("\n\nВаш текст пустий!");
			return;
		}
		
		StringBuilder text = new StringBuilder(" "+ s1 + " "); //для редагування
		String search = text.toString();
		for(int i = 0; i < text.length(); i++) //заміна зайвих символів на пробіл
		{
			if(text.charAt(i) < 'a' || text.charAt(i) > 'z')
				text.setCharAt(i, ' ');
		}
		
		boolean OneWord = false;
		String word = "";
		for(int i = 0; i < text.length(); i++) // пошук слів
		{
			if(text.charAt(i) != ' ')
				word += text.charAt(i);
			else //якщо кінец слова - обертаємо його та шукаємо співпадіння
			{
				if(search.contains(" " + Reverse(word) + " ") && !word.isEmpty())
				{
					if(!OneWord)
					{
						System.out.println("\n+---------------+---------------+");
						AddTable("Слово", "Обернене");
						System.out.println("+---------------+---------------+");
					}
					AddTable(word, Reverse(word));
					OneWord = true;
				}
				word = "";
			}
		}
		if(!OneWord)
			System.out.println("\nСпівпадінь не знайдено!");
		
		if (debug==true)System.out.println("\n(("+date.toString()+") Функція 'GetWords' закінчила роботу.)");
	}
	
	public static void PrintText(String text)
	{
		if (debug==true)System.out.println("\n(("+date.toString()+") Викликана фукція 'PrintText'. " +"\nВхідні данні: text="+text+")");
		if(text.length() == 0)
		{
			System.out.println("\n\nВаш текст пустий!" + text);
			if (debug==true)System.out.println("\n(("+date.toString()+") Функція 'PrintText' закінчила роботу )");
		}
		else
		{
			System.out.println("\n\nВаш текст: "+text);
			if (debug==true)System.out.println("\n(("+date.toString()+") Функція 'PrintText' закінчила роботу )");
		}
	}
	
	public static void WhatsNew() {
		// TODO Auto-generated method stub
		System.out.println("\nЛабораторна робота #4.\n"
						  +"- Додана підтримка команд -h (-help) та -d (debug).");
	}
	
	
	private static void AddTable(String word, String reverse) { 
		System.out.println("| " + word + Spacer(word, 14) + "| " + reverse + Spacer(reverse, 14) +"|");
		System.out.println("+---------------+---------------+");
		
	}
	
	private static String Spacer(String word, int a) {
		String res = "";
		for(int i = 0; i < a - word.length(); i++)
			res += ' ';
		return res;
	}

	private static String Reverse(String word) {
		String rev = "";
		for(int i = word.length() - 1; i >= 0; i--)
		{
			rev += word.charAt(i);
		}
		return rev;
	}

		
}
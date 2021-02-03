package ua.khpi.oop.Fediukina_03;

import java.util.Scanner;

public class Main 
{
	public static Scanner in = new Scanner(System.in);
	public static void main(final String[] args) 
	{
		System.out.print("Введіть ваш текст: ");
		String s1 = in.nextLine() + " ";
		s1 = s1.toLowerCase();
		
		
		StringBuilder text = new StringBuilder(" "+ s1 + " "); //для редагування
		for(int i = 0; i < text.length(); i++) //заміна зайвих символів на пробіл
		{
			if(text.charAt(i) < 'a' || text.charAt(i) > 'z')
				text.setCharAt(i, ' ');
		}
		
		String f = text.toString();
		boolean OneWord = false;
		String word = "";
		for(int i = 0; i < text.length(); i++) // пошук слів
		{
			if(text.charAt(i) != ' ')
				word += text.charAt(i);
			else //якщо кінец слова - обертаємо його та шукаємо співпадіння
			{
				if(f.contains(" " + Reverse(word) + " ") && !word.isEmpty())
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
	}
	
	private static void AddTable(String word, String reverse) { //додавання в таблицю слів
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
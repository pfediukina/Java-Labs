package ua.khpi.oop.Fediukina_05;

public class Helper {
	
	public static Container GetWords(Container c)
	{
		Container res = new Container();
		
		String s = c.toString();
		
		if(s.isEmpty())
		{
			System.out.println("\n\nКонтейнер пустий!");
			return res;
		}
		
		StringBuilder text = new StringBuilder(" "+ s + " "); //для редагування
		String source = text.toString();
		for(int i = 0; i < text.length(); i++) //заміна зайвих символів на пробіл
		{
			if(text.charAt(i) < 'a' || text.charAt(i) > 'z')
				text.setCharAt(i, ' ');
		}
		res.clear();
		String word = "", temp;
		for(int i = 0; i < text.length(); i++) // пошук слів
		{
			if(text.charAt(i) != ' ')
				word += text.charAt(i);
			else //якщо кінец слова - обертаємо його та шукаємо співпадіння
			{
				if(source.contains(" " + Reverse(word) + " ") && !word.isEmpty())
				{
					temp = word + Spacer(word, 14) + "| " + Reverse(word) + Spacer(Reverse(word), 14) +"\n";
					res.add(temp);
				}
				temp = "";
				word = "";
			}
		}
		return res;
		
	}
	
	public static void PrintText(String text)
	{
		if(text.length() == 0)
		{
			System.out.println("\n\nВаш текст пустий!" + text);
		}
		else
		{
			System.out.println(text);
		}
	}
	
	/*private static void AddTable(String word, String reverse) { 
		System.out.println("| " + word + Spacer(word, 14) + "| " + reverse + Spacer(reverse, 14) +"|");
		
	}*/
	
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
package ua.khpi.oop.Fediukina_06;

public class Helper
{

    //static functions
    public static  boolean  ContainerCheck(char text)
    {
        return ( text>64&&text<91)||( text>96&&text<=123)||text==32||text==44;
    }

    public static void PrintLine(String text)
    {
    	System.out.println("\n\nВаш текст: "+text);
    }

    public static void PrintNewLine(String text)
    {
    	System.out.println("\n\nРезультат: "+text);
    }
    public static void Task6 (Container text)
    {
    	String s = text.toString();
		
		if(s.isEmpty())
		{
			System.out.println("\n\nКонтейнер пустий!");
			return;
		}
		
		StringBuilder txt = new StringBuilder(" "+ s + " "); //для редагування
		String source = txt.toString();
		for(int i = 0; i < txt.length(); i++) //заміна зайвих символів на пробіл
		{
			if(txt.charAt(i) < 'a' || txt.charAt(i) > 'z')
				txt.setCharAt(i, ' ');
		}
		String word = "", temp;
		for(int i = 0; i < txt.length(); i++) // пошук слів
		{
			if(txt.charAt(i) != ' ')
				word += txt.charAt(i);
			else //якщо кінец слова - обертаємо його та шукаємо співпадіння
			{
				if(source.contains(" " + Reverse(word) + " ") && !word.isEmpty())
				{
					temp = word + Spacer(word, 14) + "| " + Reverse(word) + Spacer(Reverse(word), 14);
					System.out.println(temp);
				}
				temp = "";
				word = "";
				
			}
		}
    	
    	/*
   	 	String temp=new String();
   	 	String s=new String(text.toString());
		boolean spaise=false;
		for (int i=0;i<s.length();i++)
		{
			if (Helper.ContainerCheck(s.charAt(i)))
			{
				if (s.charAt(i)==32) spaise=true;
				else 
				{
					if(s.charAt(i)==44)
				{
				    temp=temp+s.charAt(i) ;
				    spaise=true;
				} 
				else if(spaise==true) 
				{  
					temp =temp+" "+s.charAt(i);
					spaise=false;
				}
					else temp =temp+s.charAt(i);
				}
			}         
		   
		} 
		text.clear();
		text.add(temp);
		return text;*/
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
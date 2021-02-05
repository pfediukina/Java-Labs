package ua.khpi.oop.Fediukina_06;
import java.util.Scanner;

public class Console {
	public static Scanner in = new Scanner(System.in);
	public static Serializator serializator=new Serializator();
	public static int dialog()
	{
		System.out.print("\n\n Оберіть команду:"
		+"\n*1-вивести поточнi записанi даннi"
		+"\n*2 -Додати данні"
		+"\n*3 -виконати основне завдання"
		+"\n*4 - сортувати"
		+"\n*5 - пошук"
		+"\n*6 - зберегти дані(save)"
		+"\n*7 - завантажити дані(load)"
		+"\n*9 (del)-очистити данi"
		+"\n*0 (exit)-вийти"
		+"\n\nВаша команда: ");
		
		return in.nextInt();

	}

	public static void Menu() 
	{
		Container s=new Container();

		while(true)
		{

			int k=dialog();
			try {
				switch(k)
				{
				case 1: Helper.PrintLine(s.toString());
	break;
				case 2:
					System.out.print("Введіть ваш текст: ");
					in.nextLine();
					s.add(in.nextLine());
					break;
				case 3: Helper.Task6(s);
				break;
				case 4: s.Sort(s);
				break;
				case 5 : s.posuk(s); break;
				case 6 :
					System.out.print("\n\nЗбереження даних:"+ serializator.serialization(s));
					break;
				case 7 : s=serializator.deserializtion();
				break;
				case 8 :s.clear();
				break;
				case 0 :return ; 

				}
			} catch(Exception e) {
			System.out.print("\n\n\nЩось пішло не так. Помилка виправлена\n\n");}
		}
	}

}
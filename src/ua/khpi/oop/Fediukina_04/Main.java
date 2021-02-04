package ua.khpi.oop.Fediukina_04;

public class Main 
{	
	static String text = "";
	
	public static void main(final String[] args) {	
		if(args.length == 0)
			Menu("");
		else
			Menu(args[0]);  
	}
	
	private static void Menu(String operating_mode) {
		
		String command = null;
		
		if (operating_mode.equals("-debug")||operating_mode.equals("-d") ) {	
			Helper.debug=true;	
		}
		
		else if (operating_mode.equals("-help")|| operating_mode.equals("-h") )  { 
			Helper.help = true;
		}
		
		if (Helper.debug==true) 
			System.out.println("\n("+Helper.date.toString()+") Виклик функції 'Menu' )"); 
		
		
		while(true)
		{
			Helper.Help();
			command = Helper.GetText("Введіть вашу команду: ");
		
			switch(command)
			{
			case "1": Helper.PrintText(text); break;//вивести текст обробки
			case "2": text = Helper.GetText("Введіть ваш текст: "); break;//записати текст
			case "3": Helper.GetWords(text); break;//основне завдання
			case "4": ClearData(); break;//очистити данні
			case "5": { //допомога
				Helper.help = true; 
				Helper.Help(); 
				Helper.help = false;
				break;
			}
			case "0": //вихід
				if (Helper.debug==true)System.out.println("\n(("+Helper.date.toString()+") Програма завершує роботу)");
				return;
			default : System.out.println("Unknown command " + command); break;
			}
		}
			
	}
	private static void ClearData() {
		text = "";
	}
}
package ua.khpi.oop.Fediukina_08;

import java.io.File;
import java.util.Scanner;

public class Console{
	public static Scanner in = new Scanner(System.in);
	public static int MenuText()
	{
		System.out.println(   "\nКоманди:\n"
				+ "1. Вивести данні\n"
				+ "2. Додати\n" 
				+ "3. Змінити\n" 
				+ "4. Пошук\n"
				+ "5. Сортування\n"
				+ "6. Зберегти\n"
				+ "7. Завантажити\n"
				+ "8. Очистити\n"
				+ "0. Завершити роботу");
		System.out.print("Введіть вашу команду: ");
		return in.nextInt();
	}
	public static String SerMenu()
	{
		int comm;
		File file= new File("C:/Users/POLINA/Documents");
		do {
			System.out.println("\nЗберегти:\n"
					+ "1. Перейти в директорію\n"
					+ "2. Перейти назад(диреторія)\n" 
					+ "3. Файли директорії\n"  
					+ "4. Перейти за адресою\n" 
					+ "5. Зберегти\n"
					+ "0. Назад");
			System.out.print(file.getPath() + "  ");
			comm = Main.in.nextInt();
			switch (comm) {
			case 1: {
				String a = null;
				System.out.print("Введіть назву папки: ");
				while(a == null || a.isEmpty())
					a = Main.in.nextLine();
				File file2 = new File(file.getPath() + a);
				if(file2.isDirectory() == false)
				{
					System.out.println("\nПапка не існує або є файлом!");
				}
				else
				{
					file = file2;
					System.out.println("\nВи перейшли до  " + file.getPath());
				}
				break;
			}
			case 2:{
				if(file.getParentFile() == null)
				{
					System.out.println("\nДиректорія не має кореневої папки!");
				}
				else
					file = file.getParentFile();
				break;
			}
			case 3: {
				if(file.listFiles() == null)
				{
					System.out.printf("Директорія порожня!");
					break;
				}
				int a = 0;
				for (File file2 : file.listFiles())
				{
					if (a%5==0) System.out.print("\n"); 
					a++;
					System.out.printf("%25s  ",file2.getName());
				}
				break;
			}
			
			case 4:
			{
				String a = null;
				System.out.print("Введіть назву папки: ");
				while(a == null || a.isEmpty())
					a = Main.in.nextLine();
				File file2 = new File(a);
				if(file2.isDirectory() == false)
				{
					System.out.println("\nПапка не існує або є файлом!");
				}
				else
				{
					file = file2;
					System.out.println("\nВи перейшли до  " + file.getPath());
				}
				break;
			}
			
			case 5: 
			{
				String a = null;
				System.out.print("Введіть назву файлу: ");
				while(a == null || a.isEmpty())
					a = Main.in.nextLine();
				String b = file.getPath() + "/" + a;
				return b;
			}
			default: return null;
			}
		}while(comm >= 1 && comm <=5);
		return file.getPath();
	}
	
	public static String DeserMenu()
	{
		int comm;
		File file= new File("C:/Users/POLINA/Documents");
		do {
			System.out.println("\nЗавантажити:\n"
					+ "1. Перейти в директорію\n"
					+ "2. Перейти назад(диреторія)\n" 
					+ "3. Файли директорії\n"  
					+ "4. Перейти за адресою\n" 
					+ "5. Завантажити\n"
					+ "0. Назад");
			System.out.print(file.getPath() + "  ");
			comm = Main.in.nextInt();
			switch (comm) {
			case 1: {
				String a = null;
				System.out.print("Введіть назву папки: ");
				while(a == null || a.isEmpty())
					a = Main.in.nextLine();
				File file2 = new File(file.getPath() + a);
				if(file2.isDirectory() == false)
				{
					System.out.println("\nПапка не існує або є файлом!");
				}
				else
				{
					file = file2;
					System.out.println("\nВи перейшли до  " + file.getPath());
				}
				break;
			}
			case 2:{
				if(file.getParentFile() == null)
				{
					System.out.println("\nДиректорія не має кореневої папки!");
				}
				else
					file = file.getParentFile();
				break;
			}
			case 3: {
				if(file.listFiles() == null)
				{
					System.out.printf("Директорія порожня!");
					break;
				}
				int a = 0;
				for (File file2 : file.listFiles())
				{
					if (a%5==0) System.out.print("\n"); 
					a++;
					System.out.printf("%25s  ",file2.getName());
				}
				break;
			}
			
			case 4:
			{
				String a = null;
				System.out.print("Введіть назву папки: ");
				while(a == null || a.isEmpty())
					a = Main.in.nextLine();
				File file2 = new File(a);
				if(file2.isDirectory() == false)
				{
					System.out.println("\nПапка не існує або є файлом!");
				}
				else
				{
					file = file2;
					System.out.println("\nВи перейшли до  " + file.getPath());
				}
				break;
			}
			
			case 5: 
			{
				String a = null;
				System.out.print("Введіть назву файлу: ");
				while(a == null || a.isEmpty())
					a = Main.in.nextLine();
				File file2 = new File(file.getPath() + "/" + a + ".xml");
				if(file2.exists())
				{
					String b = file.getPath() + "/" + a + ".xml";
					return b;
				}
				else
				{
					System.out.println("\nФайл не існує!");
				}
			}
			default: return null;
			}
		}while(comm >= 1 && comm <=5);
		return file.getPath();
	}
}
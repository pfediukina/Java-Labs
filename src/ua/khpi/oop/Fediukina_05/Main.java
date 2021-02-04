package ua.khpi.oop.Fediukina_05;

import java.util.Scanner;

public class Main {
	 
	public static Scanner in = new Scanner(System.in);
	public static void main(final String[] args) {
    	 
		System.out.print("Введіть ваш текст: ");
		Container s = new Container();
		String s2 = new String(in.nextLine());
		s.add(s2);
		//<String> it = s.iterator(); 
		System.out.println("Результат: ");
		Helper.PrintText(s.toString());
		System.out.print("\n");
		s = Helper.GetWords(s);
		Helper.PrintText(s.toString());
        /*System.out.print("\n ¬ив≥д через iтератор(for each):");
        for ( var x: s.m_data)
        	System.out.print(x);*/
    }
}
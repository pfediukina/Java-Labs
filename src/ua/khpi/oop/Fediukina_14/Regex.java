package ua.khpi.oop.Fediukina_14;

import java.util.regex.*;

public class Regex {

	public static boolean Name(String name){
		Pattern p = Pattern.compile("^[A-Z - ][a-z - ]{1,15}$");
		Matcher m = p.matcher(name);
		return m.matches();
	}
}
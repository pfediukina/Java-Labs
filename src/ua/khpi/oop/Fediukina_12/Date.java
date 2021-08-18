package ua.khpi.oop.Fediukina_12;


public class Date implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public int day = 01;
	public int month = 01;
	public int year = 1900;
	
	public Date() {
		this.day=01;
		this.month=01;
		this.year=1900;
	}
	
	public Date clone()
	{
		Date a = new Date();
		a.day = day;
		a.month = month;
		a.year = year;
		return a;
	}
	
	public String string() {
		String temp = Integer.toString(this.day) + "." + Integer.toString(this.month) + "." + Integer.toString(this.year);
		return temp;
	}
}

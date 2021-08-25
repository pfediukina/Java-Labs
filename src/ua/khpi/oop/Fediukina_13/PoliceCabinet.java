package ua.khpi.oop.Fediukina_13;

import java.util.Scanner;

	 
public class PoliceCabinet implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name; /// им'я
	private String surname; /// прізвище
	private String patronymic; /// по-батькові
	private Date birthday; // дата народження
	private Date DatesOfConvictions[]; /// дати судимостей
	private Date DateOfLastImprisonment; /// дата останнього позбавлення волі
    private Date DateOfDismissal; /// дата останнього звільнення

    private static Scanner in = new Scanner(System.in);
    public PoliceCabinet() {
		this.name = "Empty";
		this.surname = "Empty";
		this.patronymic = "Empty";
		this.birthday = new Date();
		this.DatesOfConvictions = new Date[128];
		this.DateOfLastImprisonment = new Date();
		this.DateOfDismissal = new Date();
	}
	
    public void setName(String name)               						{this.name = name;}
    public void setSurname(String surname)       						{this.surname = surname;}
	public void setPatronymic(String patronymic)         				{this.patronymic = patronymic;}
	public void setDateOfBirth(Date birthday)   						{this.birthday = birthday;	}
	public void setDateOfConviction(Date dateOfConviction, int number)  {this.DatesOfConvictions[number] = dateOfConviction;}
	public void setDatesOfConvictions(Date[] datesOfConvictions )       {this.DatesOfConvictions = datesOfConvictions;}
	public void setDateOfLastImprisonment(Date dateOfLastImprisonment) 	{this.DateOfLastImprisonment = dateOfLastImprisonment;}
	public void setDateOfDismissal(Date dateOfDismissal)           		{this.DateOfDismissal = dateOfDismissal;	}
	
	public String getName()               								{return this.name; }
    public String getSurname()       									{return this.surname; }
	public String getPatronymic()					     				{return this.patronymic; }
	public Date getDateOfBirth()   										{return this.birthday; }
	public Date getDateOfConviction(int number)         				{return this.DatesOfConvictions[number]; }
	public Date[] getDatesOfConvictions()       						{return this.DatesOfConvictions;}
	public Date getDateOfLastImprisonment() 							{return this.DateOfLastImprisonment;}
	public Date getDateOfDismissal()          							{return this.DateOfDismissal;}
	//public void setIndexDatesOfConvictions(int size) {this.IndexDatesOfConvictions=size-1;}
	
	public void print(String num)
	{
		String a = "";
		for(int i = 0; getDateOfConviction(i) != null && i < DatesOfConvictions.length; i++)
			a = DatesOfConvictions[i].string();
		/*String a = "";
		if(DatesOfConvictions[i - 1 < 0 ? 0 : i - 1] != null)
		{
			System.out.println("Hello");
			a = DatesOfConvictions[i - 1 < 0 ? 0 : i - 1].string();
		}*/
		String temp = new String();
		if(!num.isEmpty()) temp = "| " + num + spacer(num, 3);
		temp += 	"| " + name + spacer(name, 14)  +
				"| " + surname + spacer(surname, 14) +
				"| " + patronymic + spacer(patronymic, 14)  +
				"| " + birthday.string() + spacer(birthday.string(), 14) +
				"| " + a + spacer(a, 14)  +
				"| " + DateOfLastImprisonment.string() + spacer(DateOfLastImprisonment.string(), 14) +
				"| " + DateOfDismissal.string() + spacer(DateOfDismissal.string(), 13) +  " |";
		System.out.println(temp);
		
	}
	
	private String spacer(String word, int space) {
		String res = "";
		int length = word.isEmpty() ? 0 : word.length();
		for(int i = 0; i < space - length; i++)
			res += ' ';
		return res;
	}
	
	public void set()
	{
		String temp = "";
		PoliceCabinet a = this;
		do
		{
			System.out.print("\nВведіть ім'я: ");
			temp = in.nextLine();
		} while (Regex.Name(temp)==false);
		//System.out.print("\nName: " + temp);
		a.setName(temp);
		do
		{
			System.out.print("\nВведіть прізвище: ");
			temp = in.nextLine();
		} while (Regex.Name(temp)==false);
		a.setSurname(temp);
		//System.out.print("SurN: " + temp);
		do
		{
			System.out.print("\nВведіть по-батькові: ");
			temp = in.nextLine();
		} while (Regex.Name(temp)==false);
		a.setPatronymic(temp);
		System.out.print("\nВведіть дата нарождення (день, місяць та рік): ");
		Date d = new Date();
		d.day = in.nextInt();
		d.month = in.nextInt();
		d.year = in.nextInt();
		a.setDateOfBirth(d.clone());
		
		
		System.out.print("\nВведіть кількість судимостей: ");
		int s = in.nextInt();
		for(int i = 0; i < s; i++)
		{
			System.out.print("\nВведіть день, місяць та рік: ");
			d.day = in.nextInt();
			d.month = in.nextInt();
			d.year = in.nextInt();
			a.setDateOfConviction(d.clone(), i);
		}
		System.out.print("\nВведіть дату останнього позбавлення волі (день, місяць та рік): ");
		d.day = in.nextInt();
		d.month = in.nextInt();
		d.year = in.nextInt();
		a.setDateOfLastImprisonment(d.clone());
		
		System.out.print("\nВведіть дату останнього звільнення (день, місяць та рік): ");
		d.day = in.nextInt();
		d.month = in.nextInt();
		d.year = in.nextInt();
		a.setDateOfDismissal(d.clone());
	}
	
	public PoliceCabinet clone()
	{
		PoliceCabinet res = new PoliceCabinet();
		res.name = this.name;
		res.surname = this.surname;
		res.patronymic = this.patronymic;
		res.birthday = this.birthday;
		res.DateOfDismissal = this.DateOfDismissal;
		res.DateOfLastImprisonment = this.DateOfLastImprisonment;
		res.DatesOfConvictions = this.DatesOfConvictions.clone();
		return res;
		
	}
}
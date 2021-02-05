package ua.khpi.oop.Fediukina_06;

import java.io.Serializable;
import java.util.Scanner;

public class Container implements Serializable {


private static final long serialVersionUID = 1L;
public static Scanner in = new Scanner(System.in);
private int size=0;
String[] m_data=new String[255];



public String toString() //повертає вміст контейнера у вигляді рядка
{
	if (size ==-1) {
		System.out.print("\nМасив пустий. Елементів немає. Попернуто null");
		return null;
	}
	String temp=new String();
	for (int i=0;i<size;i++)
		temp+=m_data[i];
	return temp;
}
	void add(String string) //додає вказаний елемент до кінця контейнеру;
	{
		if (size + 1 >= 255) return;
		//m_data	[size++]=string;
		String temp=new String();
		for (int i=0;i<string.length();i++)
		{
			if((char)string.charAt(i)!=32)
				temp+=string.charAt(i);
			else{
				m_data[size++]=temp+" ";
				temp=new String();
			}
			
		}
		m_data[size++]=temp+" ";
	}
	void clear()/// видаляє всі елементи з контейнеру;
	{
		while (size!=0)
				iterator().remove();
		
	}
	boolean remove (String string)// видаляє перший випадок вказаного елемента з контейнера;
	{
		if (size ==0) return false;
		for (int i=0;i<size;i++)
			if (m_data[i]==string)
				{ for (; i < size-1; i++)
					m_data[i]=m_data[i+1];
				this.m_data[--size] = null;
					return true;
				}
		
		return false;
	}
	
	int size()/// повертає кількість елементів у контейнері;
	{
		return this.size;
	}
	boolean contains(String string)/// повертає true, якщо контейнер містить вказаний елемент;
	{
	if (size ==0) return false;
	for (int i=0;i<size;i++)
			if (m_data[i]==string)
				return true;
	
	return false;
	}

	Object[] toArray() ///повертає масив, що містить всі елементи у контейнері;
	{
		return m_data;
	}
		boolean containsAll(Container container)/// повертає true, якщо контейнер містить всі елементи з зазначеного у параметрах;
		{
			if(container.size==size)
					if(container.m_data==m_data)
						return true;
			return false;
					
				
	}
	void posuk(Container container)//// помилку пошуку
	{
		if (container.size==0) {
			System.out.print("Масив пустий");
			return ;
		}
		System.out.print("Введіть шукане значення: ");
		String text=new String();
		text=in.nextLine();
		
		for (int i=0;i<size;i++)
			if (container.m_data[i].contains(text))
			{
				System.out.print("Элемент знайдено!");
				return ;
			}
		System.out.print("Позиція вашаго елемента: незнайдена");
		
		
	}
			
			
	public void Sort(Container k) {
		boolean pr; /// для проверки отсортирован ли массив
		do
		{
			pr = false;
			for (int i = 0; i < k.size()-1; i++)
				if (comparison (k.m_data[i] , k.m_data[i + 1])==1)
				{
					String temp=k.m_data[i];
					k.m_data[i]=k.m_data[i+1];
					k.m_data[i+1]=temp;
					pr = true;
				}
			
		} while (pr);
	}
			
	public void d_comparison(Container conteiner)
	{
		int a,b;
		while(true)
		{
			System.out.print("\nВведіть індекс першого елементу: ");
			a=in.nextInt();
			if (a<0||a>size-1) System.out.print("\nЕлементу з таким індексом неіснує. Спробуйте ще раз");
			else break;
		}
		while(true)
		{
				System.out.print("\nведіть індекс другого елементу: ");
				b=in.nextInt();
				if (b<0||b>size-1) System.out.print("\nЕлементу з таким індексом неіснує. Спробуйте ще раз");
				else break;
		}
		int temp =Container.comparison(conteiner.m_data[a],conteiner.m_data[b]);
		if (temp==1)System.out.print("Результат порівнянн: a>b" );
		else if (temp==-1)System.out.print("Результат порівнянн: a<b" );
		else System.out.print("Результат порівнянн: a=b");
	}

//@SuppressWarnings("unused")
	public static int comparison(String a,String b)
	{
		int len=0;
		if(a.length()<b.length())len=a.length();
		else len=b.length();
		for (int i=0;i<len;i++)
		{
			if (a.charAt(i)>b.charAt(i)) return 1;
			if (a.charAt(i)<b.charAt(i)) return -1;
		}
		if(a.length()<b.length())return -1;
		else if (a.length()>b.length()) return 1;
		return 0;
	}

	public Iterator<String> iterator() ///повертає ітератор відповідно до Interface Iterable.
	{
	return new m_Iterator();
	}
	
	public class m_Iterator implements Iterator<String>
	{
	
		int index = 0;
		public boolean hasNext() {
			if(index<size)
				return true;
			return false;
		}
		public String next()
		{
			return m_data [index++];
		}
		
		public void remove()
		{
			for (int i=index; i < size-1; i++)
				m_data[i]=m_data[i+1];
			m_data[--size] = null;
		
		
		//throw new UnsupportedOperationException("remove");
		}
		public String begin()
		{
			return m_data[0];
		}
		public String end()
		{
			return m_data[size];
		}
	}
}
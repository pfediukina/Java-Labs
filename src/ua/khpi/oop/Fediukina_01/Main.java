

package ua.khpi.oop.Fediukina_01;

public final class Main
{
	private static int a = 0x17; // номер в журнале
	private static int b = 660797853; //номер телефона
	private static int c = 0b110101; //последние цифры номера телефона в двоичной системе
	private static int d = 17255; //число из последних 4 чисел номера в восьмеричной системе
	private static int e = (a - 1) %26 + 1; //увеличенное на 1 значение остачи от деления на 26 номера студента уменьшенное на 1
	private static char s = (char)(e + 64); // номер английсокго алфавита в верхнем регистре, номер которого совпадает найденому ранее решению
			
	public static void main(final String[] args)
	{
		PrintNumber();
		SearchEvenNums(a);///перевірка на парність
		SearchEvenNums(b);///перевірка на парність
		SearchEvenNums(c);///перевірка на парність
		SearchEvenNums(d);///перевірка на парність
		SearchEvenNums(e);///перевірка на парність
        SearchEvenNums((int)s);///перевірка на парність
		
		
		
		NumberOfUnits(Integer.toBinaryString(a));
		NumberOfUnits(Integer.toBinaryString(b));
		NumberOfUnits(Integer.toBinaryString(c));
		NumberOfUnits(Integer.toBinaryString(d));
		NumberOfUnits(Integer.toBinaryString(e));
		NumberOfUnits(Integer.toBinaryString(s));
	}
	
	public static void PrintNumber()
	{
		System.out.println("\nЧисло, що відповідає номеру залікової книжки за допомогою шістнадцяткового літералу: " +  Integer.toHexString(a)
							+ "\nЧисло, що відповідає номеру мобільного телефона (починаючи з 380...) за допомогою десяткового літералу: " + b
							+ "\nЧисло, яке складається з останніх двох ненульових цифр номера мобільного телефону за допомогою двійкового літералу: " + Integer.toBinaryString(c) 
							+ "\nЧисло, яке складається з останніх чотирьох ненульових цифр номера мобільного телефону за допомогою вісімкового літералу:" + Integer.toOctalString(d)
							+"\nЧисло, збільшене на одиницю значення залишку від ділення на 26 зменшеного на одиницю номера студента в журналі групи: " + e
							+"\nСимвол англійського алфавіту в верхньому регістрі, номер якого відповідає знайденому раніше значенню: "+s);
		
	}
	
	static void SearchEvenNums(int p) ///перевірка на парність
    {
        int parni = 0;
        int neparni = 0;


        for(int temp = p; temp != 0; temp /= 10) {
            if (temp % 2 == 0) {
                ++parni;
            } else {
                ++neparni;
            }
        }

        System.out.println("\nВикористовуючи десятковий запис цілочисельного значення кожної змінної знайти і підрахувати кількість парних і непарних цифр: \nПарних: " + parni + "\nНепарних: " + neparni + "\nЧисло: " + p);
    }

    public static void NumberOfUnits(String str )///Двійковий запис цілочисельного значення кожної змінної кількість одиниць
    {

        int count = 0;
        for(int  i = 0;i<str.length();i++) {
        	char ch1 = str.charAt(i);
            if (ch1 == '1') {
               ++count;
          }
      }

        System.out.println("\nДвійковий запис цілочисельного значення кожної змінної кількість одиниць: " + count + "\nЧисло у двійкові системі: " + str);
    }
}
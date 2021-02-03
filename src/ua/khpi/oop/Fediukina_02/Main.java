package ua.khpi.oop.Fediukina_02;

import java.util.Scanner;

public final class Main 
{
	public static Scanner in = new Scanner(System.in);

    public static void main(final String[] args)
    {
    	//Task01();
    	Task02();
    	//Task03();
    	//Task04();
    	//Task05();
    	//Task06();
    	//Task07();
    	//Task08();
    	//Task09();
    	//Task10();
    }
    
    public static void Task01() //Знайти найбільший спільний дільник двох цілих позитивних чисел.
    {
        System.out.println("\nTask 01 (Знайти найбільший спільний дільник двох цілих позитивних чисел)");
        int number1, number2, res = -1;
        System.out.println("Вводити лише додатні чиcла. Від'ємне число буде переведено у додатнє.");
        System.out.print("Перше число: ");
        number1 = in.nextInt();
        System.out.print("Друге число: ");
        number2 = in.nextInt();
        if(number1 < 0) number1*=-1;
        if(number2 < 0) number2*=-1;
        for(int i = 1; i <= number1 && i <= number2; i++)
        {
        	if(number1 % i == 0 && number2%i == 0)
        		res = i;
        }
        System.out.println("Найбільший спільний дільник: "+ res);
    }
    
    public static void Task02() //Знайти суму цифр заданого цілого числа.
    {
        System.out.println("\nTask 02 (Знайти суму цифр заданого цілого числа)");
        System.out.print("Введіть число: ");
        int num=in.nextInt();
        if(num < 0) 
        	num*=-1;
        int sum = 0;
        while(num > 0)
        {
        	sum += (num % 10);
        	num /= 10;
        }
        System.out.println("Сума цифр: " + sum);
    }
    
    public static void Task03() //Знайти найбільшу цифру в десятковому запису цілочисельного значення.
    {
    	System.out.println("\nTask 03 (Знайти найбільшу цифру в десятковому запису цілочисельного значення)");
        System.out.print("Введіть число: ");
        int num = in.nextInt();
        int large = 0;
         
        while (num != 0) {
          if ( num % 10> large) large = num % 10;
            num /= 10;
        }
        System.out.println("Найбільша цифра: " + large);
    }
    
    public static void Task04() //Знайти позиції всіх найменших цифр в десятковому запису цілочисельного значення.
    {
    	System.out.println("\nTask 04 (Знайти позиції всіх найменших цифр в десятковому запису цілочисельного значення)");
        System.out.print("Введіть число: ");
        int num;
        num = in.nextInt();

        int k=0;
        String s = new String( Integer.toString(num));
        k = s.charAt(0);
        String pos = new String();
        for (int i=0 ; i < s.length(); i++)
        {
            if (k > s.charAt(i)){
                k = s.charAt(i);
                pos = Integer.toString(i + 1);
            }

            else if(k == s.charAt(i)) pos=pos+" "+ (i + 1);

        }
        System.out.println("Позиції всіх найменших цифр: " + pos);
    }
    public static void Task05() //Перевірити, чи є задане число простим (тобто не ділиться без залишку на жодні числа, крім себе і 1).
    {
    	System.out.println("\nTask 05 (Перевірити, чи є задане число простим (тобто не ділиться без залишку на жодні числа, крім себе і 1))");
        System.out.print("Введіть ваше число: ");
        int num = in.nextInt();
        int l = 0;
        for(int i = 2; i < num; i++)
        {
        	if(num % i == 0)
        	{
        		l = 1;
        		break;
        	}
        }
        System.out.println("Ваше число: " + (l == 1 ? "не просте" : "просте"));
    }
    public static void Task06() //Перевірити чи дорівнює сума перших трьох цифр сумі останніх трьох цифр в десятковому запису 6-значного цілого числа.
    {
    	
    	System.out.println("\nTask 06 (Перевірити чи дорівнює сума перших трьох цифр сумі останніх трьох цифр в десятковому запису 6-значного цілого числа)");
    	System.out.println("Введене випадкове число у якому 6 знаків:");


    	System.out.println("+---------+-------------+");
    	System.out.println("| Число   | Порівняння  |");
    	System.out.println("+---------+-------------+");
    	
    	for (int i=0;i<10;i++)
    	{
	    	int num = rand(100000, 999999);
	    	int a=num;
	    	int sum1 = 0;
	    	int sum2 =0;
	    	sum1= Sum(num, sum1);
	    	num/=1000;
	    	sum2= Sum(num, sum2);
	
	
	    	System.out.println("| "+a+"  |" + ( sum1 == sum2 ? " Дорівнює    " : " Не дорівнює ")+"|");
	    	System.out.println("+---------+-------------+");
    	}
    }
    public static int rand(int  min, int  max)
    {
    	return (int)(Math.random() * (max - min + 1) + min);
    }
    
    public static int Sum(int  num, int  sum)
    {
   	 	for (int i = 0; i < 3; i++) 
   	 	{
            sum += num % 10;
            num /= 10;
        }
   	 	return sum;
    }
    
    public static void Task07() //Перевірити чи рівні значення першої та останньої, а також другої та передостанньої цифри в вісімковому запису 4-значного цілого числа.
    {
    	
    	System.out.println("\nTask 07 (Перевірити чи рівні значення першої та останньої, а також другої та передостанньої цифри в вісімковому запису 4-значного цілого числа)");
    	System.out.print("Введіть число: ");

    	int num = in.nextInt();
    	float a=0;
    	a=Convert(num,0,8);
    	num=(int)a/10;
    	System.out.println("Восьмирічнe число: " + num);

    	String s=new String (String.valueOf(num));

    	System.out.print("\n");
    	if(s.charAt(0)==s.charAt(s.length()-1)) System.out.println("\nЗначення першої та останньої- рівні");
    	else System.out.println("Значення першої та останньої- не рівні");

    	if(s.charAt(1)==s.charAt(s.length()-2)) System.out.println("\nЗначення другог та передостанього числа - рівні");
    	else System.out.println("Значення другого та передостанього числа - не рівні");
    }
    
    
    
    public static float Convert(int N,float a,int b)// конвертування із однієї системи в іншу
    {
    	if (N != 0)
    	{
    		a=Convert(N / b, a / 10 + (N % b), b);
    		a = a * 10;
    		return a;
    	}
    	else  return  a;
    }
    
    public static void Task08() //Знайти суму всіх парних і суму всіх непарних цифр в десятковому запису 8-значного цілого числа.
    {
    	System.out.println("\nTask 08 (Знайти суму всіх парних і суму всіх непарних цифр в десятковому запису 8-значного цілого числа)");
    	System.out.print("Введіть число: ");
    	
    	int num = in.nextInt();

        int sumP = 0,sumN=0;
        while (num != 0) 
        {
            if(num % 2==0)
            	sumP += num % 10;
            else 
            	sumN += num % 10;
            num /= 10;
        }
        System.out.println("Сума парних: "+sumP + "\nСума непарних: "+sumN);
    }
    
    public static void Task09() //Підрахувати кількість цифр, що відображаються за допомогою латинських букв в шістнадцятковому запису 10-значного цілого числа.
    {
    	System.out.println("\nTask 09 (Підрахувати кількість цифр, що відображаються за допомогою латинських букв в шістнадцятковому запису 10-значного цілого числа)");
    	System.out.print("Введіть число: ");
    	
    	int num = in.nextInt();

    	String s=new String(Integer.toHexString((int)num));
    	System.out.print("Шіснадцятирічне число: "+s);

    	int count=0;
    	for(int i=0;i<s.length();i++)
    	if((96 < (char)s.charAt(i)&&(char)s.charAt(i) < 102))
    	count++; 
    	System.out.print("\n");
    	System.out.println("Kількість цифр, що відображаються за допомогою латинських букв : "+count);
    }
    
    public static void Task10() //Знайти кількість комбінацій 01 та 10 в двійковому запису цілого числа.
    {
    	System.out.println("\nTask 10 (Знайти кількість комбінацій 01 та 10 в двійковому запису цілого числа)");
    	System.out.print("Введіть число: ");
    	int num = in.nextInt();
        String s = Integer.toBinaryString(num);
        long a = Integer.parseInt(s);
        System.out.println("Двійкове число: " + a);
        int count=0;
        for(int i=0;i<s.length()-1;i++)
        {
        	if((s.charAt(i)=='0'&&s.charAt(i+1)=='1')||(s.charAt(i)=='1'&&s.charAt(i+1)=='0'))
        		count++;
        }
        System.out.print("\nKількість комбінацій: " + count);
    }

}

package ua.khpi.oop.Fediukina_08;

public class Container implements java.io.Serializable {
	
	public   int index ;
	public   PoliceCabinet[] m_data ;
	
    public Container()
    {
    	this.m_data=new PoliceCabinet[255];
    	index=-1;
    }
    
    
    public PoliceCabinet setInPoliceCabinet(int index)
	{
		return m_data[index];
	}	
     	
	 
    public Container( PoliceCabinet[] rhs)
	{
    	  index=-1;
			m_data=rhs;
 
	}
    public Container(Container rhs)
	{
		for (int i = 0; i < rhs.index; i++) {
			m_data[i] = rhs.m_data[i];
		}
		this.index = rhs.index;
	}
	

     public  void add() 
	 {
    	  System.out.print("\nЯк додати:\n"
    	  		+ "1. Сгенерувати\n"
    	  		+ "2. Ввести данні\n"
    	  		+ "0. Назад\n"
    	  		+ "Ваша команда: ");
    	  int command = Main.in.nextInt();
    	  switch(command)
    	  {
    	  case 1:
    	  {
    		if (index + 1 >= 255) return;
  			m_data[++index] = new PoliceCabinet();
  			System.out.println("\nДодано");
  			break;
    	  }
    	  case 2: 
    	  {
    		  if (index + 1 >= 255) return;
    		  PoliceCabinet p = new PoliceCabinet();
    		  p.set();
    		  m_data[++index]  = p;
    		  break;
    	  }
    	  default: return;
    	  }
	    		 
	  }
     public void  clear()
	 {
             while (index!=-1)
        	 iterator().remove();
      
     }

     public void print()  
 	{
    	if(index == -1)
    	{
    		System.out.println("\nКонтейнер порожній!");
    		return;
    	}
 		for(int i = 0; i < size(); i++)
 		{
 			m_data[i].print(Integer.toString(i + 1));
 		}

 	}
    public int size()
	{
    	return this.index+1;
	}
    
    public void set() {
    	 System.out.print("\nВведіть індекс (0 - вихід): ");
    	 int command = Main.in.nextInt();
    	 command --;
    	 if (command > -1 && command < this.index+1)
    	 {
    		 m_data[command].set();
    	 }
    	 else
    		 System.out.println("\nПомилка! Невірний індекс! ");
		
	}
	 public void search()
	 {
		 if (index==-1) {
			 System.out.print("Контейнер порожній");
			 return ;	
		 }
		 String text=new String();
		 System.out.print("Пошук:\n"+
		                  "  1. Ім'я\n"+
				          "  2. Прізвище\n"+
		                  "  3. По-батькові\n"+
				          "  4. Index\n"+
		                  "  0. Вихід\n" +
				          "Ваша команда: ");
		 int a=Main.in.nextInt();
                 switch(a)
                 {
                 case 1:
            		 System.out.print("Введіть ім'я: ");
           			 text=Main.in.next();
         			
         	        for (int i=0;i<index+1 ;i++)
         	          if (m_data[i].getName().equals(text))    
         	        	  {
         	        	  System.out.println("\nПозиція вашого елемента: "+ (i + 1) +"\n");
         	        	  m_data[i].print(Integer.toString(i + 1));
         	        	  return ;
         	        	  }
         	        System.out.println("\nВаш елемент не знайденo");
                	 break;
                 case 2:
            		 System.out.print("Введіть прізвище: ");
         			 text=Main.in.next();
         			
         	        for (int i=0;i<index+1 ;i++)
         	          if (m_data[i].getSurname().equals(text))    
         	        	  {
         	        	  System.out.println("\nПозиція вашого елемента: "+(i + 1)+"\n");
         	        	  m_data[i].print(Integer.toString(i + 1));
         	        	  return ;
         	        	  }
         	        System.out.println("\nВаш елемент не знайденo");
                	 break;
                 case 3:
            		 System.out.print("Введіть по-батькові: ");
              		 text=Main.in.next();
         			
         	        for (int i=0;i<index+1 ;i++)
         	          if (m_data[i].getPatronymic().equals(text))    
         	        	  {
         	        	  System.out.println("\nПозиція вашаго елемента: "+(i + 1)+"\n");
         	        	  m_data[i].print(Integer.toString(i + 1));
         	        	  return ;
         	        	  }
         	        System.out.println("\nВаш елемент не знайденo");
                	 break;
                 case 4:
            		 System.out.print("Введіть індекс: ");
              		 a=Main.in.nextInt();
                	 if ((a - 1) > -1 && (a-1) < this.index+1)
                	 {
        	        	  System.out.println("\nПозиція вашого елемента: "+ a +"\n");
        	        	  if(m_data[a - 1] != null)
        	        		  m_data[a - 1].print(Integer.toString(a));
        	        	  else
        	        		  System.out.println("\nПомилка! Невірне число а = " + a);
        	        	  return ;
                	 }
                	 System.out.println("\nВаш елемент не знайденo!");
                	 break;
                default: return;
                 }
	        		
	 }
	 
	 
	 public void Sort()
	 {
		 if (index==-1) {
			 System.out.print("Контейнер порожній");
			 return ;	
		 }
		// String text=new String();
		 System.out.print("Сортування:\n"+
		                  "  1. Ім'я\n"+
				          "  2. Прізвище\n"+
		                  "  3. По-батькові\n"+
				          "  0. Вихід\n" +
				           "Ваша команда: ");
			 
	 		 int a= Main.in.nextInt();
			 boolean pr;			
				do
				{
					pr = false;
			          switch(a)
	                 {
	                 case 1:
	                	 for (int i = 0; i < index; i++)	
	                		
	   					if (comparison(m_data[i].getName() , m_data[i + 1].getName())==1) { swap(i); pr = true; }  
	                 	 break;
	                 case 2:
	      				for (int i = 0; i < index; i++)
	      					if (comparison(m_data[i].getSurname() , m_data[i + 1].getSurname())==1) { swap(i); pr = true; }
	   					
	            	 break;

	                 case 3:
	      				for (int i = 0; i < index; i++)	
	      					if (comparison(m_data[i].getPatronymic() , m_data[i + 1].getPatronymic())==1) { swap(i); pr = true; }
	   					 
	            	 break;
	            	 default: return;
	                 }
				} while (pr);

				System.out.print(" *Сортування завершено ");
		 }


	 public    void swap(int i) 
	  {
	     PoliceCabinet temp;
	     temp = m_data[i];
	     m_data[i] = m_data[i + 1];
	     m_data[i + 1] = temp;
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
////////////////////////////////////////////////////////////////////////////////////////////////////	  
	 public Iterator<String> iterator() ///ïîâåðòàº ³òåðàòîð â³äïîâ³äíî äî Interface Iterable.
	 {
		 return new m_Iterator();
	 }
	 
	 public class m_Iterator implements Iterator<String>
	 {

		    int ix = 0;
			public boolean hasNext() {
			if(ix<this.ix+1) 
				return true;
			    return false;
			}
			public PoliceCabinet next()
			{
			return m_data [ix++];	
			
			}
			public void remove()
			{
				 
		          for (int i=ix; i < index-1; i++)
		  	    		  m_data[i]=m_data[i+1];
		  	             m_data[index--] = null;
		          
		  	            
		  	      
				//throw new UnsupportedOperationException("remove");
		    }
			public PoliceCabinet begin()
			{
				return m_data[0];
			}
			public PoliceCabinet end()
			{
				return m_data[index];
			}
			
		 
	 }
}
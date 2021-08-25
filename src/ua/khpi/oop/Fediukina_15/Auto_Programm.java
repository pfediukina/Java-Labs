package ua.khpi.oop.Fediukina_15;

public class Auto_Programm {


	 
	public static Serializator<ContainerList<PoliceCabinet>> serializator=new Serializator<ContainerList<PoliceCabinet>>();

	    	@SuppressWarnings("unchecked")
			public static void Menu() 
	    	{
	    		ContainerList<PoliceCabinet> сont = new ContainerList<PoliceCabinet>();
	       		 		    		 
	            try {            
	    		  
	              сont=serializator.deserializtion();
	    		  List<PoliceCabinet> h = сont.getHead();
	    		  System.out.println("");
	    		  int num = 1;
	    		  while(h.next != null)
	    		  {
	    			  h = h.next;
	    			  h.num.print(Integer.toString(num));
	    			  num++;
	    		  }
	    		  сont.clear();
	    		}catch(Exception e)	  {	 System.out.println("Ошибка");
	    		}
	          
	        
	  }

}

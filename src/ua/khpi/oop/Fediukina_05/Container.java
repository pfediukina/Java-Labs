package ua.khpi.oop.Fediukina_05;

public class Container {
	
	static int size = 0;
	
	String[] m_data = new String[256];
	
	public String toString()
	{
		if(size == 0) return null;
		
		 String temp= new String();
		 temp = " ";
		 for(int i = 0; i < size; i++)
			 temp += m_data[i];
		 return temp;
	}
	
	public void add(String string)
	{
		if (size + 1 >= 255) return;
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
	
	public void clear()
	{
        while (size!=0)
       	iterator().remove();
     
    }
	
	public boolean remove (String string)
	 {
		 if (size ==0) return false;
	        for (int i=0;i<size;i++)
	      if (m_data[i]==string)    
	      { 
	    	  for (; i < size-1; i++)
	    		 m_data[i]=m_data[i+1];
	             m_data[--size] = null;
	             return true;
	      }

	        return false;
	 }
	
	public int size()
	 {
		 return size;
	 }
	public boolean contains(String string)
	 {
		 if (size ==0) return false;
	        for (int i=0;i<size;i++)
	          if (m_data[i]==string)    
	             return true;
	      
	        return false;
	 }
	 Object[] toArray() 
	 {
		 return m_data;
	 }
	 boolean containsAll(Container container)
	 {
		 if(container.size() == this.size()) 
			 if(container.toString() == this.toString())
				 return true;
			 return false;		 
	 }
	
	public Iterator<String> iterator() 
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
		 
	 }
}
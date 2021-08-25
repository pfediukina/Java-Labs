package ua.khpi.oop.Fediukina_13;

import java.io.Serializable;

public class List<T extends  Serializable>  {
	
   public T num;
   @SuppressWarnings("rawtypes")
public List next;

    public List(T n) {
        num = n;
        next = null;
    }
    
    public List() {}
}

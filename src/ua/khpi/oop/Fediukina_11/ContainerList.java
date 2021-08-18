package ua.khpi.oop.Fediukina_11;

import java.io.Serializable;

public  class ContainerList<T  extends Serializable> implements Iterator<T> {
	private List<T> current = new List<T>();
	private List<T> start = new List<T>();
	
	
	public ContainerList(){
		current.num = null;
		start.next = current;
		start.num = null;
	}
	
	@SuppressWarnings("unchecked")
	public void add(T temp) {
		if(current.num == null)
			current.num = temp;
		
		else
		{
			current.next = new List<T>();
			current = current.next;
			current.num = temp;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private List<T> getListByNum(int num)
	{
		List<T> temp = new List<T>();
		temp = start.next;
		for(int i = 0; i < num-1 && temp.next != null ; i++)
		{
			temp = temp.next;
		}
		if(temp.num == null) return null;
		return temp;
	}
	
	
	@SuppressWarnings("unchecked")
	public void delete(int num)
	{
		List<T> prev = getListByNum(num);
		if(prev == null) return;
		
		prev.next = prev.next.next;
		current = start.next;
		while(current.next != null)
		{
			current = current.next;
		}
	}
	
	public T change(int num)
	{
		List<T> temp = getListByNum(num);
		if(temp == null) return null;
		
		return temp.num;
	}
	
	@SuppressWarnings("unchecked")
	public void clear()
	{
		start.next = null;
		current = start.next;
	}
	
	public List<T> getHead() { return start; }
	

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PoliceCabinet next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}	
}
package ua.khpi.oop.Fediukina_09;

public interface Iterator<E> {
	
	public boolean hasNext();
	public PoliceCabinet next();
	public void remove();
}
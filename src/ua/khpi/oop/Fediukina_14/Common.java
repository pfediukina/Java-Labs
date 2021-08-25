package ua.khpi.oop.Fediukina_14;

public class Common {
	public static ContainerList<PoliceCabinet> List=new ContainerList<PoliceCabinet>();///container
	public static Boolean stop ; ///Flag status of interactive use of drinks (false - used; true- no)
	public static int TimeOut=0; ///TimeOut: if TimeOut=0 operating time is not limited otherwise limited by value
	public static int Choice=0; ///id process/thread
}

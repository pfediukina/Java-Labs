package ua.khpi.oop.Fediukina_15;

public class Processes extends Thread 
{
private static final double DIVIDER = 1_000_000;
	
	Processes()
	{
		 
		Thread.currentThread().setName("ProcessProcesses-"+Common.Choice);
		start();
		System.out.print("\n"+Thread.currentThread().getName()+" - çàê³í÷èâ ðîáîòó; \n");
		
	}
	@SuppressWarnings("deprecation")
	public void run() {
		 
		try {
			
		switch(Common.Choice)
		{
		 
		case 6:
			Common.stop = true;
			Thread t = new Thread ();
			 t.start();
			  
			for(;;)
			{
				Thread.sleep(10);
				if(Common.stop==false)break;
			}
	        if(Common.TimeOut!=0)
	        {
	        	Thread.sleep(Common.TimeOut);
	        	t.stop();
	        	System.out.print("ïðèìóñîâî çóïèíåíî");
	        }
	        break;
			case 9:Thread reg =  new Thread ();///time here
			long startReg = System.nanoTime();
			Thread.currentThread().setName("reg");
			reg.start();
					 
	        if(Common.TimeOut!=0)
	        {
	        	Thread.sleep(Common.TimeOut);
	        	reg.stop();
	        	System.out.print("ïðèìóñîâî çóïèíåíî");
	        }else reg.join();
			System.out.print("\n"+Thread.currentThread().getName()+" - çàê³í÷èâ ðîáîòó; "+"Òðèâàë³ñòü ðîáîòè: "+ (System.nanoTime() - startReg) / DIVIDER*1000+"\n");
			
			break;
			
			case 10: 
				Thread r=new Thread();
				
				Common.stop=true;
				r.start();
				for(;;)
				{
					Thread.sleep(10);
					if(Common.stop==false)break;
					
				}
		        if(Common.TimeOut!=0)
		        {
		        	Thread.sleep(Common.TimeOut);
		        	r.stop();
		        	System.out.print("ïðèìóñîâî çóïèíåíî");
		        		
		        }
				
			
			case 11: Thread clear= new Thread( Common.List::clear );///time here??
					clear.start();
			        if(Common.TimeOut!=0)
			        {
			        	Thread.sleep(Common.TimeOut);
			        	clear.stop();
			        	System.out.print("ïðèìóñîâî çóïèíåíî");
			        	
			        }
			break; 
			
			case 13:
				Thread d=new Thread() ;
				d.start();
				Common.stop=true;
				for(;;)
				{
					Thread.sleep(10);
					if(Common.stop==false)break;
				}
		        if(Common.TimeOut!=0)
		        {
		        	Thread.sleep(Common.TimeOut);
		        	d.stop();
		        	System.out.print("ïðèìóñîâî çóïèíåíî");
		        }
		        break;
			   		
		        
			}   
			}catch(Exception e)	  {	//for (int i=0;i<10;i++)System.out.println(" EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR EROR ");
				System.out.print("\n\n\nÒðàïèëàñü ïîìèëêà. Àëå òåïåð âñå äîáðå!!\n\n");
				System.out.println(e);}
			
			
		}
}

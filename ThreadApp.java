package inlämningsuppgift4;

//Ett program som loppar så länge den andra tråden lever (dvs ingen stop har inträffats)
public class ThreadApp
{
 
 public static void main (String args[])
 {
      int i=0; 		
			KnappLyssnare k= new KnappLyssnare();
			k.start();
			while(k.isAlive())
			{
			 try
			 {
			  Thread.sleep(1000);
			  System.out.println(i++);
			 }
			 catch(Exception e){}
			}		
					

 }
} 
package inl�mningsuppgift4;

//Ett program som loppar s� l�nge den andra tr�den lever (dvs ingen stop har intr�ffats)
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
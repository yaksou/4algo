package inl�mningsuppgift4;

import java.util.*;

	// En tr�d som lysnar p� input fr�n tangentbordet
	// Om stop mattas in avbryts tr�den
 public class KnappLyssnare extends Thread
 {
    public KnappLyssnare()
    {
    }
 
    public void run()
    {
       String k="";
       Scanner scan = new Scanner( System.in);
       while(!(k =scan.next()).equals("stop"))
       {
       
       
          try{
             Thread.sleep(100);
          
          }
             catch( Exception e){System.out.println(e);}
       
       }
       System.out.println("hej d�");
       
    }
 	   
 		
 }
package inlämningsuppgift4;

import java.util.*;

	// En tråd som lysnar på input från tangentbordet
	// Om stop mattas in avbryts tråden
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
       System.out.println("hej då");
       
    }
 	   
 		
 }
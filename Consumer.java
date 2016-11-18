package inlämningsuppgift4;

import java.io.*;
import java.util.*;

public class Consumer extends Thread {
	DataBuffert process;
	int portnr;
	Random gen = new Random();
	private int count = 0;
	private int stop = -2;
	private DataOutputStream data; 
	
	public Consumer(DataBuffert data, int nr) {
		process = data;
		portnr = nr;

	}

	public void run() {
		
		while (process.size() >stop) {
			try {
				
				sleep(10);
				data = new DataOutputStream(new FileOutputStream("Dataprinted.txt"));
			
				
				if (process.isFull()) {
					while (count < 10) {
						data.writeUTF(" Tömer kö " + process.dequeue().toString());
						count++;
					}
				
					count = 0;
					stop++;
					data.close();
				}
				
				sleep(1000);

			} 
			catch (Exception e) {
				System.out.println("FML" + e.toString());
			}
		}

	}
}

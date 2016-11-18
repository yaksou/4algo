package inlämningsuppgift4;

import java.util.*;

public class Producer extends Thread {
	DataBuffert process;
	int count = 0;
	Random gen = new Random();

	public Producer(DataBuffert data) {
		process = data;
	}

	public void run() {

		while (count < 20) {
			if (!process.isFull()) {
				process.enqueue(new Integer(gen.nextInt(100)));
				System.out.println(" Storlek buffer " + process.size());
				count++;
			}
			try {
				sleep(gen.nextInt(100) * 10);
				
			} 
			catch (InterruptedException e) {
				
			}

		}
	}

	public static void main(String[] arg) {
		DataBuffert ko = new DataBuffert();
		Producer data = new Producer(ko);
		data.start();
		Consumer port1 = new Consumer(ko, 1);
		port1.start();
	}
}
